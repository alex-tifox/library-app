package pl.ncdc.work.test.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    private BookRepo bookRepo;
    @Autowired
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    private List<Book> books = new ArrayList<>();

    @GetMapping("/listPage")
    public String getAllBooks(Model model){
        books = (List)this.bookRepo.findAll();
        if (books.isEmpty()){
            return "noRecordsFound";
        } else {
            model.addAttribute("books", books);
            return "listPage";
        }
    }

}
