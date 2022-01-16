package com.softserveacademy.task2.repository;

import com.softserveacademy.task2.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
