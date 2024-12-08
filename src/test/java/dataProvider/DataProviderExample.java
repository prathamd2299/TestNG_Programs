package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	@Test(dataProvider = "loginData")
	public void login(String un, String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(un);
		System.out.println("Username is: " + username.getAttribute("value"));
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys(pwd);
		System.out.println("Username is: " + password.getAttribute("value"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Logged In Successfully | Practice Test Automation";
		Assert.assertEquals(actualTitle, expectedTitle, "Credentials is invalid");
		System.out.println("You have successfully logged in");
		Thread.sleep(2000);
		driver.quit();
	}

//	@DataProvider(name = "loginData")
//	public Object[][] testData() {
//		Object[][] data = new Object[2][2];
//		data[0][0] = "student";
//		data[0][1] = "Password123";
//		data[1][0] = "Admin";
//		data[1][1] = "admin123";
//		return data;
//	}

	// This will run parallely
	@DataProvider(parallel = true)
	public Object[][] loginData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "student";
		data[0][1] = "Password123";
		data[1][0] = "Admin";
		data[1][1] = "admin123";
		return data;
	}
}
