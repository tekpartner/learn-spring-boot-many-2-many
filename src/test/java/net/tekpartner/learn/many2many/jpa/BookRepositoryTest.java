package net.tekpartner.learn.many2many.jpa;

import net.tekpartner.learn.many2many.persistence.model.Book;
import net.tekpartner.learn.many2many.persistence.model.Owner;
import net.tekpartner.learn.many2many.persistence.model.Publisher;
import net.tekpartner.learn.many2many.repositories.jpa.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Chandrashekar R. Gaajula
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    Book testBook;
    Publisher testPublisher;
    Owner testOwner;

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private BookRepository bookRepository;

    @Before
    public void setup() {
        // given

        testPublisher = new Publisher();
        testPublisher.setName("Publisher 5");
        testPublisher.setDescription("Publisher Description 5");
//        testPublisher.setBooks(new HashSet<>(Arrays.asList(testBook)));
        entityManager.persist(testPublisher);

        testOwner = new Owner();
        testOwner.setName("Owner 5");
//        testOwner.setBooks(new HashSet<>(Arrays.asList(testBook)));
        entityManager.persist(testOwner);

        testBook = new Book();
        testBook.setName("Book 5");
        testBook.setIsbn("978-0743246265");
        testBook.setPublishers(new HashSet<>(Arrays.asList(testPublisher)));
        testBook.setOwners(new HashSet<>(Arrays.asList(testOwner)));

        entityManager.persist(testBook);
        entityManager.flush();
    }

    /************************************************************************************************************
     * Test the Finders
     ************************************************************************************************************/

    @Test
    public void whenFindById_thenReturnBook() {
        Optional<Book> fromDb = bookRepository.findById(testBook.getId());
        assertThat(fromDb.get().getId()).isEqualTo(testBook.getId());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        Optional<Book> fromDb = bookRepository.findById(-11L);
        assertThat(fromDb).isEqualTo(Optional.empty());
    }

    @Test
    public void whenFindByIsbn_thenReturnBook() {
        Optional<Book> fromDb = bookRepository.findByIsbn(testBook.getIsbn());
        assertThat(fromDb.get().getId()).isEqualTo(testBook.getId());
    }

    @Test
    public void whenInvalidUuid_thenReturnNull() {
        Optional<Book> fromDb = bookRepository.findByIsbn("XXXXX");
        assertThat(fromDb).isEqualTo(Optional.empty());
    }

    @Test
    public void givenSetOfBooks_whenFindAll_thenReturnAllBooks() {
        List<Book> allBooks = bookRepository.findAll();

        assertThat(allBooks)
                .extracting(Book::getIsbn)
                .contains(
                        "978-0743246261",
                        "978-0743246262",
                        "978-0743246263",
                        "978-0743246264",
                        "978-0743246265");
    }

    /************************************************************************************************************
     * Test the Create
     ************************************************************************************************************/

    @Test(expected = DataIntegrityViolationException.class)
    public void givenBookHasMissingName_thenThrow_ConstraintViolationException() {
        // given
        testBook = new Book();
        testBook.setIsbn("978-0743246266");

        //when
        bookRepository.saveAndFlush(testBook);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void givenBookHasMissingIsbn_thenThrow_ConstraintViolationException() {
        // given
        testBook = new Book();
        testBook.setName("Book 6");

        //when
        bookRepository.saveAndFlush(testBook);
    }

    @Test
    public void whenValidBook_thenSaveBook() {
        Optional<Book> foundBook = bookRepository.findByIsbn("978-0743246265");
        assertThat(foundBook.get().getName()).isEqualTo(testBook.getName());
        assertThat(foundBook.get().getOwners().size() == 1);
        assertThat(foundBook.get().getOwners().contains(testOwner));
        assertThat(foundBook.get().getPublishers().size() == 1);
        assertThat(foundBook.get().getPublishers().contains(testPublisher));
    }
}