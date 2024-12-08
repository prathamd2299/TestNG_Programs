package testDependency;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestDependency {
	// Test dependency is used to avoid other test methods
	// if main test method is failed
	public static String trackNum = "";

	@Ignore
	@Test
	public void CreateShipment() {
		System.out.println(5 / 0);
		System.out.println("Create Shipment");
		trackNum = "abc12#34";
	}

	// Even though we give priority to this method
	// but because it is dependent on CreateShipment method
	// CreateShipment method execute first
	// then TrackShipment method execute second
	// And then CancelShipment execute at last

	// If alwaysRun set to true, this test method will always be run
	// even if it depends on a method that failed.
	// This attribute will be ignored
	// if this test doesn't depend on any method or group.
//	@Test(priority = 1, dependsOnMethods = "CreateShipment", alwaysRun = true)
//	public void TrackShipment() throws Exception {
//		if (trackNum != "") {
//			System.out.println("Track Shipment");
//		} else {
//			throw new Exception("invalid tracking number");
//		}
//	}

	// If we deleted/skipped/ignored dependent test method
	// it will give exception

	// If ignoreMissingDependencies set to true, this test will run
	// even if the methods it depends on are missing or excluded
	@Test(dependsOnMethods = "CreateShipment", ignoreMissingDependencies = true)
	public void TrackShipment() throws Exception {
		if (trackNum != "") {
			System.out.println("Track Shipment");
		} else {
			throw new Exception("invalid tracking number");
		}
	}

	@Test(dependsOnMethods = { "CreateShipment", "TrackShipment" }, ignoreMissingDependencies = true)
	public void CancelShipment() throws Exception {
		if (trackNum != "") {
			System.out.println("Cancel Shipment");
		} else {
			throw new Exception("invalid tracking number");
		}
	}
}
