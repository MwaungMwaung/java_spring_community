package com.example.Spring_Community.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
  
    public void patch(Article upEntity) {
        if(upEntity.getTitle() != null)
            this.title = upEntity.getTitle();
        if(upEntity.getContent() != null)
            this.content = upEntity.getContent();
    }

}
