package mate.academy.springbootintro.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import java.util.List;
import mate.academy.springbootintro.exeption.DataProcessingException;
import mate.academy.springbootintro.model.Book;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    private final EntityManagerFactory entityManagerFactory;

    public BookRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Book save(Book book) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            if (book.getId() == null) {
                em.persist(book);
            } else {
                book = em.merge(book);
            }
            em.getTransaction().commit();
            return book;
        } catch (PersistenceException e) {
            throw new DataProcessingException("Unable to save book: " + book, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT b FROM Book b", Book.class)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new DataProcessingException("Unable to retrieve books", e);
        }
    }
    }

