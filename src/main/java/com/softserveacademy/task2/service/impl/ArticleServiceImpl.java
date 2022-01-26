package com.softserveacademy.task2.service.impl;

import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.model.Article;
import com.softserveacademy.task2.model.Status;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.repository.ArticleRepository;
import com.softserveacademy.task2.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article register(Article article) {
        article.setName(article.getName());
        article.setText(article.getText());
        article.setUser(article.getUser());

        Article registeredArticle = articleRepository.save(article);
        log.info("IN register - user: {} successfully registered", registeredArticle);

        return registeredArticle;
    }

    public Article findById(UUID id) {
        return articleRepository.findById(id).orElse(null);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article saveArticle(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    public void deleteById(UUID id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article getByName(String name) {
        return articleRepository.findByName(name);
    }
}
