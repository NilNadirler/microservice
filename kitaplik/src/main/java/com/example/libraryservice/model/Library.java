package com.example.libraryservice.model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Library {

	@Id
	@GeneratedValue( strategy=GenerationType.TABLE)
	@UuidGenerator
	private String id;

	
	private List<String> userBook=new ArrayList<>();
	
	
	

	public Library() {
		super();
	}



	public Library(String id, List<String> userBook) {
		super();
		this.id = id;
		this.userBook = userBook;
	}



	public String getId() {
		return id;
	}

	

	public void setId(String id) {
		this.id = id;
	}



	public List<String> getUserBook() {
		return userBook;
	}



	public void setUserBook(List<String> userBook) {
		this.userBook = userBook;
	}


	
	
}
