package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	public List<Book> findByOrderByNameAsc();
	
	public List<Book> findByOrderByAuthorAscPublicationDateDesc();
}
