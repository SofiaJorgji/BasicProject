package com.sqa.sj.adactintestsuite;

import org.testng.*;
import org.testng.annotations.*;

public class TC1 extends AdactinTest {

	@Test
	public void getTitle() {
		System.out.println("Test Login");
		String expectPageTitle = "AdactIn.com - Search Hotel";
		String actualPageTitle = getDriver().getTitle();
		takeScreenshot();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
	}
}
