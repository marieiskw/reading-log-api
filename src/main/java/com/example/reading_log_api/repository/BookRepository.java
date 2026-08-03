package com.example.reading_log_api.repository;

import com.example.reading_log_api.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> booksList = new ArrayList<>();

    public BookRepository() {
        save(new Book(1L, "Effective Java", "Joshua Bloch"));
        save(new Book(2L, "aaa Code", "Robert C. Martin"));
    }

    public List<Book> findAll() {
        return booksList;
    }

    public Book findById(Long id) {
        for(Book book : booksList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book save(Book book) {
        booksList.add(book);
        return book;
    }
}
