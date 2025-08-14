package mate.academy.springbootintro.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import java.util.List;

import mate.academy.springbootintro.exeption.DataRetrievalException;
import mate.academy.springbootintro.model.Book;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Book save(Book book) {
        try {
            if (book.getId() == null) {
                em.persist(book);
                return book;
            } else {
                return em.merge(book);
            }
        } catch (PersistenceException e) {
            throw new DataRetrievalException("Unable to save book: " + book, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return em.createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new DataRetrievalException("Unable to retrieve books", e);
        }
    }
}
