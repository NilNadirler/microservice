package com.example.libraryservice.extention;

public class LibraryNotFoundError extends RuntimeException {

	public LibraryNotFoundError(String s) {
		super(s);
	}
}
