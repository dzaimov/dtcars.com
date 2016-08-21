package com.dtcars.users;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidUserException;
import com.dtcars.site.Site;

public class Admin extends User implements IAdmin {

	public Admin(String email, String password) throws InvalidEmailException, InvalidPasswordException {
		super(email, password);
	}

	@Override
	public boolean checkUser(User user) throws InvalidUserException {
		if (user != null) {
			for (User userToCheck : Site.users) {
				if (!userToCheck.getEmail().equals(user.getEmail())) {
					return true;
				}
			}
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

	@Override
	public void addNewAd(Ad ad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void renewAd(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void aproveAd(long id) {
		// TODO Auto-generated method stub

	}

}
