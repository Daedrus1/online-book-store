package mate.academy.springbootintro;

import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringbootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntroApplication.class, args);
    }

    @Profile("!test")
    @Bean
    public CommandLineRunner demo(BookRepository bookRepository) {
        return args -> {
            Book book = new Book();
            book.setTitle("Spring in Action");
            book.setAuthor("Craig Walls");
            bookRepository.save(book);

            System.out.println("Books in DB: " + bookRepository.findAll());
        };
    }
}
