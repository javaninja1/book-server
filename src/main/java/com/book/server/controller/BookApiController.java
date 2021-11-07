package com.book.server.controller;

import java.util.Collection;
import java.util.stream.Collectors;


import com.book.server.model.Book;
import com.book.server.service.BookService;
import com.book.server.view.BookRequest;
import com.book.server.view.BookResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import com.book.server.repository.BookRepository;

@CrossOrigin ( origins = "http://localhost:3000")
@RestController


public class BookApiController implements BookApi {
	
	private final BookRepository bookRepository;
	private final BookService bookService;
	private ModelMapper modelMapper;

	public BookApiController(BookRepository bookRepository,
							 BookService bookService, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.bookService = bookService;
		this.modelMapper = modelMapper;
	}


	@Override
	public ResponseEntity<BookResponse> findById(long id) throws Exception {
		Book book = bookRepository.findById(id).orElse(new Book());
		return new ResponseEntity<>(modelMapper.map(book, BookResponse.class), HttpStatus.OK);
	}

	@Override
	public Collection<BookResponse> findBooks() {
		return bookRepository.findAll().stream()
				.map(e -> modelMapper.map(e,BookResponse.class)).collect(Collectors.toList());
	}

	@Override
	public Book updateBook(long id, BookRequest book) {
		return null;
	}

	@Override
	public ResponseEntity<BookResponse> putBook(long id, BookRequest body) {
		Book book = bookService.update(modelMapper.map(body, Book.class), id);
		return new ResponseEntity<>(
				modelMapper.map(book, BookResponse.class),
				HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<BookResponse> postBook(BookRequest body)  {
		Book book = bookRepository.save( modelMapper.map(body, Book.class));
		return new ResponseEntity<>(
				modelMapper.map(book, BookResponse.class),
				HttpStatus.CREATED);
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
}
