package com.dtcars.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dtcars.exceptions.InvalidPhoneNumberException;

public class PhoneNumberValidator implements IValidator {
	private static final String PHONE_NUMBER_REGEX = "^\\+(?:[0-9] ?){6,14}[0-9]$";

	public static boolean isValidPhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
		Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);

		Matcher matcher = pattern.matcher(phoneNumber);

		if ((!phoneNumber.isEmpty()) && (phoneNumber != null) && (matcher.matches())) {
			return true;
		}

		throw new InvalidPhoneNumberException("Incorrect phone number!");
	}
}
