package com.example.libraryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.libraryservice.dto.BookDto;
import com.example.libraryservice.dto.BookIdDto;


@FeignClient(name="book-service", path="/v1/book")
public interface BookServiceClient {
	
	@GetMapping("/isbn/{isbn}")
	public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable String isbn);

	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable  String id);

}
