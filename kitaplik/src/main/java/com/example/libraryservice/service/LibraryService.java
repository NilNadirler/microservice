package com.example.libraryservice.service;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.libraryservice.client.BookServiceClient;
import com.example.libraryservice.dto.AddBookRequest;
import com.example.libraryservice.dto.LibraryDto;
import com.example.libraryservice.extention.LibraryNotFoundError;
import com.example.libraryservice.model.Library;
import com.example.libraryservice.repository.LibraryRepository;

@Service
public class LibraryService {

	private final LibraryRepository libraryRepository;
	private final BookServiceClient bookServiceClient;

	public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
		super();
		this.libraryRepository = libraryRepository;
		this.bookServiceClient = bookServiceClient;
	}


	
	public LibraryDto getAllBooksInLibraryById(String id) {
		Library library = libraryRepository.findById(id)
				.orElseThrow(() -> new LibraryNotFoundError("Library could not found by id: " + id));
		LibraryDto libraryDto = new LibraryDto(library.getId(),
				library.getUserBook().stream()
				.map(bookServiceClient:: getBookById)
				 .map(ResponseEntity::getBody)
				 .collect(Collectors.toList()));
		
		return libraryDto;
	}
	
	public LibraryDto createLibrary() {
		Library newLibrary = libraryRepository.save(new Library());	
		return new LibraryDto(newLibrary.getId());
	}
	
	public void addBookTolibrary(AddBookRequest request) {
		String bookId= bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
		Library library = libraryRepository.findById(request.getId())
				.orElseThrow(() -> new LibraryNotFoundError("Library could not found by id: " + request.getId()));
		library.getUserBook().add(bookId);
		
		libraryRepository.save(library);
	}
}
