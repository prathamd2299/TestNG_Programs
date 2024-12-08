package invocation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InvocationTimeOut {
	// The maximum number of milliseconds that the total number of invocations on
	// this test method should take.
	// This annotation will be ignored if the attribute invocationCount is not
	// specified on this method.
	// If it hasn't returned after this time, it will be marked as a FAIL.
	// and it will throw the exception.
	@Test(invocationCount = 3, invocationTimeOut = 20000)
	public void testMethod2() throws InterruptedException {
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
