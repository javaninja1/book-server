package com.book.server;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.book.server.model.Book;
import com.book.server.repository.BookRepository;
import com.book.server.service.BookService;
import com.book.server.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BookTest {

    @Mock
    BookRepository bookRepository;


    @InjectMocks
    private BookService bookService = new BookServiceImpl(bookRepository);

    @Test
    public void getUser() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(new Book()));
        Optional<Book> book = bookService.findById(1L);
        Assertions.assertNotNull(book);
        verify(bookRepository).findById(1L);
    }

}
