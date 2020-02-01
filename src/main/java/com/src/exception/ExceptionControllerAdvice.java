package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RestCustomException.class)
	@ResponseBody
	public ResponseEntity<APIError> handleException(RestCustomException e) {
		APIError apiErrorObj = new APIError(e.getMessage(), e.getStatusCode().name(), e.getStatusCode().value());
		return buildResponseEntity(apiErrorObj);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<APIError> handleExceptionInternal(Exception e) {
		APIError apiErrorObj = new APIError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return buildResponseEntity(apiErrorObj);
	}

	private ResponseEntity<APIError> buildResponseEntity(APIError apiError) {
		return new ResponseEntity<APIError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private class APIError {
		String errormessage;
		String httpStatusName;
		int httpStatusCode;

		public APIError(String errormessage, String httpStatusName, int httpStatusCode) {
			super();
			this.errormessage = errormessage;
			this.httpStatusName = httpStatusName;
			this.httpStatusCode = httpStatusCode;
		}

		@SuppressWarnings("unused")
		public String getErrormessage() {
			return errormessage;
		}

		@SuppressWarnings("unused")
		public void setErrormessage(String errormessage) {
			this.errormessage = errormessage;
		}

		@SuppressWarnings("unused")
		public String getHttpStatusName() {
			return httpStatusName;
		}
		
		@SuppressWarnings("unused")
		public void setHttpStatusName(String httpStatusName) {
			this.httpStatusName = httpStatusName;
		}

		@SuppressWarnings("unused")
		public int getHttpStatusCode() {
			return httpStatusCode;
		}

		@SuppressWarnings("unused")
		public void setHttpStatusCode(int httpStatusCode) {
			this.httpStatusCode = httpStatusCode;
		}

	}
}
