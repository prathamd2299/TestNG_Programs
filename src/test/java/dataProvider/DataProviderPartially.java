package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPartially {
	@Test(dataProvider = "testData1", dataProviderClass = DataSupplier.class)
	public void testLogin(String s) {
		System.out.println(s);
	}

//	@DataProvider(indices = { 0, 2 })
//	public String[] testData() {
//		String[] data = new String[] { "yash", "anant", "pratham", "sharad" };
//		return data;
//	}
}
