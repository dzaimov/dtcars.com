package com.dtcars.photo;

public class Photo {

	private String path;
	private int photoID;

	public Photo(String path) {
		super();
		this.path = path; // Validation ???
	}

	public int getPhotoID() {
		return photoID;
	}

	public void setPhotoID(int photoID) {
		this.photoID = photoID;
	}

	public String getPath() {
		return path;
	}
	
}
