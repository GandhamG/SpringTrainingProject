package com.oito.exception;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;
	private String errorCodeString;
	private Exception exception;

	public ApiException(final ErrorCode error) {
		super(error.getMessage());
	}

	public ApiException(final ErrorCode errorCode, final Exception exception) {
		super(String.join("_", errorCode.getMessage(), exception.getMessage()), exception);
		this.exception = exception;
		this.errorCode = errorCode;
		this.errorCodeString = errorCode.toString();

	}

}
