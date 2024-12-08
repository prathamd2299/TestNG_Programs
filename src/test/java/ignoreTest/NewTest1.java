package ignoreTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NewTest1 {
	// Even though the test enable is true
	// but Ignore annotation has highest priority
	// so that it will ignore the test methods
	@Ignore
	@Test(enabled = true)
	public void test1() {
		System.out.println("Test 1");
	}

	@Test(enabled = true)
	public void test2() {
		System.out.println("Test 2");
	}

	@Test
	public void test3() {
		System.out.println("Test 3");
	}
}
