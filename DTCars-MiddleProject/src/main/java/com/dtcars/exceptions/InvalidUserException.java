package com.dtcars.exceptions;

public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 3396291367399626006L;

	public InvalidUserException() {
		super();
	}

	public InvalidUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidUserException(String message) {
		super(message);
	}

	public InvalidUserException(Throwable cause) {
		super(cause);
	}

}
