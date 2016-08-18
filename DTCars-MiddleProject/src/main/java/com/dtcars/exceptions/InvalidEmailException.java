package com.dtcars.exceptions;

public class InvalidEmailException extends Exception {

	private static final long serialVersionUID = -5098305969458638080L;

	public InvalidEmailException() {
		super();
	}

	public InvalidEmailException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidEmailException(String message) {
		super(message);
	}

	public InvalidEmailException(Throwable cause) {
		super(cause);
	}

}
