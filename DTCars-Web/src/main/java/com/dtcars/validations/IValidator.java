package com.dtcars.validations;

public interface IValidator {

	static boolean isValidString(String string) {
		if (string != null && !string.trim().isEmpty()) {
			return true;
		}

		return false;
	}
}
