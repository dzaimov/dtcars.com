package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class MotorVehicleAd extends Ad {
	
	private String model;
	private int yearOfManufacture;
	private String typeOfEngineByFuel;
	private int engineCapacity;
	private int power;
	private String transmission;
	private String category;
	private int mileage;
	
	public MotorVehicleAd(String brand, String model, int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			int userID, int yearOfManufacture, String typeOfEngineByFuel, int engineCapacity, int power, String transmission, String category, 
			int mileage) throws AdException {
		super(brand, price, color, techFeatures, photos, additionalInfo, userID);
		this.model = model;
		this.yearOfManufacture = yearOfManufacture;
		this.typeOfEngineByFuel = typeOfEngineByFuel;
		this.engineCapacity = engineCapacity;
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

	public String getModel() {
		return model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public String getTypeOfEngineByFuel() {
		return typeOfEngineByFuel;
	}

	public int getPower() {
		return power;
	}

	public String getTransmission() {
		return transmission;
	}

	public String getCategory() {
		return category;
	}

	public int getMileage() {
		return mileage;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}
	
}
