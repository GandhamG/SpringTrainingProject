package com.oito.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	ID_NOT_FOUND("ID NOT FOUND"), NAME_NOT_FOUND("NAME NOT FOUND"), INVALID_ID("Invalid id"),
	INVALID_NAME("Invalid name"), INVALID_SALARY("Invalid salary"), NO_DATA_FOUND("no data found");

	private String message;

}
