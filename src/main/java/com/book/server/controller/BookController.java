package com.book.server.controller;

import java.util.List;

import com.book.server.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.server.repository.BookRepository;

@CrossOrigin ( origins = "http://localhost:3000")
@RestController
@RequestMapping (path = "api")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping ("books")
	public List<BookResponse> getBooks() {
		return bookRepository.getBookAuthors();
	}

}
