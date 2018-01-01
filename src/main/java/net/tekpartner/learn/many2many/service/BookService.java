package net.tekpartner.learn.many2many.service;

import net.tekpartner.learn.many2many.persistence.model.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author Chandrashekar R. Gaajula
 */
public interface BookService {

    List<Book> findByAll();

    Optional<Book> findByIsbn(String isbn);
}
