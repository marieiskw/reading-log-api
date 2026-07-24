package com.example.reading_log_api.controller;
import com.example.reading_log_api.entity.Book;

import com.example.reading_log_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookId(@PathVariable Long id) {
        return bookService.getBookId(id);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

}