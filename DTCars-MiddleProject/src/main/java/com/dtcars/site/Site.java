package com.dtcars.site;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.dtcars.ads.Ad;
import com.dtcars.exceptions.InvalidEmailException;
import com.dtcars.exceptions.InvalidNameException;
import com.dtcars.exceptions.InvalidPasswordException;
import com.dtcars.exceptions.InvalidPhoneNumberException;
import com.dtcars.exceptions.InvalidUserException;
import com.dtcars.exceptions.NoAdminsException;
import com.dtcars.exceptions.NoSuchUser;
import com.dtcars.users.Admin;
import com.dtcars.users.IAdmin;
import com.dtcars.users.PrivateUser;
import com.dtcars.users.User;

public class Site {
	private static final String ADMINISTRATOR_CODE = "admin123";

	private static Scanner scan = new Scanner(System.in);
	private static Set<User> users = new HashSet<User>();
	private static Set<Ad> ads = new HashSet<Ad>();
	private static Map<String, Set<String>> techFeatures;
	private static int counterOfAds;

	public static void main(String[] args) {
		menuLoop: while (true) {
			System.out.println("1.View ads | 2.Sing in | 3.Sing up");
			switch (scan.nextLine()) {
			case "1":
				System.out.println("Under construction :)");
				break menuLoop;

			case "2":
				try {
					signInUser();
				} catch (NoSuchUser e) {
					System.err.println(e.getMessage());
				}
				break menuLoop;

			case "3":
				registerUser();
				break menuLoop;

			default:
				System.err.println("Incorrect choice! Please try again!");
				break;
			}
		}

	}

	private static void registerUser() {
		System.out.println("REGISTRATION:" + System.lineSeparator() + "1.Private user | 2.Administrator");

		loop: while (true) {
			switch (scan.nextLine()) {
			case "1":
				registerPrivateUser();
				break loop;

			case "2":
				registerAdmin();
				break loop;

			default:
				System.err.println("Incorrect choice! Please try again!");
				break;
			}
		}
	}

	private static void registerAdmin() {
		System.out.println("Please enter administrator code: ");
		while (!scan.nextLine().equals(ADMINISTRATOR_CODE)) {
			System.err.println("Incorrect administrator code! Please try again: ");
		}

		System.out.println("Administrator code is correct!");

		while (true) {
			System.out.println("Please enter your email: ");
			String email = scan.nextLine();

			System.out.println(
					"Please enter your password[min 8 characters](must have at least one capital letter, one digit): ");
			String password = scan.nextLine();

			try {
				Admin admin = new Admin(email, password);
				users.add(admin);
				System.out.println("Successful registration admin with email: " + email);
				break;
			} catch (InvalidEmailException | InvalidPasswordException e) {
				System.err.println(e.getMessage() + " Please try again!");
			}
		}

	}

	private static void registerPrivateUser() {
		while (true) {
			System.out.println("Please enter your email: ");
			String email = scan.nextLine();

			System.out.println(
					"Please enter your password[min 8 characters](must have at least one capital letter, one digit): ");
			String password = scan.nextLine();

			System.out.println("Please enter your name: ");
			String name = scan.nextLine();

			System.out.println("Please enter your phone number[+359...]: ");
			String phoneNumber = scan.nextLine();

			System.out.println("Please enter your address: ");
			String address = scan.nextLine();

			try {
				PrivateUser user = new PrivateUser(email, password, name, phoneNumber, address);
				try {
					if (getAdmin().checkUser(user)) {
						users.add(user);
						System.out.println("Successful registration user with email: " + email);
						break;
					}
				} catch (NoAdminsException e) {
					System.err.println(e.getMessage());
					break;
				} catch (InvalidUserException e) {
					System.err.println(e.getMessage());
				}
			} catch (InvalidEmailException | InvalidPasswordException | InvalidNameException
					| InvalidPhoneNumberException e) {
				System.err.println(e.getMessage() + " Please try again!");
			}
		}
	}

	private static IAdmin getAdmin() throws NoAdminsException {
		for (User user : users) {
			if (user instanceof IAdmin) {
				return (IAdmin) user;
			}
		}
		throw new NoAdminsException("No free admins to check your registration...Sorry...Please try again later :)");
	}

	private static User signInUser() throws NoSuchUser {
		System.out.println("SIGN IN");
		System.out.println("Please enter your email: ");
		String email = scan.nextLine();

		System.out.println("Please enter your password: ");
		String password = scan.nextLine();

		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}

		throw new NoSuchUser("No such user with this email: " + email);
	}
	
	private void search(String typeOfAd, Set<String> techFeatures) {
		// TODO Auto-generated method stub

	}
	
	private void display5AdsByCriteria(String criteria) {
		// TODO Auto-generated method stub

	}
	
	private void addNewAd(Ad ad, String email) {
		// TODO Auto-generated method stub

	}
	
	private void sortDealersByCriteria(String criteria) {
		// TODO Auto-generated method stub

	}
	
	private void searchDealer(String name) {
		// TODO Auto-generated method stub

	}
	
	private void searchDealerByCriteria(String criteria) {
		// TODO Auto-generated method stub

	}
		
	private void showNotification(long id, String email) {
		// TODO Auto-generated method stub

	}
	
	public static Ad getAdByID(long id) {
		for (Iterator<Ad> iterator = ads.iterator(); iterator.hasNext();) {
			Ad ad = iterator.next();
			if (ad.getAdID() == id) {
				return ad;
			}
		}
		return null;
	}
	
}
