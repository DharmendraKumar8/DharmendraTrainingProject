package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BookCategory;
import com.example.demo.repository.BookCategoryRepository;

@Service
public class CategoryService {
	@Autowired
	BookCategoryRepository bookCategoryRepository;
	
	public BookCategory save(BookCategory bookCategory) {
		return bookCategoryRepository.save(bookCategory);
	}

	public BookCategory getById(int categoryId) {
		return bookCategoryRepository.findOne((long) categoryId);
	}

}
