package com.dtcars.users;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidUserException;

public interface IAdmin {

	boolean checkUser(User user) throws InvalidUserException;

	void removeUser(int userId);

	User findUser(int userId);
	
	public void addNewAd(Ad ad);
	
	public void renewAd(long id);

	public void aproveAd(long id);

}
