package pl.ncdc.work.test.libraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.ncdc.work.test.libraryapp.model.Book;
import pl.ncdc.work.test.libraryapp.model.BookForm;
import pl.ncdc.work.test.libraryapp.repository.BookRepo;
import pl.ncdc.work.test.libraryapp.service.BookService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {this.bookService = bookService; }

    private List<Book> books = new ArrayList<>();

    @GetMapping("/listPage")
    public String getAllBooks(Model model){
        books = (List)bookService.getBooks();
        if (books.isEmpty()){
            return "noRecordsFound";
        } else {
            model.addAttribute("books", books);
            return "listPage";
        }
    }

    @GetMapping("/addPage")
    public String showAddBookPage(Model model) {
        BookForm bookForm = new BookForm();
        model.addAttribute("bookForm", bookForm);

        return "addPage";
    }

    @PostMapping("/addPage")
    public String saveBook(Model model,
                           @ModelAttribute("bookForm") BookForm bookForm) {

        Book book = new Book(bookForm.getTitle(), bookForm.getAuthor(), bookForm.getIsbn());
        bookService.saveBook(book);

        return "redirect:/listPage";
    }



}
