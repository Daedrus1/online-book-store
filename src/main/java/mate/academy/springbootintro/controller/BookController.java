package mate.academy.springbootintro.controller;

import java.util.List;
import mate.academy.springbootintro.model.Book;
import mate.academy.springbootintro.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll() {
        return service.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return service.save(book);
    }
}
