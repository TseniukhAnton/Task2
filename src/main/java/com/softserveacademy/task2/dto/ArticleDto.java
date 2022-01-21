package com.softserveacademy.task2.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ArticleDto {
    private UUID id;
    private String name;
    private String text;
    private String userName;
}
