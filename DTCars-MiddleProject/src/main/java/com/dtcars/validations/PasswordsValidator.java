package com.dtcars.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dtcars.exceptions.InvalidPasswordException;

public class PasswordsValidator implements IValidator{
	private static final String PASSWORD_REGIX = "^[a-zA-Z0-9]{8,}$";

	public static boolean isValidPassword(String enteredPassword) throws InvalidPasswordException {
		Pattern pattern = Pattern.compile(PASSWORD_REGIX);

		Matcher matcher = pattern.matcher(enteredPassword);

		if ((!enteredPassword.isEmpty()) && (enteredPassword != null) && (matcher.matches())) {
			return true;
		}

		throw new InvalidPasswordException("Incorrect password!");
	}
}
