package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This <code> RestCustomException</code> Class defines Custom Exceptions.
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RestCustomException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	public final HttpStatus httpStatus;
	public final String errormessage;

	public RestCustomException(HttpStatus status, String errormessage) {
		this.httpStatus = status;
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
