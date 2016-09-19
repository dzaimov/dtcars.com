package com.dtcars.users;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.AdException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;

public interface IPrivateUser {
	
	public void addNewMotorVehicleAd(String brand, String model, int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			int userID, short yearOfManufacture, String typeOfEngineByFuel, short engineCapacity, short power, String transmission, String category, 
			int mileage) throws AdException;
	
	public void addNewBikeAd(String brand, int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			int userID, String type, byte sizeInch, String frame, byte numberOfGears) throws AdException;
		
	public void renewAd(int id) throws AdException;
	
	public void editAd(int id, int price, Set<Photo> photos, String additionalInfo) throws AdException;
	
	public void deleteAd(int id);
	
	public void changeName(String name) throws InvalidNameException;
	
	public void changeLocation(String location) throws InvalidLocationException;
	
	public void changePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException;

}
