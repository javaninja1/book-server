package com.book.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.server.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
