package com.example.reading_log_api.exception;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException(String title, String author){
        super("Book already exists: " + title + ", " + author);
    }
}
