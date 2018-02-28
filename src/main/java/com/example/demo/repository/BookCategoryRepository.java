package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
