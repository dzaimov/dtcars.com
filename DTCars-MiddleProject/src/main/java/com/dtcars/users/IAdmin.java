package com.dtcars.users;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.AdException;
import com.dtcars.exceptions.InvalidUserException;
import com.dtcars.photo.Photo;

public interface IAdmin {

	void removeUser(int userId);

	User findUser(int userId) throws InvalidUserException;
	
	public void approveAd(Ad ad);
	
	public Ad showNextAdAwaitingApproval() throws AdException;
		
}
