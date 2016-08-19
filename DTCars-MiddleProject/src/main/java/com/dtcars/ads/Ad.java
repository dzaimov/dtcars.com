package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.exceptions.AdException;
import com.dtcars.photo.Photo;

public abstract class Ad {

	public static long id = 0;
	private int price;
	private String color;
	private Set<String> techFeatures;
	private Set<Photo> photos;
	private LocalDateTime datePublished;
	private String additionalInfo;
	private int viewCounter;
	private int watchCounter;
	private long adID;

	public Ad(int price, String color, Set<String> techFeatures, Set<Photo> photos, String additionalInfo)
			throws AdException {
		super();
		if (price > 0) {
			this.price = price;
		} else {
			throw new AdException("Incorrect price!");
		}
		this.color = color;
		this.techFeatures = techFeatures;
		this.photos = photos;
		this.datePublished = LocalDateTime.now();
		this.additionalInfo = additionalInfo;
		this.adID = ++id;
	}

	public long getAdID() {
		return adID;
	}

	public void update() {
		this.datePublished = LocalDateTime.now();
	}

	private void viewAd() {
		this.viewCounter++;
	}

	private void watchAd() {
		this.watchCounter++;
	}

}
