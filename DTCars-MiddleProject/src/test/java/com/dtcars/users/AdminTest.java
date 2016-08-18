package com.dtcars.users;

import org.junit.Test;

import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidPasswordException;

public class AdminTest {

	@Test (expected =  InvalidEmailException.class)
	public void createAdminWithIncorrectEmailTest() throws InvalidEmailException, InvalidPasswordException {
		Admin admin = new Admin("asasd", "Admin123");
	}

}
