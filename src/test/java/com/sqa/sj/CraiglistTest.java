package com.sqa.sj;

import java.sql.*;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.sj.auto.*;
import com.sqa.sj.helpers.*;
import com.sqa.sj.helpers.enums.*;
import com.sqa.sj.helpers.exceptions.*;

public class CraiglistTest extends BasicTest {

	public CraiglistTest() {
		super("https://sfbay.craigslist.org/");
	}

	// @DataProvider
	// public Object[][] dp() {
	// return new Object[][] { new Object[] { "selenium", 5 }, new Object[] {
	// "java", 1 }, new Object[] { "qa", 5 } };
	// }
	@DataProvider
	public Object[][] dp() throws ClassNotFoundException, DataTypesMismatchException, SQLException,
			DataTypesCountException, DataTypesTypeException {
		return DataHelper.evalDatabaseTable("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/sqa",
				getProp("dbusername"), getProp("dbpassword"), getProp("tablename"), 0, 0,
				new DataType[] { DataType.INT, DataType.STRING, DataType.INT });
	}

	@Test(dataProvider = "dp")
	public void searchJobs(int id, String keywords, int minResults) {
		System.out.println("id: " + id);
		WebElement jobsButton = getDriver().findElement(By.className("jjj"));
		// WebElement jobsButton =
		// getDriver().findElement(By.cssSelector(".jjj"));
		// WebElement jobsButton = getDriver().findElement(By.className("jjj"));
		jobsButton.click();
		WebElement searchField = getDriver().findElement(By.id("query"));
		searchField.sendKeys(keywords);
		searchField.submit();
		String resultsString = getDriver().findElement(By.className("totalcount")).getText();
		int resultsNum = Integer.parseInt(resultsString);
		takeScreenshot(keywords + "[" + minResults + "]");
		Assert.assertTrue(resultsNum >= minResults,
				"Number of results must exceed " + minResults + " [" + resultsNum + "]");
	}
}
