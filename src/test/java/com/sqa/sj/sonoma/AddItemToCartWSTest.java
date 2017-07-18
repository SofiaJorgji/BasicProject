package com.sqa.sj.sonoma;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class AddItemToCartWSTest extends WilliamsSonomaTest {

	@Test(dataProvider = "dp")
	public void addItemToCartTest(int id, String itemName, int quantity, double expectedPrice) {
		getLog().info("Test " + id + "\n\tSearching for " + quantity + " " + itemName
		// getLog().info(System.getProperty("user") + "Test " + id +
		// "\n\tSearching for " + quantity + " " + itemName
				+ "(s) for an expected total of $" + expectedPrice);
		// this.takeScreenshot();
		checkForPopup();
		WebElement searchField = getDriver().findElement(By.id("search-field"));
		searchField.clear();
		searchField.sendKeys(itemName);
		searchField.submit();
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "All-Clad NS1 Nonstick Induction Covered Fry Pan 12", 4, 319.80 },
				new Object[] { 2, "Walnut Knifedock In-Drawer Deluxe Tray", 3, 239.85 },
				new Object[] { 3, "Google Home", 2, 198.00 },
				new Object[] { 4, "Cuisinart Tri-ply Stainless-Steel 10-Piece Cookware Set", 2, 799.90 },
				new Object[] { 5, "Chef'sChoice 1520 Angle Select Electric Knife Sharpener", 3, 599.85 },
				new Object[] { 6, "Rustic Melamine Chip Dip Platter Ivory", 4, 83.88 },
				new Object[] { 7, "Backyard Beehive & Starter Kit", 3, 619.85 },
				new Object[] { 8, "Wusthof Classic Ikon Paring Knife 3 1 2", 6, 359.70 } };
	}
}
