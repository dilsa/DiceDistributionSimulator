package com.letUsLearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DDSNotFoundException extends RuntimeException {
	private String message;

	public DDSNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public DDSNotFoundException() {
	}
}