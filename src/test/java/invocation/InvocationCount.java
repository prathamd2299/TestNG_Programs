package invocation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationCount {
	//The number of times this method should be invoked.
	//This method will execute 3 times. 
	@Test(invocationCount = 3)
	public void testMethod1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("Username is: " + driver.findElement(By.xpath("//p[@id='user_value']")).getText());

		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("Email is: " + driver.findElement(By.xpath("//p[@id='user_value']")).getText());
		driver.quit();
	}
}
