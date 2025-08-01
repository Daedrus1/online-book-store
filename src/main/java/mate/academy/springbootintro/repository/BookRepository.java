package mate.academy.springbootintro.repository;

import mate.academy.springbootintro.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
