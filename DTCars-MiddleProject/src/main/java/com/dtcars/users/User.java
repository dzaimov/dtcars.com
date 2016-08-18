package com.dtcars.users;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.validations.EmailValidator;
import com.dtcars.validations.PasswordsValidator;

public abstract class User {
	private int id;
	private String email;
	private String password;
	private static int countOfUsers = 0;

	public User(String email, String password) throws InvalidEmailException, InvalidPasswordException {
		super();
		if (EmailValidator.isValidEmail(email)) {
			this.email = email;
		}

		if (PasswordsValidator.isValidPassword(password)) {
			this.password = password;
		}

		this.id = ++countOfUsers;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
}
