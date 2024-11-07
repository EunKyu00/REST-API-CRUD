package com.example.demo15.article.response;

import com.example.demo15.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleModifyResponse {
    private Article article;
}
