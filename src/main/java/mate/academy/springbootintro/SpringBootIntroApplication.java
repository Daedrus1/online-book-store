package mate.academy.springbootintro;

import java.math.BigDecimal;
import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("Spring in Action");
            book.setAuthor("Craig Walls");
            book.setIsbn("9781617294945");
            book.setPrice(BigDecimal.valueOf(39.99));
            book.setDescription("A comprehensive guide to Spring Framework");
            book.setCoverImage("cover.jpg");
            bookService.save(book);

            System.out.println("Books in DB: " + bookService.findAll());
        };
    }
}
