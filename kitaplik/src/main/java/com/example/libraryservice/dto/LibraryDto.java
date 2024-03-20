package com.example.libraryservice.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryDto {

	private String id;
	
	private List<BookDto> userBookList= new ArrayList<BookDto>();

	public LibraryDto(String id, List<BookDto> list) {
		 this.id= id;
		 this.userBookList=list;
		
		
	}

	public LibraryDto(String id) {
	    this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<BookDto> getUserBookList() {
		return userBookList;
	}

	public void setUserBookList(List<BookDto> userBookList) {
		this.userBookList = userBookList;
	}


	
	
}
