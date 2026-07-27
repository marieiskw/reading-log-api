package com.example.reading_log_api.service;

import com.example.reading_log_api.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> booksList = new ArrayList<Book>();

    public BookService() {
        booksList.add(new Book(1L, "Effective Java", "Joshua Bloch"));
        booksList.add(new Book(2L, "aaa Code", "Robert C. Martin"));
    }

    public List<Book> getBooks() {
        return booksList;
    }

    public Book getBookId(Long id) {
        for(Book book : getBooks()) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book createBook(Book book) {
        Long nextId = booksList.size() + 1L;
        Book newBook = new Book();
        newBook.setId(nextId);
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        booksList.add(newBook);

        return newBook;
    }
}
