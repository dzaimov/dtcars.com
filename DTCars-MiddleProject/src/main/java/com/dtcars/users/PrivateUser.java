package com.dtcars.users;

import java.util.ArrayList;
import java.util.List;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.validations.IValidator;
import com.dtcars.validations.NameValidator;
import com.dtcars.validations.PhoneNumberValidator;

public class PrivateUser extends User implements IPrivateUser{
	private String name;
	private String phoneNumber;
	private String address;
	private List<Ad> ads;

	public PrivateUser(String email, String password, String name, String phoneNumber, String address)
			throws InvalidEmailException, InvalidPasswordException, InvalidNameException, InvalidPhoneNumberException {
		super(email, password);

		if (NameValidator.isValidName(name)) {
			this.name = name;
		}

		if (PhoneNumberValidator.isValidPhoneNumber(phoneNumber)) {
			this.phoneNumber = phoneNumber;
		}

		if (IValidator.isValidString(address)) {
			this.address = address;
		} else {
			throw new IllegalArgumentException("Incorrect addres!");
		}

		this.ads = new ArrayList<Ad>();
	}

}
