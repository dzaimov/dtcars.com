package com.dtcars.users;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.photo.Photo;

public interface IPrivateUser {
	
	public void addNewAd(Ad ad);
	
	public void renewAd(long id);
	
	public void editAd(long id, int price, Set<Photo> photos, String additionalInfo);
	
	public void deleteAd(long id);
	
	public void changePassword(String password);
	
	public void changeName(String name);
	
	public void changeLocation(String location);
	
	public void changePhoneNumber(String phoneNumber);

}
