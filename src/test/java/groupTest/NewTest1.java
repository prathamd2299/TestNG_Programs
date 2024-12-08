package groupTest;

import org.testng.annotations.Test;

public class NewTest1 {
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(groups = { "smoke", "windows.functional", "sanity" })
	public void test2() {
		System.out.println("Test 2");
	}

	@Test(groups = { "windows.regression", "ios.functional" })
	public void test3() {
		System.out.println("Test 3");
	}

}
