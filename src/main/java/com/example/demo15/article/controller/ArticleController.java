package com.example.demo15.article.controller;

import com.example.demo15.article.dto.ArticleDTO;
import com.example.demo15.article.entity.Article;
import com.example.demo15.article.request.ArticleCreateRequest;
import com.example.demo15.article.request.ArticleModifyRequest;
import com.example.demo15.article.response.ArticleCreateResponse;
import com.example.demo15.article.response.ArticleModifyResponse;
import com.example.demo15.article.response.ArticleResponse;
import com.example.demo15.article.response.ArticlesResponse;
import com.example.demo15.article.service.ArticleService;
import com.example.demo15.global.RsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/article", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@Tag(name = "ApiArticleController", description = "REST API CRUD")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("")
    @Operation(summary = "게시글 다건 조회")
    public RsData<ArticlesResponse> getList(){
        List<ArticleDTO> articleDTOList = this.articleService.getList();
        return RsData.of("200","다건 조회 성공", new ArticlesResponse(articleDTOList));
    }
    @GetMapping("/{id}")
    @Operation(summary = "게시글 단건 조회")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id){
        Article article = this.articleService.getArticle(id);
        ArticleDTO articleDTO = new ArticleDTO(article);
        return RsData.of("200","단건 조회 성공", new ArticleResponse(articleDTO));
    }
    @PostMapping("")
    @Operation(summary = "게시글 등록")
    public RsData<ArticleCreateResponse> write(@Valid @RequestBody ArticleCreateRequest articleCreateRequest){
        Article article = this.articleService.write(articleCreateRequest.getSubject(),articleCreateRequest.getContent());
        return RsData.of("200", "등록 성공", new ArticleCreateResponse(article));
    }
    @PatchMapping("/{id}")
    @Operation(summary = "게시글 수정")
    public RsData<ArticleModifyResponse> modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest){
        Article article = this.articleService.getArticle(id);
        if (article == null) return RsData.of(
                "500",
                "%d번 게시물이 없습니다.".formatted(id),
                null
        );
        this.articleService.modify(article,articleModifyRequest.getSubject(),articleModifyRequest.getContent());
        return RsData.of("200","수정 성공",new ArticleModifyResponse(article));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제")
    public RsData<ArticleResponse> delete(@PathVariable("id") Long id){
        Article article = this.articleService.getArticle(id);
        if (article == null){
            return RsData.of("500","%d번 게시물이 없습니다.".formatted(id),null);
        }
        this.articleService.delete(article);
        ArticleDTO articleDTO = new ArticleDTO(article);
        return RsData.of("200","삭제 성공", new ArticleResponse(articleDTO));
    }
}
