package com.google.www;

import org.testng.annotations.Test;

public class PriorityTest {
	// It will execute the test methods in ASCII value order
	// means the order of uppercase letter first and then lowercase letters
	// because the uppercase letters ASCII start from 65 to 90
	// and the lowercase letters ASCII start from 97 to 122
	@Test(priority = 5)
	public void SignUp() {
		System.out.println("Sign Up");
	}

	@Test(priority = 2)
	public void login() {
		System.out.println("Login");
	}

	@Test(priority = 3)
	public void searchForTheFlight() {
		System.out.println("Search for the flight");
	}

	@Test(priority = 4)
	public void BookTheFlight() {
		System.out.println("Book the flight");
	}

	//If the priority is same then it follows the ASCII order for methods
	@Test(priority = 5)
	public void SaveTheTicket() {
		System.out.println("Save the ticket");
	}
	
//	default priority is 0
//	@Test
//	public void logout() {
//		System.out.println("Log out");
//	}
	
//	negative first	
	@Test(priority = -6)
	public void logout() {
		System.out.println("Log out");
	}
	
}
