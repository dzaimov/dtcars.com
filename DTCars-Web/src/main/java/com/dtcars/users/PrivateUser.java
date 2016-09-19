package com.dtcars.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.ads.BikeAd;
import com.dtcars.ads.MotorVehicleAd;
import com.dtcars.exceptions.AdException;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;
import com.dtcars.validations.IValidator;
import com.dtcars.validations.NameValidator;
import com.dtcars.validations.PhoneNumberValidator;

public class PrivateUser extends User implements IPrivateUser {
	private static final int MAX_NUMBER_OF_PRIVATE_USER_ADS = 3;
	private String name;
	private String phoneNumber;
	private String location;
	private List<Ad> ads;

	public PrivateUser(String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException,
			InvalidLocationException {
		super(email, password);
		changeName(name);
		changePhoneNumber(phoneNumber);
		changeLocation(location);
		this.ads = new ArrayList<Ad>();
	}
	
	public PrivateUser(int id, String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException,
			InvalidLocationException {
		super(email, password);
		this.setId(id);
		changeName(name);
		changePhoneNumber(phoneNumber);
		changeLocation(location);
		this.ads = new ArrayList<Ad>();
	}

	@Override
	public void renewAd(int id) throws AdException {
		// Ad ad = Site.getAdByID(id);
		// if (ad != null) {
		// ad.update();
		// }
	}

	@Override
	public void editAd(int id, int price, Set<Photo> photos, String additionalInfo) throws AdException {
		// Site.editAd(id, price, photos, additionalInfo);
	}

	@Override
	public void deleteAd(int id) {
		for (int index = 0; index < this.ads.size(); index++) {
			if (this.ads.get(index).getAdId() == id) {
				this.ads.remove(index);
				// Site.deleteAdByID(id);
			}
		}
	}

	@Override
	public void changeName(String name) throws InvalidNameException {
		if (NameValidator.isValidName(name)) {
			this.name = name;
		}
	}

	@Override
	public void changeLocation(String location) throws InvalidLocationException {
		if (IValidator.isValidString(location)) {
			this.location = location;
		} else {
			throw new InvalidLocationException("Incorrect location!");
		}
	}

	@Override
	public void changePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		if (PhoneNumberValidator.isValidPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public void addNewMotorVehicleAd(String brand, String model, int price, String color, Set<String> techFeatures,
			Set<Photo> photos, String additionalInfo, int userID, short yearOfManufacture, String typeOfEngineByFuel,
			short engineCapacity, short power, String transmission, String category, int mileage) throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			MotorVehicleAd ad = new MotorVehicleAd(brand, model, price, color, techFeatures, photos, additionalInfo, 
					userID, yearOfManufacture, typeOfEngineByFuel, engineCapacity, power, transmission, category, mileage);
			//Site.addNewAd(ad);
			this.ads.add(ad);
		} else {
			throw new AdException("You have reach your ads limit!");
		}		
	}

	@Override
	public void addNewBikeAd(String brand, int price, String color, Set<String> techFeatures, Set<Photo> photos,
			String additionalInfo, int userID, String type, byte sizeInch, String frame, byte numberOfGears)
			throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			BikeAd ad = new BikeAd(brand, price, color, techFeatures, photos, additionalInfo, userID, type, 
					sizeInch, frame, numberOfGears);
			// Site.addNewAd(ad);
			this.ads.add(ad);
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

}
