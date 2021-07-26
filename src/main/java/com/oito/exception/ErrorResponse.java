package com.oito.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ErrorResponse {

	private LocalDateTime dataTime;
	private HttpStatus httpStatus;
	private String error;
	private int status;

}
