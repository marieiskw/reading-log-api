package com.example.reading_log_api.service;

import com.example.reading_log_api.dto.CreateBookRequest;
import com.example.reading_log_api.entity.Book;
import com.example.reading_log_api.repository.BookRepository;
import com.example.reading_log_api.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id);
        if(book == null) {
            throw new BookNotFoundException(id);
        }
        return book;
    }

    public Book createBook(CreateBookRequest request) {
        Long nextId = getBooks().size() + 1L;
        Book newBook = new Book(nextId, request.getTitle(), request.getAuthor());
        return bookRepository.save(newBook);
    }
}
