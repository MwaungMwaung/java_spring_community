package com.example.Spring_Community.repository;

import com.example.Spring_Community.entity.Article;
import com.example.Spring_Community.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        {
            Long articleId = 4L;
            // expected
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L, article, "Park", "굿 윌 헌팅");
            Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
            Comment c = new Comment(3L, article, "Choi", "쇼생크 탈출");
            List<Comment> expected = Arrays.asList(a, b, c);
            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);
            // compare
            assertEquals(expected.toString(), actual.toString());
        }
        {
            Long articleId = 1L;
            // expected
            Article article = new Article(1L, "가가가가", "1111");
            List<Comment> expected = Arrays.asList();
            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);
            // compare
            assertEquals(expected.toString(), actual.toString(), "1번 글은 댓글이 없음");
        }
    }

    @DisplayName("특정 닉네임의 모든 댓글 조회")
    @Test
    void findByNickname() {
        {
            String nickname = "Park";
            Comment a = new Comment(1L, new Article(4L, "당신의 인생 영화는?", "댓글 고"), "Park", "굿 윌 헌팅");
            Comment b = new Comment(4L, new Article(5L, "당신의 소울 푸드는?", "댓글 고고"), "Park", "치킨");
            Comment c = new Comment(7L, new Article(6L, "당신의 취미는?", "댓글 고고고"), "Park", "조깅");
            // expected
            List<Comment> expected = Arrays.asList(a, b, c);
            // actual
            List<Comment> actual = commentRepository.findByNickname("Park");
            // compare
            assertEquals(expected.toString(), actual.toString(), "Park의 모든 댓글을 출력!");
        }
    }
}