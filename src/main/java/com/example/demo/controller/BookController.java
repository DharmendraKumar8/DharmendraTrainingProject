package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	private static Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	BookService bookService;

	@RequestMapping(value = URLMapping.ADD_BOOK, method = RequestMethod.POST)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		bookService.save(book);
		logger.info("Added book successfully ");
		return new ResponseEntity<>(book, HttpStatus.CREATED);
	}

}
