package pl.ncdc.work.test.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;

@Service
public class BookService {

    private BookRepo bookRepo;
    @Autowired
    public BookService(BookRepo bookRepo) { this.bookRepo = bookRepo; }

    public void saveBook(Book book) {
        this.bookRepo.save(book);
    }

    public Iterable<Book> getBooks() {
        return this.bookRepo.findAll();
    }
}
