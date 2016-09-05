package com.dtcars.exceptions;

public class InvalidPhoneNumberException extends Exception {

	private static final long serialVersionUID = -2149255597706935551L;

	public InvalidPhoneNumberException() {
		super();
	}

	public InvalidPhoneNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPhoneNumberException(String message) {
		super(message);
	}

	public InvalidPhoneNumberException(Throwable cause) {
		super(cause);
	}

}
