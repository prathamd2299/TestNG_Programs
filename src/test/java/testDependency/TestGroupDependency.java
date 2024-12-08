package testDependency;

import org.testng.annotations.Test;

public class TestGroupDependency {
	@Test(groups = "security")
	public void testMethod1() {
		System.out.println("Test 1 security");
	}

	@Test(groups = "security")
	public void testMethod2() {
		System.out.println("Test 2 security");
	}

	@Test(groups = "security")
	public void testMethod3() {
//		System.out.println(5 / 0);
		System.out.println("Test 3 security");
	}

	@Test(groups = "usability")
	public void testMethod4() {
		System.out.println(5 / 0);
		System.out.println("Test 4 usability");
	}

	@Test(groups = "usability")
	public void testMethod5() {
		System.out.println("Test 5 usability");
	}

	@Test(groups = "performance")
	public void testMethod6() {
		System.out.println("Test 6 performance");
	}

	// If alwaysRun set to true, this test method will always be run
	// even if it depends on a method or group that failed.
	// This attribute will be ignored
	// if this test doesn't depend on any method or group.

	// If we use alwaysRunattribute then output will be
	// Test 1 security
	// Test 2 security
	// Main Test
	// and also Passes: 3, Failures: 1, Skips: 0

	// If any above method failed then output will be
	// Test 1 security
	// Test 2 security
	// and also passes: 2, failure: 1, skips: 1

//	@Test(dependsOnGroups = { "security", "usability", "performance" }, alwaysRun = true)
//	public void testMethod0() {
//		System.out.println("Main Test");
//	}

//	@Test(dependsOnGroups = { "security", "usability", "performance" })
//	public void testMethod0() {
//		System.out.println("Main Test");
//	}
}
