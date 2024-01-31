package com.example.Spring_Community.repository;

import com.example.Spring_Community.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
