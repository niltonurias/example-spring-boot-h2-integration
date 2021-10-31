package io.github.niltonurias.examplespringbooth2integration.book.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String author;

    public Book() {
    }

    public Book(UUID id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
