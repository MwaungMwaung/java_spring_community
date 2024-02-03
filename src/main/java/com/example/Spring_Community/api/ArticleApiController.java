package com.example.Spring_Community.api;

import com.example.Spring_Community.dto.ArticleForm;
import com.example.Spring_Community.entity.Article;
import com.example.Spring_Community.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }
    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article articleEntity = dto.toEntity();
        articleRepository.save(articleEntity);
        return articleEntity;
    }
    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article upEntity = dto.toEntity();
        log.info("id: {}, article: {}", id, upEntity.toString());

        Article targetEntity = articleRepository.findById(id).orElse(null);
        if(targetEntity == null || upEntity.getId() != id) {
            log.info("잘못된 요청! id: {}, article: {}", id, upEntity.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        targetEntity.patch(upEntity);
        Article updated = articleRepository.save(targetEntity);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }
    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        articleRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build(); // = body(null)
    }
}
