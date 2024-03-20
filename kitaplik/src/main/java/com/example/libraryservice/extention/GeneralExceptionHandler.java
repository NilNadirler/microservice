package com.example.libraryservice.extention;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
   
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?>handle(BookNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(LibraryNotFoundError.class)
	public ResponseEntity<?>handle(LibraryNotFoundError exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
		
		
	}
}
