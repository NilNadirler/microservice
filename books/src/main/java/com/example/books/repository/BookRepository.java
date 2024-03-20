package com.example.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.model.Book;



@Repository
public interface BookRepository extends JpaRepository<Book,String> {

Optional<Book> findBookByIsbn(String isbn);
}
