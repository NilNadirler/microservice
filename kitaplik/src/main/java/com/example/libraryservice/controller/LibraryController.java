package com.example.libraryservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryservice.dto.AddBookRequest;
import com.example.libraryservice.dto.LibraryDto;
import com.example.libraryservice.service.LibraryService;

@RestController
@RequestMapping("v1/library")
public class LibraryController {
	
	
	Logger logger = LoggerFactory.getLogger(LibraryController.class);
	
	private final LibraryService libraryService;
	
	private final Environment environment;

	public LibraryController(LibraryService libraryService, Environment environment) {
		super();
		this.libraryService = libraryService;
		this.environment = environment;
	}
	
	@Value("${library.service.count}")
	private String count;
	
	@GetMapping("{id}")
	public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id){
		return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
	}
	
	@PostMapping
	public ResponseEntity<LibraryDto> createLibrary(){
		
		logger.info("Library created on port number " + environment.getProperty("local.server.port"));
		return ResponseEntity.ok(libraryService.createLibrary());
	}
	
	@PutMapping
	public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request){
		libraryService.addBookTolibrary(request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<String>> getAllLibraries(){
		return ResponseEntity.ok(libraryService.getAllLibraries());
	}
	
	@GetMapping
	public ResponseEntity<String> getCount(){
		return ResponseEntity.ok("Library count is " +count);
	}
	

}
