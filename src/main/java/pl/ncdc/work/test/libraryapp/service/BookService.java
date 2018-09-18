package pl.ncdc.work.test.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ncdc.work.test.libraryapp.filter.AuthorNamePattern;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;

import java.util.ArrayList;
import java.util.logging.Logger;

@Service
public class BookService {

    private final Logger logger = Logger.getLogger(BookService.class.getName());

    private BookRepo bookRepo;
    @Autowired
    public BookService(BookRepo bookRepo) { this.bookRepo = bookRepo; }

    // Save book including author's name
    public boolean saveBook(Book book) {

        logger.info("Saving Book:\n" + book.toString());
        if (AuthorNamePattern.isAuthorNamePattern(book.getAuthor())) {
            this.bookRepo.save(book);
            logger.info("Book saved successfully");
            return true;
        } else {
            logger.info("Author name is uncorrect.. Save rejected");
            return false;
        }
    }

    public Iterable<Book> getBooks() {
        logger.info("Getting all books from repository...");

        if (this.bookRepo.findAll() != null){
            logger.info("Books founded..");
            return this.bookRepo.findAll();
        } else {
            logger.info("No books in repository.. empty list is on it's way");
            return new ArrayList<>();
        }
    }
}
