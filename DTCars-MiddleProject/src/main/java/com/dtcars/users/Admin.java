package com.dtcars.users;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.AdException;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidUserException;
import com.dtcars.photo.Photo;
import com.dtcars.site.Site;

public class Admin extends User implements IAdmin {

	private static List<Ad> adsToApprove = new LinkedList();

	public Admin(String email, String password) throws InvalidEmailException, InvalidPasswordException {
		super(email, password);
	}

	@Override
	public void removeUser(int userId) {
		Site.deleteUserByID(userId);
	}

	@Override
	public User findUser(int userId) throws InvalidUserException {
		return Site.getUserByID(userId);
	}

	public static void addNewAdForApproving(Ad newAd) {
		if (newAd != null) {
			Admin.adsToApprove.add(newAd);
		}
	}
	
	public static void addEditAdForApproving(long id, int price, Set<Photo> photos, String additionalInfo) throws AdException {
		Ad ad = Site.getAdByID(id);
		ad.editAd(price, photos, additionalInfo);
		Admin.adsToApprove.add(ad);
	}

	@Override
	public void approveAd(Ad ad) {
		Site.approveAd(ad);
	}

	@Override
	public Ad showNextAdAwaitingApproval() throws AdException {
		if (this.adsToApprove.size() > 0) {
			return this.adsToApprove.get(0);
		} else {
			throw new AdException("No ads awaiting approval!");
		}
	}

}
