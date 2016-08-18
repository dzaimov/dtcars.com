package com.dtcars.exceptions;

public class NoAdminsException extends Exception {

	private static final long serialVersionUID = 5483746370326788643L;

	public NoAdminsException() {
		super();
	}

	public NoAdminsException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoAdminsException(String message) {
		super(message);
	}

	public NoAdminsException(Throwable cause) {
		super(cause);
	}

}
