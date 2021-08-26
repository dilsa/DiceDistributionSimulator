package com.letUsLearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DDSBadInputException extends RuntimeException {
	private String message;

	public DDSBadInputException(String message) {
		super(message);
		this.message = message;
	}

	public DDSBadInputException() {
	}
}