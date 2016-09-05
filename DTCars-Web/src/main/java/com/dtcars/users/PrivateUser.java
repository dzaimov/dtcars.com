package com.dtcars.users;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.ads.BikeAd;
import com.dtcars.ads.BusAd;
import com.dtcars.ads.CarAd;
import com.dtcars.ads.MotoAd;
import com.dtcars.ads.TruckAd;
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
	private List<Long> ads;

	public PrivateUser(String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, 
			InvalidPhoneNumberException, InvalidLocationException {
		super(email, password);
		changeName(name);
		changePhoneNumber(phoneNumber);
		changeLocation(location);
		this.ads = new ArrayList<Long>();
	}
	
	public PrivateUser(int id, String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, 
			InvalidPhoneNumberException, InvalidLocationException {
		super(id, email, password);
		changeName(name);
		changePhoneNumber(phoneNumber);
		changeLocation(location);
		this.ads = new ArrayList<Long>();
	}

	@Override
	public void addNewCarAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, String category,
			int mileage) throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			CarAd ad = new CarAd(price, color, techFeatures, photos, additionalInfo, this.getId(), yearOfManufacture,
					typeOfEngineByFuel, power, transmission, category, mileage);
			//Site.addNewAd(ad);
			this.ads.add(ad.getAdID());
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

	@Override
	public void addNewBusAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, String category,
			int mileage, byte numberOfSeats, int loadKg, byte numberOfAxles) throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			BusAd ad = new BusAd(price, color, techFeatures, photos, additionalInfo, this.getId(), yearOfManufacture,
					typeOfEngineByFuel, power, transmission, category, mileage, numberOfSeats, loadKg, numberOfAxles);
			//Site.addNewAd(ad);
			this.ads.add(ad.getAdID());
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

	@Override
	public void addNewTruckAd(int price, String color, Set<String> techFeatures, Set<Photo> photos,
			String additionalInfo, short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission,
			String category, int mileage, byte numberOfSeats, int loadKg) throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			TruckAd ad = new TruckAd(price, color, techFeatures, photos, additionalInfo, this.getId(), yearOfManufacture,
					typeOfEngineByFuel, power, transmission, category, mileage, numberOfSeats, loadKg);
			//Site.addNewAd(ad);
			this.ads.add(ad.getAdID());
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

	@Override
	public void addNewMotoAd(int price, String color, Set<String> techFeatures, Set<Photo> photos,
			String additionalInfo, short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission,
			String category, int mileage, short engineCapacity, String engineType, String coolingType)
			throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			MotoAd ad = new MotoAd(price, color, techFeatures, photos, additionalInfo, this.getId(), yearOfManufacture,
					typeOfEngineByFuel, power, transmission, category, mileage, engineCapacity, engineType,
					coolingType);
			//Site.addNewAd(ad);
			this.ads.add(ad.getAdID());
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

	@Override
	public void addNewBikeAd(int price, String color, Set<String> techFeatures, Set<Photo> photos,
			String additionalInfo, String brand, String type, byte sizeInch, String frame, byte numberOfGears)
			throws AdException {
		if (this.ads.size() < MAX_NUMBER_OF_PRIVATE_USER_ADS) {
			BikeAd ad = new BikeAd(price, color, techFeatures, photos, additionalInfo, this.getId(), brand, type, sizeInch, frame,
					numberOfGears);
			//Site.addNewAd(ad);
			this.ads.add(ad.getAdID());
		} else {
			throw new AdException("You have reach your ads limit!");
		}
	}

	@Override
	public void renewAd(long id) throws AdException {
//		Ad ad = Site.getAdByID(id);
//		if (ad != null) {
//			ad.update();
//		}
	}

	@Override
	public void editAd(long id, int price, Set<Photo> photos, String additionalInfo) throws AdException {
		//Site.editAd(id, price, photos, additionalInfo);
	}

	@Override
	public void deleteAd(long id) {
		for (int index = 0; index < this.ads.size(); index++) {
			if (this.ads.get(index) == id) {
				this.ads.remove(index);
				//Site.deleteAdByID(id);
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
}
