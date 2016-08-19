package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class MotoAd extends MotorVehicleAd {

	private short engineCapacity;
	private String engineType;
	private String coolingType;

	public MotoAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage, short engineCapacity, String engineType, String coolingType)
					throws AdException {
		super(price, color, techFeatures, photos, additionalInfo, yearOfManufacture, typeOfEngineByFuel, power, 
				transmission, category, mileage);
		if (engineCapacity > 0) {
			this.engineCapacity = engineCapacity;
		} else {
			throw new AdException("Incorrect engine capacity!");
		}
		this.engineType = engineType;
		this.coolingType = coolingType;
	}
	
}
