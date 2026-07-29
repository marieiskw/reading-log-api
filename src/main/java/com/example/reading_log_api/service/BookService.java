package com.example.reading_log_api.service;

import com.example.reading_log_api.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> booksList = new ArrayList<>();

    public BookService() {
        booksList.add(new Book(1L, "Effective Java", "Joshua Bloch"));
        booksList.add(new Book(2L, "aaa Code", "Robert C. Martin"));
    }

    public List<Book> getBooks() {
        return booksList;
    }

    public Book getBookById(Long id) {
        for(Book book : getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book createBook(Book book) {
        Long nextId = booksList.size() + 1L;
        Book newBook = new Book(nextId, book.getTitle(), book.getAuthor());
        booksList.add(newBook);

        return newBook;
    }
}
