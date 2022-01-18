package com.softserveacademy.task2.repository;

import com.softserveacademy.task2.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
}
