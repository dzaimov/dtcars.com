package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class BusAd extends MotorVehicleAd {

	private byte numberOfSeats;
	private int loadKg;
	private byte numberOfAxles;
	
	public BusAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, byte numberOfSeats, int loadKg, byte numberOfAxles) throws AdException {
		super(price, color, techFeatures, photos, additionalInfo, yearOfManufacture, typeOfEngineByFuel, power, 
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
		if (numberOfAxles > 0) {
			this.numberOfAxles = numberOfAxles;
		} else {
			throw new AdException("Incorrect number of axles!");
		}
	}
	
}
