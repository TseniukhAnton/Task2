package com.softserveacademy.task2.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column (name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "user_Id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "text")
    private String text;
}
