package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public abstract class Ad {

	private String brand;
	private int price;
	private String color;
	private Set<String> techFeatures;
	private Set<Photo> photos;
	private LocalDateTime datePublished;
	private String additionalInfo;
	private int viewCounter;
	private int watchCounter;
	private int adId;
	private int userId;

	public Ad(String brand, int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo, 
			int user) throws AdException {
		super();
		if (brand != null && !brand.trim().isEmpty()) {
			this.brand = brand;
		} else {
			throw new AdException("Incorrect brand name!");
		}
		setPrice(price);
		this.color = color;
		this.techFeatures = techFeatures;
		this.photos = photos;
		this.datePublished = LocalDateTime.now();
		this.additionalInfo = additionalInfo;
		this.userId = user;
	}

	public String getBrand() {
		return brand;
	}

	public int getPrice() {
		return price;
	}

	public String getColor() {
		return color;
	}

	public Set<String> getTechFeatures() {
		return Collections.unmodifiableSet(techFeatures);
	}

	public Set<Photo> getPhotos() {
		return Collections.unmodifiableSet(photos);
	}

	public LocalDateTime getDatePublished() {
		return datePublished;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public int getViewCounter() {
		return viewCounter;
	}

	public int getWatchCounter() {
		return watchCounter;
	}

	public int getUser() {
		return userId;
	}

	public void update() {
		this.datePublished = LocalDateTime.now();
	}
	
	public void editAd(int price, Set<Photo>photos, String additionalInfo) throws AdException {
		setPrice(price);
		this.photos = photos;
		this.additionalInfo = additionalInfo;
	}

	private void viewAd() {
		this.viewCounter++;
	}

	private void watchAd() {
		this.watchCounter++;
	}

	private void setPrice(int price) throws AdException {
		if (price > 0) {
			this.price = price;
		} else {
			throw new AdException("Incorrect price!");
		}
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public int getUserId() {
		return userId;
	}
	
}
