package com.saran.Book_store_server.Services;

import com.saran.Book_store_server.Models.BookModel;
import com.saran.Book_store_server.Repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<List<BookModel>> getAllBooks() {
        try {
            List<BookModel> books = bookRepository.findAll();
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<String> AddBook(BookModel book) {
        try {
            BookModel savedBook = bookRepository.save(book);
            return new ResponseEntity<>("Book Saved Successfully", HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
