package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This <code> ExceptionControllerAdvice</code> Class defines Exceptions for the
 * Response Entity .
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	/**
	 * ResponseEntity- This method is for handle Exception.
	 * 
	 * @param e
	 */
	@ExceptionHandler(RestCustomException.class)
	@ResponseBody
	public ResponseEntity<APIError> handleException(RestCustomException e) {
		APIError apiErrorObj = new APIError(e.getMessage(), e.getStatusCode().name(), e.getStatusCode().value());
		return buildResponseEntity(apiErrorObj);
	}

	/**
	 * ResponseEntity- This method is for handle Exception Internal.
	 * 
	 * @param e
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<APIError> handleExceptionInternal(Exception e) {
		APIError apiErrorObj = new APIError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return buildResponseEntity(apiErrorObj);
	}

	/**
	 * ResponseEntity- This method is for building Response Entity.
	 * 
	 * @param e
	 */
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
