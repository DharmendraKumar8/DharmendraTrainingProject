package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.mapping.URLMapping;
import com.example.demo.service.AuthService;
import com.example.demo.service.EmailService;
import com.example.demo.util.ResponseHandler;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class AuthController {
	private static Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
	

	@Autowired
	private AuthService authService;
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(URLMapping.REGISTER)
	ResponseEntity<Object> signUp(@RequestBody User user, HttpServletRequest request) {
		if (user.getPassword().equals("")) {
			LOGGER.info("Please enter valid password");
			return ResponseHandler.invalidResponse(HttpStatus.OK, false, "Please enter valid password");
		} else if (emailService.validate(user.getEmail())) {
			LOGGER.info("Valid email id is entered and singup is being processed");
			return authService.signUp(user);
		} else {
			LOGGER.info("Please enter valid email");
			return ResponseHandler.invalidResponse(HttpStatus.OK, false, "Please enter valid email");
		}
	}
	@GetMapping(value = URLMapping.VERIFICATION)
	ResponseEntity<Object> verifyEmail(@RequestParam String token) {
		return authService.verifyEmail(token);
	}
	
}
