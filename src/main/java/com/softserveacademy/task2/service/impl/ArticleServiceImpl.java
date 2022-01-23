package com.softserveacademy.task2.service.impl;

import com.softserveacademy.task2.converters.ArticleConverter;
import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.dto.UserDto;
import com.softserveacademy.task2.model.Article;
import com.softserveacademy.task2.model.User;
import com.softserveacademy.task2.repository.ArticleRepository;
import com.softserveacademy.task2.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository, ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    public ArticleDto findById(UUID id) {
        Article article = articleRepository.findById(id).orElse(null);
        ArticleConverter converter = new ArticleConverter();
        assert article != null;
        return converter.convert(article);
    }

    public List<ArticleDto> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(articleConverter::convert).toList();
    }

    public ArticleDto saveArticle(Article article) {
        Article article1 = articleRepository.saveAndFlush(article);
        return articleConverter.convert(article1);
    }

    public void deleteById(UUID id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDto getByName(String name) {
        Article articleByName = articleRepository.findByName(name);
        return articleConverter.convert(articleByName);
    }
}
