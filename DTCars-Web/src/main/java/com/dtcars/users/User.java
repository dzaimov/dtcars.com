package com.dtcars.users;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.validations.EmailValidator;
import com.dtcars.validations.PasswordsValidator;

public abstract class User {
	private int id;
	private String email;
	private String password;

	public User(String email, String password) throws InvalidEmailException, InvalidPasswordException {
		super();
		if (EmailValidator.isValidEmail(email)) {
			this.email = email;
		}

		changePassword(password);
	}
	
	public User(int id, String email, String password) throws InvalidEmailException, InvalidPasswordException{
		this(email, password);
		
		this.id = id;	
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
	
	public void changePassword(String password) throws InvalidPasswordException {
		if (PasswordsValidator.isValidPassword(password)) {
			this.password = password;
		}
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

	public String getName() {
		return null;
	}

	public String getPhoneNumber() {
		return null;
	}

	public String getLocation() {
		return null;
	}
}
