package com.dtcars.users;

import com.dtcars.exceptions.InvalidUserException;

public interface IAdmin {

	boolean checkUser(User user) throws InvalidUserException;

	void removeUser(int userId);

	User findUser(int userId);

}
