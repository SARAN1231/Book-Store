package com.saran.Book_store_server.Controller;

import com.saran.Book_store_server.Models.BookModel;
import com.saran.Book_store_server.Services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@CrossOrigin("*")
public class BookController {

    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/")
   public ResponseEntity<List<BookModel>> getAllBooks() {
        return  bookService.getAllBooks();

    }
    @PostMapping("add")
    public ResponseEntity<String> addBook(@RequestBody BookModel book) {
        return bookService.AddBook(book);
    }
}
