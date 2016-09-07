package com.dtcars.exceptions;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3582840569166823584L;

	public NoSuchUserException() {
		super();
	}

	public NoSuchUserException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public NoSuchUserException(String arg0) {
		super(arg0);

	}

	public NoSuchUserException(Throwable arg0) {
		super(arg0);

	}

}
