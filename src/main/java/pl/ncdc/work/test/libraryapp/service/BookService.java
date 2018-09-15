package pl.ncdc.work.test.libraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;


@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Iterable<Book> getAllBooks(){
        return this.bookRepo.findAll();
    }
}
