package com.example.Spring_Community.dto;

public class ArticleForm {
    private String title;
    private String content;

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    // 전송받은 제목과 내용을 필드에 저장하는 생성자.
    public ArticleForm(String title, String content) {


        this.title = title;
        this.content = content;
    }
}
