package com.example.demo15.article.response;

import com.example.demo15.article.dto.ArticleDTO;
import com.example.demo15.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ArticleResponse {
    private ArticleDTO article;
}
