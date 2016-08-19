package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class BikeAd extends Ad {

	private String brand;
	private String type;
	private byte sizeInch;
	private String frame;
	private byte numberOfGears;
	
	public BikeAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			String brand, String type, byte sizeInch, String frame, byte numberOfGears) 
			throws AdException {
		super(price, color, techFeatures, photos, additionalInfo);
		if (brand != null && !brand.trim().isEmpty()) {
			this.brand = brand;
		} else {
			throw new AdException("Incorrect brand name!");
		}
		this.type = type;
		if (sizeInch > 0) {
			this.sizeInch = sizeInch;
		} else {
			throw new AdException("Incorrect size!");
		}
		this.frame = frame;
		if (numberOfGears > 0) {
			this.numberOfGears = numberOfGears;
		} else {
			throw new AdException("Incorrect number of gears!");			
		}
	}
	
}
