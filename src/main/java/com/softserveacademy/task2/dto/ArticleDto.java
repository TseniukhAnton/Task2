package com.softserveacademy.task2.dto;

import com.softserveacademy.task2.model.Article;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
public class ArticleDto {
    private String id;
    private String name;
    private String text;

    public Article toEntity() {
        return Article.builder()
                .id(UUID.fromString(id))
                .name(name)
                .text(text)
                .build();
    }

    public static ArticleDto fromEntity(Article article) {
        return Objects.nonNull(article) ?
                ArticleDto.builder()
                        .name(article.getName())
                        .text(article.getText())
                        .build() : null;

    }
}
