package com.book.server;

import com.book.server.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.server.model.Book;
import com.book.server.repository.BookRepository;
import com.book.server.repository.AuthorRepository;

@SpringBootApplication
public class BookServerApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;


	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Author author1 = authorRepository.save(new Author("Author1"));
		Author author2 = authorRepository.save(new Author("Author2"));

		bookRepository.save(new Book(2,"book1", author1));
		bookRepository.save(new Book(3,"book2", author2));
		bookRepository.save(new Book(4,"book3", author2));
	}
	

}
