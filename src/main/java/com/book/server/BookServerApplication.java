package com.book.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.server.model.Book;
import com.book.server.repository.BookRepository;

@SpringBootApplication
public class BookServerApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.save(new Book(2,"book1", "Author1"));
		bookRepository.save(new Book(3,"book2", "Author2"));
		bookRepository.save(new Book(4,"book3", "Author3"));
	}
	

}
