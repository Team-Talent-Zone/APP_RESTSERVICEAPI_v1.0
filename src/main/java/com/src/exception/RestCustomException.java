package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestCustomException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	private final HttpStatus statusCode;
	private String message;

	public RestCustomException(HttpStatus statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

}
