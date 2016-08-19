package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class CarAd extends MotorVehicleAd {

	public CarAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			short yearOfManufacture, String typeOfEngineByFuel, short power, String transmission, 
			String category, int mileage) throws AdException {
		super(price, color, techFeatures, photos, additionalInfo, yearOfManufacture, typeOfEngineByFuel, power, 
				transmission, category, mileage);
	}
	
}
