package com.softserveacademy.task2.service;

import com.softserveacademy.task2.converters.ArticleConverter;
import com.softserveacademy.task2.dto.ArticleDto;
import com.softserveacademy.task2.model.Article;
import com.softserveacademy.task2.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleConverter articleConverter;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, ArticleConverter articleConverter) {
        this.articleRepository = articleRepository;
        this.articleConverter = articleConverter;
    }

    public ArticleDto findById(Long id) {
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
        Article article1 = articleRepository.save(article);
        return articleConverter.convert(article1);
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }
}
