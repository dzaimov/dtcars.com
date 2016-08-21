package com.dtcars.users;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.photo.Photo;

public class Dealer extends PrivateUser {

	private String companyName;
	private String address;
	private Photo logo;
	
	public Dealer(String email, String password, String name, String phoneNumber, String location)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException {
		super(email, password, name, phoneNumber, location);
		// TODO Auto-generated constructor stub
	}

}
