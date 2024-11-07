package com.example.demo15.article.response;

import com.example.demo15.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesResponse {
    private List<ArticleDTO> article;
}
