package invocation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPollSize {
	// The method will be invoked from multiple threadsas
	// specified by invocationCount. Note: this attribute is
	// ignored if invocationCount is not specified
	// It will run parallely for 2 thread at a time means two browser at a time and
	// remainig 1 on second time
	@Test(invocationCount = 3, threadPoolSize = 2)
	public void testmethod3() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		System.out.println("User name: " + driver.findElement(By.id("user_value")).getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='email']")).click();
		System.out.println("Email address: " + driver.findElement(By.id("user_value")).getText());
		driver.quit();

	}
}
