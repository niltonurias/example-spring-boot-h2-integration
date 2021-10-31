package io.github.niltonurias.examplespringbooth2integration.book.application;

import java.util.UUID;

public class BookDTO {
    private UUID id;
    private String name;
    private String author;

    public BookDTO(UUID id, String name, String author) {
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
