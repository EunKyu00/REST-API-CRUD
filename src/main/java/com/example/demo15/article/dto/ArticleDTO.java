package com.example.demo15.article.dto;

import com.example.demo15.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class ArticleDTO {
    private final Long id;
    private final String subject;
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime modifiedDate;

    public ArticleDTO(Article article){
        this.id = article.getId();
        this.subject = article.getSubject();
        this.content = article.getContent();
        this.createDate = article.getCreateDate();
        this.modifiedDate = article.getModifiedDate();
    }
}
