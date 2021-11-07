package com.book.server.service;

import com.book.server.model.Book;

import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long bookId);

    Book update(Book book, Long id);
}
