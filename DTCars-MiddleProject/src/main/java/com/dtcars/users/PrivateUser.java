package com.dtcars.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;
import com.dtcars.site.Site;
import com.dtcars.validations.IValidator;
import com.dtcars.validations.NameValidator;
import com.dtcars.validations.PhoneNumberValidator;

public class PrivateUser extends User implements IPrivateUser{
	private String name;
	private String phoneNumber;
	private String location;
	private List<Ad> ads;

	public PrivateUser(String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException {
		super(email, password);

		if (NameValidator.isValidName(name)) {
			this.name = name;
		}

		if (PhoneNumberValidator.isValidPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}

		if (IValidator.isValidString(location)) {
			this.location = location;
		} else {
			throw new IllegalArgumentException("Incorrect location!");
		}

		this.ads = new ArrayList<Ad>();
	}

	@Override
	public void addNewAd(Ad ad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void renewAd(long id) {
		Ad ad = Site.getAdByID(id);
		if (ad != null) {
			ad.update();
		}
	}

	@Override
	public void editAd(long id, int price, Set<Photo> photos, String additionalInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAd(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeLocation(String location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		
	}

}
