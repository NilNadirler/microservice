package com.example.books.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.dto.BookDto;
import com.example.books.dto.BookIdDto;
import com.example.books.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
@Validated
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);

	private final BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBook(){
		 return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn){
		logger.info("Book requested by isbn: " +isbn);
		return ResponseEntity.ok(bookService.findByIsbn(isbn));
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable  String id){
		return ResponseEntity.ok(bookService.findBookDetails(id));
	}
	
	
	
}
