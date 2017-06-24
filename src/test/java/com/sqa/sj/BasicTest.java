package com.sqa.sj;

import org.testng.annotations.*;

public class BasicTest {

	@AfterClass
	public void afterClass() {
		System.out.println("\tTeardown After Class");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\t\tAfter Test Method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Whole Test Class");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\tSetup Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\tBefore Test Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Whole Test Class");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "dataset a" }, new Object[] { 2, "dataset b" },
				new Object[] { 3, "dataset c" }, new Object[] { 4, "dataset d" } };
	}

	@Test(dataProvider = "dp")
	public void myDataDrivenTest(Integer n, String s) {
		System.out.println("\t\t\tTest " + n + " with data: " + s);
	}
}
