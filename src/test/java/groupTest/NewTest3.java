package groupTest;

import org.testng.annotations.Test;

//When we define group name at class level it is called Partial group
@Test(groups = "all") // It is accessible for all the test methods inside this class
public class NewTest3 {
//All the test methods re part of the all name group
	@Test(groups = { "functional", "smoke" })
	public void test7() {
		System.out.println("Test 7");
	}

	@Test
	public void test8() {
		System.out.println("Test 8");
	}

	@Test
	public void test9() {
		System.out.println("Test 9");
	}
}
