package pl.ncdc.work.test.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;
import pl.ncdc.work.test.libraryapp.service.BookService;

@RestController
public class RestBookController {

    private BookService bookService;
    @Autowired
    public RestBookController(BookService bookService) {this.bookService = bookService; }

    @GetMapping("/getAllBooks")
    public Iterable<Book> getAllBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/saveBook")
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }
}
