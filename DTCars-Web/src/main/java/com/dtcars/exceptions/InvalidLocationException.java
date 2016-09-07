package com.dtcars.exceptions;

public class InvalidLocationException extends Exception {

	private static final long serialVersionUID = 1778260058151290900L;

	public InvalidLocationException() {
		super();
	}

	public InvalidLocationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidLocationException(String arg0) {
		super(arg0);
	}

	public InvalidLocationException(Throwable arg0) {
		super(arg0);
	}

}
