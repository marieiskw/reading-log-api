package com.example.reading_log_api.service;

import com.example.reading_log_api.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public List<Book> getBooks() {
        return List.of(new Book(1L, "Effective Java", "Joshua Bloch"),
                new Book(2L, "aaa Code", "Robert C. Martin"));
    }
}
