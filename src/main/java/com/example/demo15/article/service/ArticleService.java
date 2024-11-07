package com.example.demo15.article.service;

import com.example.demo15.article.dto.ArticleDTO;
import com.example.demo15.article.entity.Article;
import com.example.demo15.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<ArticleDTO> getList(){
        List<Article> articleList = this.articleRepository.findAll();
        List<ArticleDTO> articleDTOList = articleList.stream()
                .map(article -> new ArticleDTO(article))
                .collect(Collectors.toList());
        return articleDTOList;
    }
    public Article getArticle(Long id){
        Optional<Article> optionalArticle = this.articleRepository.findById(id);
        return optionalArticle.orElse(null);
    }
    public Article write(String subject, String content){
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        return this.articleRepository.save(article);
    }
    public Article modify(Article article, String subject, String content){
        article.setSubject(subject);
        article.setContent(content);
        this.articleRepository.save(article);
        return article;
    }
    public void delete(Article article){
        this.articleRepository.delete(article);
    }
}
