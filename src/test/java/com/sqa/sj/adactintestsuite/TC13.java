package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class TC13 extends AdactinTest {

	@Test
	public void ap13() {
		new Select(getDriver().findElement(By.id("location")))
				.selectByVisibleText("Sydney");
		new Select(getDriver().findElement(By.id("hotels")))
				.selectByVisibleText("Hotel Creek");
		new Select(getDriver().findElement(By.id("room_type")))
				.selectByVisibleText("Standard");
		new Select(getDriver().findElement(By.id("room_nos")))
				.selectByVisibleText("2 - Two");
		// today's date
		DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal1 = Calendar.getInstance();
		String today = dateFormat1.format(cal1.getTime());
		WebElement checkinDate = getDriver().findElement(By.id("datepick_in"));
		checkinDate.clear();
		checkinDate.sendKeys(today);
		// 1 day from today's date
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, 1);
		String oneDayFromToday = dateFormat2.format(cal2.getTime());
		WebElement checkoutDate = getDriver().findElement(By.id("datepick_out"));
		checkoutDate.clear();
		checkoutDate.sendKeys(oneDayFromToday);
		new Select(getDriver().findElement(By.id("adult_room")))
				.selectByVisibleText("1 - One");
		WebElement searchButton = getDriver().findElement(By.id("Submit"));
		searchButton.click();
		WebElement selectHotelButton = getDriver().findElement(By.id("radiobutton_0"));
		selectHotelButton.click();
		WebElement continueButton = getDriver().findElement(By.id("continue"));
		continueButton.click();
		// String expectedHotelName = "Hotel Creek";
		// String actualHotelName =
		// getDriver().findElement(By.id("hotel_name_dis")).getAttribute("value");
		// Assert.assertEquals(actualHotelName, expectedHotelName);
	}
}
