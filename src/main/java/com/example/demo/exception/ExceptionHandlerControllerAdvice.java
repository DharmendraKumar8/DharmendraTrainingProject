package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionHandlerControllerAdvice {
	@ExceptionHandler(UserNotFoundException.class)
	//@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ExceptionResponse handleUserNotFound( UserNotFoundException exception,
			HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		System.out.println("*************************1111111*******************************");
		error.setErrorMessage(exception.getMessage());
		System.out.println("*************************2222222*******************************");
		error.setRequestedURI(request.getRequestURI());
		System.out.println("*************************3333333*******************************");
		return error;
	}
}