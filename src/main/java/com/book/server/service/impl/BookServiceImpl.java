package com.book.server.service.impl;


import com.book.server.model.Book;
import com.book.server.repository.BookRepository;
import com.book.server.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book update(Book newBook, Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    return bookRepository.save(newBook);
                });
    }


}
