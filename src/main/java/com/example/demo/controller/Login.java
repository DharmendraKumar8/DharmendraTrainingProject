package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public class Login {
	@PostMapping("/login")
	ResponseEntity<Object> login(){
		 return new ResponseEntity<>("please log in !", HttpStatus.UNAUTHORIZED);
	}
}
