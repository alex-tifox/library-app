package pl.ncdc.work.test.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.service.BookService;

import java.util.logging.Logger;

@RestController
public class RestBookController {

    private final Logger logger = Logger.getLogger(RestBookController.class.getName());

    private BookService bookService;
    @Autowired
    public RestBookController(BookService bookService) {this.bookService = bookService; }

    @GetMapping("/getAllBooks")
    public Iterable<Book> getAllBooks()
    {
        logger.info("getting all books.. going to service...");
        return bookService.getBooks();
    }

    @PostMapping("/saveBook")
    public void saveBook(@RequestBody Book book)
    {
        logger.info("Saving book: "+ book.toString()+ "\n Going to service...");
        bookService.saveBook(book);
    }
}
