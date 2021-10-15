package com.book.server.controller;

import java.util.Collection;
import java.util.Optional;


import com.book.server.model.Book;
import com.book.server.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.book.server.repository.BookRepository;

@CrossOrigin ( origins = "http://localhost:3000")
@RestController


public class BookApiController implements BookApi {
	
	private final BookRepository bookRepository;

	private final AuthorRepository authorRepository;

	public BookApiController(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}



//	@PostMapping("book")
//	public void addNewBook(@RequestBody Book book) {
//		Author author = authorRepository.getById(book.getAuthorId());
//		book.setAuthor(author);
//		bookRepository.save(book);
//	}
//
//	@PutMapping ("/books/{id}")
//	Book addOrUpdateBook(@RequestBody Book newBook, @PathVariable Long id ) {
//		return bookRepository.findById(id)
//				.map(book -> {
//					 book.setTitle(newBook.getTitle());
//					 return bookRepository.save(book);
//				}).orElseGet( ()  -> {
//						newBook.setId(id);
//						return bookRepository.save(newBook);
//				});
//	}

	@Override
	public ResponseEntity<Book> findById(long id) throws Exception {
		return new ResponseEntity<Book>(bookRepository.findById(id).orElse(new Book()), HttpStatus.OK);
	}

	@Override
	public Collection<Book> findBooks() {
		return bookRepository.findAll();
	}


	@Override
	public Book updateBook(String id, Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book patchBook(String id, Book book) {
		return bookRepository.save(book);
	}

	@Override
	public ResponseEntity<Book> postBook(Book body)  {
		return new ResponseEntity<Book>(bookRepository.save(body), HttpStatus.CREATED);
	}


	@Override
	public Book headBook(long bookId) {
		Optional<Book> byId = bookRepository.findById(bookId);
		return byId.orElse(new Book());
	}

	@Override
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
}
