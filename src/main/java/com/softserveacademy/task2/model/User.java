package com.softserveacademy.task2.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator (name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column (name = "id", updatable = false, nullable = false, columnDefinition = "char")
    private UUID id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    private Set<Article> articles;
}
