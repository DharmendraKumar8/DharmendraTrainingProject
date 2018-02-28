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

import com.example.demo.domain.BookCategory;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.CategoryService;

@RestController
public class CategoryController {

	private static Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	CategoryService categoryService;
	

	@RequestMapping(value = URLMapping.ADD_CATEGORY, method = RequestMethod.POST)
	public ResponseEntity<BookCategory> addCategory(@RequestBody BookCategory bookCategory) {
		categoryService.save(bookCategory);
		logger.debug("Added ");
		return new ResponseEntity<>(bookCategory, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = URLMapping.UPDATE_CATEGORY,method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCategory(@RequestBody BookCategory bookCategory) {
		BookCategory existingCategory = categoryService.getById(bookCategory.getCategoryId());
		if (existingCategory == null) {
					logger.debug("Category with given id does not exists");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			categoryService.save(bookCategory);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
