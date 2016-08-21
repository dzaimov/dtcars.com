package com.dtcars.users;

import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.AdException;
import com.dtcars.exceptions.InvalidLocationException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;

public interface IPrivateUser {
	
	public void addNewCarAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage) throws AdException;
	
	public void addNewBusAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, byte numberOfSeats, int loadKg, byte numberOfAxles) throws AdException;
	
	public void addNewTruckAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, byte numberOfSeats, int loadKg) throws AdException;
	
	public void addNewMotoAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, short engineCapacity, String engineType, String coolingType) throws AdException;
	
	public void addNewBikeAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			String brand, String type, byte sizeInch, String frame, byte numberOfGears) throws AdException;
		
	public void renewAd(long id);
	
	public void editAd(long id, int price, Set<Photo> photos, String additionalInfo) throws AdException;
	
	public void deleteAd(long id);
	
	public void changeName(String name) throws InvalidNameException;
	
	public void changeLocation(String location) throws InvalidLocationException;
	
	public void changePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException;

}
