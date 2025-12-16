package com.example.dea.MyBooksSql.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booksAuthorDetails")
public class BooksAuthorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surName;
    private Integer age;

    public BooksAuthorDetails(Integer id, String name, String surName, Integer age) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @OneToOne()
    @JoinColumn(name = "authorId")
    private Books books;
}
