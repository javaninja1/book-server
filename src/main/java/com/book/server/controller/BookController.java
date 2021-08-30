package com.book.server.controller;

import java.util.List;

import com.book.server.model.Author;
import com.book.server.model.Book;
import com.book.server.repository.AuthorRepository;
import com.book.server.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.book.server.repository.BookRepository;

@CrossOrigin ( origins = "http://localhost:3000")
@RestController
@RequestMapping (path = "api")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

//	@GetMapping ("books")
//	public List<BookResponse> getBooks() {
//		return bookRepository.getBookAuthors();
//	}

	@GetMapping ("books")
	public List<BookResponse> getBooks() {
		return bookRepository.getBookAuthors();
	}

	@PostMapping("book")
	public void addNewBook(@RequestBody Book book) {
		Author author = authorRepository.getById(book.getAuthorId());
		book.setAuthor(author);
		bookRepository.save(book);
	}

	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}

	@PutMapping ("/books/{id}")
	Book addOrUpdateBook(@RequestBody Book newBook, @PathVariable Long id ) {
		return bookRepository.findById(id)
				.map(book -> {
					 book.setTitle(newBook.getTitle());
					 return bookRepository.save(book);
				}).orElseGet( ()  -> {
						newBook.setId(id);
						return bookRepository.save(newBook);
				});
	}

}
