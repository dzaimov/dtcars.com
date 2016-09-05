package com.dtcars.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dtcars.exceptions.InvalidEmailException;

public class EmailValidator implements IValidator{
	private static final String EMAIL_REGIX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isValidEmail(String enteredEmail) throws InvalidEmailException {
		Pattern pattern = Pattern.compile(EMAIL_REGIX);

		Matcher matcher = pattern.matcher(enteredEmail);
		
		if((!enteredEmail.isEmpty()) && (enteredEmail != null) && (matcher.matches())){
			return true;
		}

		throw new InvalidEmailException("Incorrect email!");
	}
}
