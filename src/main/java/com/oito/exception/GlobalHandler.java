package com.oito.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(ApiException.class)
	public ErrorResponse handleApiException(final ApiException api) {
		return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, api.getMessage(),
				HttpStatus.NOT_FOUND.value());

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValdationExceptions(final MethodArgumentNotValidException ex) {
		final List<String> details = new ArrayList<>();
		for (final ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}

		final var response = ErrorResponse.builder().httpStatus(HttpStatus.OK).error(ex.getMessage())
				.dataTime(LocalDateTime.now()).status(HttpStatus.BAD_REQUEST.value()).build();
		return new ResponseEntity<>(details, response.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public ErrorResponse handleException(final Exception e) {
		return ErrorResponse.builder().dataTime(LocalDateTime.now()).error(e.getMessage())
				.status(HttpStatus.BAD_REQUEST.value()).httpStatus(HttpStatus.NOT_FOUND).build();

	}

}
