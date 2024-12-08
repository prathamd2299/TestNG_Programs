package ignoreTest;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore //this wil ignore the class for execution
public class NewTest2 {
	@Test
	public void test4() {
		System.out.println("Test 4");
	}

	@Ignore
	@Test
	public void test5() {
		System.out.println("Test 5");
	}

	@Test
	public void test6() {
		System.out.println("Test 6");
	}
}
