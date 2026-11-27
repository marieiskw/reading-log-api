package com.example.reading_log_api.service;

import com.example.reading_log_api.dto.CreateBookRequest;
import com.example.reading_log_api.entity.Book;
import com.example.reading_log_api.exception.DuplicateBookException;
import com.example.reading_log_api.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testCreateBook() {

        // Given：準備
        CreateBookRequest request = new CreateBookRequest();
        request.setTitle("Java入門");
        request.setAuthor("山田太郎");

        // 重複チェック
        when(bookRepository.existsByTitleAndAuthor("Java入門", "山田太郎"))
                .thenReturn(false);

        // 登録済みの本は0件
        when(bookRepository.findAll())
                .thenReturn(List.of());

        // saveされたBookをそのまま返す
        when(bookRepository.save(any(Book.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When：実際にテスト対象の処理を実行
        Book result = bookService.createBook(request);

        // Then：結果を検証
        assertNotNull(result);
        assertEquals("Java入門", result.getTitle());
        assertEquals("山田太郎", result.getAuthor());

        verify(bookRepository).save(any(Book.class));
    }
}