package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.photo.Photo;

public class CarAd extends MotorVehicleAd {

	public CarAd(int price, String color, Set<String> techFeatures, Set<Photo> photos, LocalDateTime datePublished,
			String additionalInfo) {
		super(price, color, techFeatures, photos, datePublished, additionalInfo);
		// TODO Auto-generated constructor stub
	}
	
}
