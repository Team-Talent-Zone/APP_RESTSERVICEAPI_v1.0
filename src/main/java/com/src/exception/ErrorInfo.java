package com.src.exception;

import org.springframework.http.HttpStatus;

public class ErrorInfo {

	private HttpStatus httpStatus;
	private String errorSysThrow;
	private String errorCustomMessage;
	private int httpStatusCode;
	
	public ErrorInfo(HttpStatus httpStatus, int httpStatusCode, String errorSysThrow, String errorCustomMessage) {
		this.errorCustomMessage = errorCustomMessage;
		this.errorSysThrow = errorSysThrow;
		this.httpStatusCode = httpStatusCode;
		this.httpStatus = httpStatus;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public String getErrorSysThrow() {
		return errorSysThrow;
	}

	public void setErrorSysThrow(String errorSysThrow) {
		this.errorSysThrow = errorSysThrow;
	}

	public String getErrorCustomMessage() {
		return errorCustomMessage;
	}

	public void setErrorCustomMessage(String errorCustomMessage) {
		this.errorCustomMessage = errorCustomMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
