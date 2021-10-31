package io.github.niltonurias.examplespringbooth2integration.book.application;

import io.github.niltonurias.examplespringbooth2integration.book.domain.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class BookAssembly {
    public List<Book> toEntity(List<BookDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(toList());
    }

    public Book toEntity(BookDTO dto) {
        return new Book(dto.getId(), dto.getName(), dto.getAuthor());
    }

    public List<BookDTO> toDTO(List<Book> books) {
        return books.stream().map(this::toDTO).collect(toList());
    }

    public BookDTO toDTO(Book book) {
        return new BookDTO(book.getId(), book.getName(), book.getAuthor());
    }

    public Book merge(Book bookOld, Book book) {
        bookOld.setName(book.getName());
        bookOld.setAuthor(book.getAuthor());
        return bookOld;
    }

}
