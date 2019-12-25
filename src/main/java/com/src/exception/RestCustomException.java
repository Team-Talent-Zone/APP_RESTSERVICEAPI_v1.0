package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RestCustomException extends RuntimeException {

	private static final long serialVersionUID = -2859292084648724403L;
	private final HttpStatus httpStatusCode;
	private  String errorCustomMessage;
	private  String errorSysThrow;

	public RestCustomException(HttpStatus errorCode, String errorCustomMessage) {
		this.httpStatusCode = errorCode;
		this.errorCustomMessage = errorCustomMessage;
	}

	public String getErrorCustomMessage() {
		return errorCustomMessage;
	}

	public String getErrorSysThrow() {
		return errorSysThrow;
	}

	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

}
