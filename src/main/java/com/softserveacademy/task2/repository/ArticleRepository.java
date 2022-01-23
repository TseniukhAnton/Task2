package com.softserveacademy.task2.repository;

import com.softserveacademy.task2.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
     @Query("select b from Article b where b.name = :name")
     Article findByName(@Param("name") String name);
}
