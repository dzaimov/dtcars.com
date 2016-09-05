package com.dtcars.exceptions;

public class InvalidPasswordException extends Exception {

	private static final long serialVersionUID = 231142534367329920L;

	public InvalidPasswordException() {
		super();
	}

	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPasswordException(String message) {
		super(message);
	}

	public InvalidPasswordException(Throwable cause) {
		super(cause);
	}
}
