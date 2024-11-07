package com.example.demo15.article.response;

import com.example.demo15.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateResponse {
    private Article article;
}
