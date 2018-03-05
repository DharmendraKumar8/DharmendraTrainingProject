package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.BookService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
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

	@RequestMapping(value = URLMapping.ALL_BOOKS, method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookService.getBooks();
		if (books.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(books, HttpStatus.OK);

	}

	@RequestMapping(value = URLMapping.DELETE_BOOK, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {

		Book book = bookService.getById(id);

		if (book == null) {
			logger.info("book with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			bookService.delete(id);
			String str = "Book with id " + id + " deleted";
			logger.info(str);
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = URLMapping.UPDATE_BOOK, method = RequestMethod.PUT)
	public ResponseEntity<Void> updateBook(@RequestBody Book book) {

		Book existingBook = bookService.getById(book.getBookId());
		if (existingBook == null) {
			String str = "Book with id " + book.getBookId() + " does not exists";
			logger.info(str);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			bookService.save(book);
			logger.info("values updated");
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = URLMapping.FETCH_BOOK, method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("id") Long id) {
		Book book = bookService.getById(id);
		if (book == null) {
			logger.info("Book with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		logger.info("Found Book:");
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
}
