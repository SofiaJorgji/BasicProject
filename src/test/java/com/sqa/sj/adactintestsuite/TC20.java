package com.sqa.sj.adactintestsuite;

import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC20 extends AdactinTest {

	private static boolean isElementPresent(WebDriver driver, By by) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Test
	public void ap20() {
		String expectPageTitle = "AdactIn.com - Search Hotel";
		String actualPageTitle = getDriver().getTitle();
		takeScreenshot();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
		WebElement searchLink =
				getDriver().findElement(By.cssSelector("a[href='SearchHotel.php']"));
		searchLink.click();
		actualPageTitle = getDriver().getTitle();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
		isElementPresent(getDriver(), By.className("login_title"));
		WebElement bookedItineraryLink =
				getDriver().findElement(By.cssSelector("a[href='BookedItinerary.php']"));
		bookedItineraryLink.click();
		expectPageTitle = "AdactIn.com - Select Hotel";
		actualPageTitle = getDriver().getTitle();
		Assert.assertEquals(actualPageTitle, expectPageTitle);
	}
}
