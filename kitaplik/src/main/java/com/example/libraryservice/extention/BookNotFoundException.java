package com.example.libraryservice.extention;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException(String s) {
		super(s);
	}

}
