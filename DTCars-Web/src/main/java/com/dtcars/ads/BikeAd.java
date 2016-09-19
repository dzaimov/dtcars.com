package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public class BikeAd extends Ad {

	private String type;
	private byte sizeInch;
	private String frame;
	private byte numberOfGears;
	
	public BikeAd(String brand, int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo,
			int userID, String type, byte sizeInch, String frame, byte numberOfGears) 
			throws AdException {
		super(brand, price, color, techFeatures, photos, additionalInfo, userID);
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

	public String getType() {
		return type;
	}

	public byte getSizeInch() {
		return sizeInch;
	}

	public String getFrame() {
		return frame;
	}

	public byte getNumberOfGears() {
		return numberOfGears;
	}
	
}
