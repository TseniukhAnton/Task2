package com.softserveacademy.task2.service;

import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.model.Article;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    Article register(Article article);

    Article findById(UUID id);

    List<Article> findAll();

    Article saveArticle(Article article);

    void deleteById(UUID id);

    Article getByName(String name);
}
