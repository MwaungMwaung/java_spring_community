package com.example.Spring_Community.dto;

import com.example.Spring_Community.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null,title,content);
    }
}
