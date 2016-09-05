package com.dtcars.exceptions;

public class InvalidNameException extends Exception {
	static final long serialVersionUID = -1428725876777624178L;

	public InvalidNameException() {
		super();
	}

	public InvalidNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidNameException(String message) {
		super(message);
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
	}

}
