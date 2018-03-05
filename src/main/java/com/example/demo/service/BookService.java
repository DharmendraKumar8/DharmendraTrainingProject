package com.example.demo.service;

import java.util.List;

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

	public List<Book> getBooks() {

		return bookRepository.findAll();

	}

	public Book getById(Long id) {
		return bookRepository.findOne(id);
	}

	public void delete(Long id) {
		bookRepository.delete(id);
	}

}
