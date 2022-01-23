package com.softserveacademy.task2.service;

import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.model.Article;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    ArticleDto findById(UUID id);
    List<ArticleDto> findAll();
    ArticleDto saveArticle(Article article);
    void deleteById(UUID id)    ;
    ArticleDto getByName(String name);
}
