package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC11 extends AdactinTest {

	@Test
	public void ap11() {
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
		String hotelNameBeforeContinueButton = getValueAttribute("hotel_name_0", "value");
		String locationBeforeContinueButton = getValueAttribute("location_0", "value");
		String roomTypeBeforeContinueButton = getValueAttribute("room_type_0", "value");
		String totalDaysBeforeContinueButton = getValueAttribute("no_days_0", "value");
		String pricePerNightBeforeContinueButton =
				getValueAttribute("price_night_0", "value");
		WebElement selectHotelButton = getDriver().findElement(By.id("radiobutton_0"));
		selectHotelButton.click();
		WebElement continueButton = getDriver().findElement(By.id("continue"));
		continueButton.click();
		String hotelNameAfterContinuationButton =
				getValueAttribute("hotel_name_dis", "value");
		String locationAfterContinuationButton =
				getValueAttribute("location_dis", "value");
		String roomTypeAfterContinuationButton =
				getValueAttribute("room_type_dis", "value");
		String totalDaysAfterContinuationButton =
				getValueAttribute("total_days_dis", "value");
		String pricePerNightAfterContinuationButton =
				getValueAttribute("price_night_dis", "value");
		Assert.assertEquals(hotelNameBeforeContinueButton,
				hotelNameAfterContinuationButton);
		Assert.assertEquals(locationBeforeContinueButton,
				locationAfterContinuationButton);
		Assert.assertEquals(roomTypeBeforeContinueButton,
				roomTypeAfterContinuationButton);
		Assert.assertEquals(pricePerNightBeforeContinueButton,
				pricePerNightAfterContinuationButton);
	}

	public String getValueAttribute(String id, String attribute) {
		return getDriver().findElement(By.id(id)).getAttribute(attribute);
	}
}
