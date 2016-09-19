package com.dtcars.repository;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.ads.BikeAd;
import com.dtcars.ads.MotorVehicleAd;
import com.dtcars.photo.Photo;
import com.dtcars.users.User;

public interface IRepository {
	public void addUser(User user);

	public void removeUser(int userId);

	public User getUser(String email, String password);

	public void addMotorVehicleAd(MotorVehicleAd ad);
	
	public void addBikeAd(BikeAd ad);

	public void removeAd(int adId);

	public Set<Ad> getAdss();

	public void addPhoto(Photo photo);

	public int getAdsCount();
}
