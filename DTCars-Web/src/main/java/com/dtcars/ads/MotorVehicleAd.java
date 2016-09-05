package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class MotorVehicleAd extends Ad {
	
	private short yearOfManufacture;
	private String typeOfEngineByFuel;
	private short power;
	private String transmission;
	private String category;
	private int mileage;
	
	public MotorVehicleAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			long userID, short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, String category, 
			int mileage) throws AdException {
		super(price, color, techFeatures, photos, additionalInfo, userID);
		this.yearOfManufacture = yearOfManufacture;
		this.typeOfEngineByFuel = typeOfEngineByFuel;
		if (power > 0) {
			this.power = power;
		} else {
			throw new AdException("Incorrect power!");
		}
		this.transmission = transmission;
		this.category = category;
		if (mileage >= 0) {
			this.mileage = mileage;
		} else {
			throw new AdException("Incorrect mileage!");
		}
	}
	
}
