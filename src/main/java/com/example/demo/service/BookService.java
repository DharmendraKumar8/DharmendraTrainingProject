package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public Book save(Book book) {
		return bookRepository.save(book);
	}
}
