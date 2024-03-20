package com.example.books.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.books.dto.BookDto;
import com.example.books.dto.BookIdDto;
import com.example.books.exception.BookNotFoundException;
import com.example.books.model.Book;
import com.example.books.repository.BookRepository;


@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public List<BookDto> getAllBooks(){
		return bookRepository.findAll().stream()
				.map(Book::getBookDto)
				.collect(Collectors.toList());
		
	}
	
	public BookIdDto findByIsbn(String isbn) {
		 return bookRepository.findBookByIsbn(isbn)
				 .map(book -> new BookIdDto(book.getId(),book.getIsbn()))
				 .orElseThrow(()-> new BookNotFoundException("Book could not found by isbn: " +isbn));
	}
	
	public BookDto findBookDetails(String id) {
		return bookRepository.findById(id)
				.map(Book::getBookDto)
				.orElseThrow(()-> new BookNotFoundException("Book can not found id:" +id));
	}
	

	@PostConstruct
	public List<Book> create() {
		Book book1 = new Book("Dünyanın Gözü", 2000, "Robert Jordan", "İthaki Yayınevi", "123456");

		Book book2 = new Book("Yüzüklerin Efendisi", 1960, "J.R.R Tolkien", "Metis Yayıncılık", "456789");

		Book book3 = new Book("Harry Potter ve Felsefe Taşı", 1997, "J. K. Rowling", "YKB Yayınları", "987654");



	    List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	    
	    return bookList;
	}
	
	
}
 