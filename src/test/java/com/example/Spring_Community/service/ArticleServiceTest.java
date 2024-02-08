package com.example.Spring_Community.service;

import com.example.Spring_Community.dto.ArticleForm;
import com.example.Spring_Community.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<>(Arrays.asList(a, b, c));
        // 2. 실제 데이터
        List<Article> actual = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void show_success_exist_ID() {
        // 1. 기대값
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 2. 실제값
        Article actual = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void show_fail_unexist_ID() {
        // 예상값
        Long id = -1L;
        Article expected = null;
        // 실제값
        Article actual = articleService.show(id);
        // 비교 및 검증
        assertEquals(expected, actual);
    }

    @Test
    @Transactional
    void create_success_contain_titleContent() {
        // 예상 데이터
        String title = "커피를 마시면";
        String content = "왠지 한숨이 나와";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 실제 데이터
        Article actual = articleService.create(dto);
        // 비교 및 검증
        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void create_fail_contain_id() {
        // 예상 데이터
        Long id = 4L;
        String title = "커피를 마시면";
        String content = "왠지 한숨이 나와";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 실제 데이터
        Article actual = articleService.create(dto);
        // 비교 및 검증
        assertEquals(expected, actual);
    }
    @Test
    @Transactional
    void update_success_id_exist_contain_args() {

        Long id = 1L;
        String title = "잠이 오면";
        String content = "잠을 자";
        ArticleForm dto = new ArticleForm(id, title, content);

        Article expected = new Article(id, title, content);

        Article actual = articleService.update(id, dto);

        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    @Transactional
    void update_success_id_exist_contain_title() {
        Long id = 1L;
        String title = "집이 좋아";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, null);

        Article expected = new Article(id, title, content);

        Article actual = articleService.update(id, dto);

        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void update_fail_id_unexist() {
        Long id = -1L;
        String title = "집이 좋아";
        String content = "이불 밖은 위험해";
        ArticleForm dto = new ArticleForm(id, title, content);

        Article expected = null;

        Article actual = articleService.update(id, dto);

        assertEquals(expected, actual);
    }
    @Test
    @Transactional
    void delete_success_id_exist() {
        Long id = 1L;
        String title = "가가가가";
        String content = "1111";

        Article expected = new Article(id, title, content);

        Article actual = articleService.delete(id);

        assertEquals(expected.toString(), actual.toString());
    }
    @Test
    void delete_fail_id_unexist() {
        Long id = -1L;

        Article expected = null;

        Article actual = articleService.delete(id);

        assertEquals(expected, actual);
    }
}