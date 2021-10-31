package io.github.niltonurias.examplespringbooth2integration.book.application;

import io.github.niltonurias.examplespringbooth2integration.book.domain.Book;
import io.github.niltonurias.examplespringbooth2integration.book.domain.BookRepository;
import io.github.niltonurias.examplespringbooth2integration.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookAssembly assembly;

    public List<BookDTO> findAll() {
        return assembly.toDTO(repository.findAll());
    }

    public BookDTO findById(UUID id) {
        Optional<Book> book = repository.findById(id);
        book.orElseThrow(NotFoundException::new);

        return assembly.toDTO(book.get());
    }

    public BookDTO create(BookDTO book) {
        return assembly.toDTO(repository.save(assembly.toEntity(book)));
    }

    public BookDTO update(UUID id, BookDTO book) {
        Optional<Book> bookOld = repository.findById(id);
        bookOld.orElseThrow(NotFoundException::new);

        return assembly.toDTO(repository.save(assembly.merge(bookOld.get(), assembly.toEntity(book))));
    }

    public void delete(UUID id) {
        Optional<Book> book = repository.findById(id);
        book.orElseThrow(NotFoundException::new);

        repository.delete(book.get());
    }
}
