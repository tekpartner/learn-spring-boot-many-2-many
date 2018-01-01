package net.tekpartner.learn.many2many.service;

import net.tekpartner.learn.many2many.persistence.model.Book;
import net.tekpartner.learn.many2many.repositories.jpa.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Chandrashekar R. Gaajula
 */
@Service("bookService")
public class BookServiceImpl implements BookService {
  @Autowired
  private BookRepository bookRepository;

  @Override
  public List<Book> findByAll() {
    return bookRepository.findAll();
  }

  @Override
  public Optional<Book> findByIsbn(String isbn) {
    return bookRepository.findByIsbn(isbn);
  }
}
