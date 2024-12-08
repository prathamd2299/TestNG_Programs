package groupTest;

import org.testng.annotations.Test;

public class NewTest2 {
	@Test(groups = { "sanity", "smoke" })
	public void test4() {
		System.out.println("Test 4");
	}

	@Test(groups = { "regression", "sanity" })
	public void test5() {
		System.out.println("Test 5");
	}

	@Test
	public void test6() {
		System.out.println("Test 6");
	}
}
