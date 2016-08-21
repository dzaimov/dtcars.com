package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class TruckAd extends MotorVehicleAd {

	private byte numberOfSeats;
	private int loadKg;
	
	public TruckAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			long userID, short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, byte numberOfSeats, int loadKg) throws AdException {
		super(price, color, techFeatures, photos, additionalInfo, userID, yearOfManufacture, typeOfEngineByFuel, power, 
				transmission, category, mileage);
		if (numberOfSeats > 0) {
			this.numberOfSeats = numberOfSeats;
		} else {
			throw new AdException("Incorrect number of seats!");
		}
		if (loadKg > 0) {
			this.loadKg = loadKg;
		} else {
			throw new AdException("Incorrect load!");
		}
	}
	
}
