package com.softserveacademy.task2.exception;

public class ArticleNotFoundException extends RuntimeException{

    public ArticleNotFoundException(String name) {
        super(String.format("Article with name %name not found", name));
    }
}
