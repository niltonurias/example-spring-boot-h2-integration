package io.github.niltonurias.examplespringbooth2integration.book.application;

import io.github.niltonurias.examplespringbooth2integration.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public List<BookDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO book) {
        return service.create(book);
    }

    @PutMapping("/{id}")
    public BookDTO update(@PathVariable UUID id, @RequestBody BookDTO book) {
        return service.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
