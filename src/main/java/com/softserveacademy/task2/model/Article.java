package com.softserveacademy.task2.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userId")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
}
