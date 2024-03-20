package com.example.libraryservice.extention;

public record ExceptionMessage(String timestamp,
		                       int status,
		                       String error,
		                       String message,
		                       String path) {

}
