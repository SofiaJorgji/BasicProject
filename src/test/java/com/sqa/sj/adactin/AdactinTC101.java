package com.sqa.sj.adactin;

import org.testng.*;
import org.testng.annotations.*;

public class AdactinTC101 extends AdactinTest {

	@Test
	public void doTest() {
		System.out.println("Test Login");
		String expectPageTitle = "AdactIn.com - Search Hotel";
		String actualPageTitle = getDriver().getTitle();
		takeScreenshot();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
	}
}