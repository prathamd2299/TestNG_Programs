package testDependency;

import org.testng.annotations.Test;

public class Depen {
	@Test
	public void M1() {
		System.out.println(5 / 0);
		System.out.println("M1");
	}

	@Test(dependsOnMethods = "M1", alwaysRun = true)
	public void M2() {
		System.out.println("M2");
	}
}
