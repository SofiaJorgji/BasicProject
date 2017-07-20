package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC5 extends AdactinTest {

	@Test
	public void ap5() {
		new Select(getDriver().findElement(By.id("location")))
				.selectByVisibleText("Sydney");
		new Select(getDriver().findElement(By.id("hotels")))
				.selectByVisibleText("Hotel Creek");
		new Select(getDriver().findElement(By.id("room_type")))
				.selectByVisibleText("Standard");
		new Select(getDriver().findElement(By.id("room_nos")))
				.selectByVisibleText("1 - One");
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
		String expectedArrivalDate = today;
		WebElement arrivalDate = getDriver().findElement(By.id("arr_date_0"));
		String actualArrivalDate = arrivalDate.getAttribute("value");
		Assert.assertEquals(actualArrivalDate, expectedArrivalDate);
		String expectedDepartureDate = oneDayFromToday;
		System.out.println(expectedDepartureDate);
		WebElement departureDate = getDriver().findElement(By.id("dep_date_0"));
		String actualDepartureDate = departureDate.getAttribute("value");
		Assert.assertEquals(actualDepartureDate, expectedDepartureDate);
	}
}
