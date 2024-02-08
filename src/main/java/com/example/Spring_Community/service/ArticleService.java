package com.example.Spring_Community.service;

import com.example.Spring_Community.dto.ArticleForm;
import com.example.Spring_Community.entity.Article;
import com.example.Spring_Community.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity();

        if(article.getId() != null)
            return null;

        return articleRepository.save(dto.toEntity());
    }

    public Article update(Long id, ArticleForm dto) {
        Article upArticle = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);

        if(!upArticle.getId().equals(id) || target == null) {
            log.info("잘못된 요청! id: "+ id + "up: " + upArticle + "target: " + target);
            return null;
        }
        target.patch(upArticle);
        return articleRepository.save(target);
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target != null)
            articleRepository.deleteById(id);

        return target;
    }
    @Transactional
    public List<Article> transactionTest(List<ArticleForm> dtos) {
        // 1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        // 2. 엔티티 묶음을 DB에 저장하기
        articleList.stream()
                .forEach(article -> articleRepository.save(article));
        // 3. 강제 예외 발생시키기
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패!"));
        // 4. 결과 값 반환하기
        return articleList;
    }
}
