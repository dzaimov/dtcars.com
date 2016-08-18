package com.dtcars.users;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidUserException;

public class Admin extends User implements IAdmin {

	public Admin(String email, String password) throws InvalidEmailException, InvalidPasswordException {
		super(email, password);
	}

	@Override
	public boolean checkUser(User user) throws InvalidUserException {
		if(user != null){
			return true;
		}
		throw new InvalidUserException("Admin: " + this.getEmail() + "-Incorrect user!");

	}

	@Override
	public void removeUser(int userId) {

	}

	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
