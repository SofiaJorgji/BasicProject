package com.sqa.sj;

import org.testng.annotations.*;

public class AmazonDDTest {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "dog treats", 5, 113.7 }, };
	}

	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
	}
}
