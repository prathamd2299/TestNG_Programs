package com.google.www;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeOut {
	// The maximum number of milliseconds this test should take.
	// If it hasn't returned after thistime,
	// it will be marked as a FAIL and here the browser will not close.
	@Test(timeOut = 30000)
	public void testmethod1() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.quit();
	}

	// The list of exceptions that a test method is expected to throw.
	//If no exception or a different than one on this list is thrown,
	// this test will be marked a failure.
	@Test(expectedExceptions = { NoSuchElementException.class })
	public void testmethod2() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("abcd")).click();
		driver.quit();
	}
}
