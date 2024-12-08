package dataProvider;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	@DataProvider
	public String[] testData() {
		String[] data = new String[] { "yash", "anant", "pratham", "sharad" };
		return data;
	}
	
	@DataProvider
	public String[] testData1() {
		String[] data = new String[] { "payal", "ananta", "bhavna", "navneet" };
		return data;
	}
}
