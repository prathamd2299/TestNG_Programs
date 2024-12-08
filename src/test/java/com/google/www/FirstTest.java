package com.google.www;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTest {
	public static WebDriver driver;

	@BeforeMethod
	@Parameters("browserName")
	public void launchBrowser(@Optional("chrome") String browserName) {
		System.out.println("This will execute Before Method");
		System.out.println(browserName);
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
	}

	@AfterMethod
	@Parameters("sleepTime")
	public void tearDown(Long sleepTime) throws InterruptedException {
		System.out.println(sleepTime);
		Thread.sleep(sleepTime);
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

	@Test
	public void testGoogle() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Browser Stack", Keys.ENTER);
		System.out.println(driver.getTitle());
		// Assertion is an expression which will verify
		// the actual test outcome with expected test outcome
		String actual = driver.getTitle();
		String expected = "Browser Stack - Google Search";

		// Hard assertion throw the exception immediately upon failure of assertions
		assertEquals(actual, expected, "Title is mismatched");
	}

}
