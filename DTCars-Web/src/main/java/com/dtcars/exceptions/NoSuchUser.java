package com.dtcars.exceptions;

public class NoSuchUser extends Exception {

	private static final long serialVersionUID = -7599247746495448694L;

	public NoSuchUser() {
		super();
	}

	public NoSuchUser(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchUser(String message) {
		super(message);
	}

	public NoSuchUser(Throwable cause) {
		super(cause);
	}

}
