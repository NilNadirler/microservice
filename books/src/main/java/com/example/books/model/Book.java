package com.example.books.model;

import com.example.books.dto.BookDto;
import com.example.books.dto.BookIdDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;


@Entity
@Table(name="books")

public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@UuidGenerator
	private String id;
	
	
	private String title;
	 

	private Integer bookYear;
	 

	private String author;


	private String pressName;
	
	private String isbn;
	
	
	
	
	
	public Book(String id, String title, Integer bookYear, String author, String pressName, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.bookYear = bookYear;
		this.author = author;
		this.pressName = pressName;
		this.isbn = isbn;
	}

	public Book() {
		
	}

	public Book(String title, Integer bookYear, String author, String pressName, String isbn) {
	
		this.title = title;
		this.bookYear = bookYear;
		this.author = author;
		this.pressName = pressName;
		this.isbn = isbn;
	}

	public BookDto getBookDto() {
		BookDto bookDto = new BookDto();
		bookDto.setId(id);
		bookDto.setBookYear(bookYear);
		bookDto.setAuthor(author);
		bookDto.setIsbn(isbn);
		bookDto.setTitle(title);
		bookDto.setPressName(pressName);
		
		return bookDto;
	}
	
	public BookIdDto getBookId() {
		BookIdDto dto = new BookIdDto();
		dto.setBookId(id);
		dto.setIsbn(isbn);
		
		return dto;
	}
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Integer getBookYear() {
		return bookYear;
	}

	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
	
	
}
