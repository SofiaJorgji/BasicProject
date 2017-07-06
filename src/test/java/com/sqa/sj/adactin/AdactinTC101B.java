package com.sqa.sj.adactin;

import org.testng.annotations.*;

import adactin.*;

public class AdactinTC101B extends BasicTest {

	/**
	 * @param baseUrl
	 */
	public AdactinTC101B(String baseUrl) {
		super("http://adactin.com/HotelApp");
		this.testingName = "Adactin PG ";
	}

	@Test
	public void loginTest() {
		AdactinHomePage homePage = new AdactinHomePage(this);
		this.takeScreenshot();
		homePage.login("sofiajorgji20", "testAdactin");
		this.takeScreenshot();
	}
}
