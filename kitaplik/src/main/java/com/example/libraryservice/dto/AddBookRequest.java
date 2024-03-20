package com.example.libraryservice.dto;

public class AddBookRequest {
	
	private String id;
	
	private String isbn;





	public AddBookRequest(String id, String isbn) {
		super();
		this.id = id;
		this.isbn = isbn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	

}
