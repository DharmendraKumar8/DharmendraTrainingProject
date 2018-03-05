package com.example.demo.exception;

public class ExceptionResponse {
	private String errorMessage;
	private String requestedURI;

	public String getErrorMessage() {
		return errorMessage;
	}

	public ExceptionResponse() {
	}

	public ExceptionResponse(String errorMessage, String requestedURI) {
		super();
		this.errorMessage = errorMessage;
		this.requestedURI = requestedURI;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
}
