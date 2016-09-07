package com.dtcars.repository;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.users.User;

public interface IRepository {
	public void addUser(User user);

	public void removeUser(int userId);

	public Set<User> getUsers();

	public void addAd(Ad ad);

	public void removeAd(int adId);

	public Set<Ad> getAdss();

}
