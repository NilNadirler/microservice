package com.example.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryservice.model.Library;

public interface LibraryRepository extends JpaRepository<Library, String>{

}
