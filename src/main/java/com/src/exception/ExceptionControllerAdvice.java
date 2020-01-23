package com.src.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(RestCustomException.class)
	@ResponseBody
	public APIError handleMyException(RestCustomException e) {
		APIError apiErrorObj = new APIError(e.getMessage(), e.getStatusCode().toString());
		return apiErrorObj;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public APIError handleException(Exception e) {
		APIError apiErrorObj = new APIError(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return apiErrorObj;
	}

	private class APIError {
		String errorMsg;
		String httpErrorCode;

		public APIError(String errorMsg, String httpErrorCode) {
			super();
			this.errorMsg = errorMsg;
			this.httpErrorCode = httpErrorCode;
		}

		@SuppressWarnings("unused")
		public String getErrorMsg() {
			return errorMsg;
		}

		@SuppressWarnings("unused")
		public void setErrorMsg(String errorMsg) {
			this.errorMsg = errorMsg;
		}

		@SuppressWarnings("unused")
		public String getHttpErrorCode() {
			return httpErrorCode;
		}

		@SuppressWarnings("unused")
		public void setHttpErrorCode(String httpErrorCode) {
			this.httpErrorCode = httpErrorCode;
		}

	}
}
