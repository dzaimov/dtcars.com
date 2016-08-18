package com.dtcars.ads;

import java.time.LocalDateTime;
import java.util.Set;

import com.dtcars.photo.Photo;

public abstract class Ad {

	public static long id;
	private int price;
	private String color;
	private Set<String> techFeatures;
	private Set<Photo> photos;
	private LocalDateTime datePublished;
	private String additionalInfo;
	private int viewCounter;
	private int watchCounter;
	private long adID;
	
	public Ad(int price, String color, Set<String> techFeatures, Set<Photo> photos, LocalDateTime datePublished,
			String additionalInfo) {
		super();
		this.price = price;
		this.color = color;
		this.techFeatures = techFeatures;
		this.photos = photos;
		this.datePublished = datePublished;
		this.additionalInfo = additionalInfo;
	}

	public long getAdID() {
		return adID;
	}
	
	public void update() {
		this.datePublished = LocalDateTime.now();
	}

}
