package com.google.www;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations {
	public static WebDriver driver;

	@Test
	public void testMethod1() {
		System.out.println("Test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("Test method 2");
	}

	@Test
	public void testFacebook() {
		WebElement un = driver.findElement(By.name("email"));
		un.sendKeys("Prathamesh");
		System.out.println(driver.getTitle());
		System.out.println("Uername value is: " + un.getAttribute("value"));
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys("Prat@123");
		System.out.println("Password value is: " + pass.getAttribute("value"));

		// Title assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook – log in or sign up";
		assertEquals(actualTitle, expectedTitle, "Title is mismatched");

		SoftAssert sa = new SoftAssert();

		// URL assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/45";
		sa.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");

		// Text assertion
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "Prathamesh";
		sa.assertEquals(actualText, expectedText, "Text is mismatched");

		// Text assertion
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "0.8px solid rgb(27, 116, 228)";
		sa.assertEquals(actualBorder, expectedBorder, "Border is mismatched");
		sa.assertAll();
	}

	@BeforeMethod
	@Parameters({ "browserName", "url" })
	public void beforeMethod(String browserName, String url) {
		System.out.println("This will execute Before Method");
		System.out.println(browserName + " " + url);
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid driver");
			break;
		}
		driver.get(url);
	}

	@AfterMethod
	@Parameters("sleepTime")
	public void tearDown(String sleepTime) throws InterruptedException {
		System.out.println(sleepTime);
		Thread.sleep(Long.valueOf(sleepTime));
		driver.quit();
		System.out.println("This will execute After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This will execute Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This will execute After Class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("This will execute Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This will execute After Test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This will execute Before Suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This will execute After Suite");
	}

}
