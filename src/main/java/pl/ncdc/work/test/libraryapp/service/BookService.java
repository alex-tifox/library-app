package pl.ncdc.work.test.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;

import java.util.logging.Logger;

@Service
public class BookService {

    private final Logger logger = Logger.getLogger(BookService.class.getName());

    private BookRepo bookRepo;
    @Autowired
    public BookService(BookRepo bookRepo) { this.bookRepo = bookRepo; }

    public void saveBook(Book book) {
        logger.info("Saving Book:\n" + book.toString());
        this.bookRepo.save(book);
        logger.info("Book saved successfully");
    }

    public Iterable<Book> getBooks() {
        logger.info("Getting all books from repository...");
        return this.bookRepo.findAll();
    }
}
