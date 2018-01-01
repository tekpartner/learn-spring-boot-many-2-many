package net.tekpartner.learn.many2many.controller;

import lombok.extern.log4j.Log4j2;
import net.tekpartner.learn.many2many.persistence.model.Book;
import net.tekpartner.learn.many2many.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Chandrashekar R. Gaajula
 */
@RestController
@RequestMapping(value = "books")
@Log4j2
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController() {
    }

    @GetMapping("/isbn/{isbn}")
    @Transactional(readOnly = true)
    public Book findByIsbn(
            @PathVariable final String isbn) {
        Optional<Book> foundBook = bookService.findByIsbn(isbn);
        return foundBook.orElse(null);
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findByAll();
    }
}
