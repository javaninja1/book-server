package com.book.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.server.model.Book;
import com.book.server.repository.BookRepository;

@SpringBootApplication
public class BookServerApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookServerApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book(1, "book1", "author1"));
		bookRepository.save(new Book(2, "book2", "author2"));
		bookRepository.save(new Book(3, "book3", "author2"));
	}
	

}
