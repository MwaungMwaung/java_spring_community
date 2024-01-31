package com.example.Spring_Community.dto;

import com.example.Spring_Community.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    // 전송받은 제목과 내용을 필드에 저장하는 생성자.
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


    public Article toEntity() {
        return new Article(null,title,content);
    }
}
