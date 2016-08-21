package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public abstract class Ad {

	public static long id = 1;
	private int price;
	private String color;
	private Set<String> techFeatures;
	private Set<Photo> photos;
	private LocalDateTime datePublished;
	private String additionalInfo;
	private int viewCounter;
	private int watchCounter;
	private long adID;
	private long user;

	public Ad(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo, 
			long user) throws AdException {
		super();
		setPrice(price);
		this.color = color;
		this.techFeatures = techFeatures;
		this.photos = photos;
		this.datePublished = LocalDateTime.now();
		this.additionalInfo = additionalInfo;
		this.adID = ++id;
		this.user = user;
	}

	public long getAdID() {
		return adID;
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

}
