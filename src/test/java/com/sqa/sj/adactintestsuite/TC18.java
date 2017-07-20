package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import junit.framework.*;

public class TC18 extends AdactinTest {

	@Test
	public void ap18() {
		new Select(getDriver().findElement(By.id("location")))
				.selectByVisibleText("Adelaide");
		new Select(getDriver().findElement(By.id("hotels")))
				.selectByVisibleText("Hotel Cornice");
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
		WebElement firstName = getDriver().findElement(By.id("first_name"));
		firstName.sendKeys("Sofia");
		WebElement lastName = getDriver().findElement(By.id("last_name"));
		lastName.sendKeys("Sofia");
		WebElement billingAddress = getDriver().findElement(By.id("address"));
		billingAddress.sendKeys("222 Silvester St, San Francisco, CA, USA");
		WebElement creditCardNr = getDriver().findElement(By.id("cc_num"));
		creditCardNr.sendKeys("4567898765421231");
		new Select(getDriver().findElement(By.id("cc_type"))).selectByVisibleText("VISA");
		new Select(getDriver().findElement(By.id("cc_exp_month")))
				.selectByVisibleText("March");
		new Select(getDriver().findElement(By.id("cc_exp_year")))
				.selectByVisibleText("2021");
		WebElement CVVNr = getDriver().findElement(By.id("cc_cvv"));
		CVVNr.sendKeys("345");
		String beforeHotelName =
				getDriver().findElement(By.id("hotel_name_dis")).getAttribute("value");
		// String beforeLocation =
		// getDriver().findElement(By.id("location_dis")).getAttribute("value");
		String beforeRoomType =
				getDriver().findElement(By.id("room_type_dis")).getAttribute("value");
		String beforeRoomNr =
				getDriver().findElement(By.id("room_num_dis")).getAttribute("value");
		String beforePricePerNight =
				getDriver().findElement(By.id("price_night_dis")).getAttribute("value");
		String beforeTotalDays =
				getDriver().findElement(By.id("total_days_dis")).getAttribute("value");
		WebElement bookNowButton = getDriver().findElement(By.id("book_now"));
		bookNowButton.click();
		String orderId = getDriver().findElement(By.id("order_no")).getAttribute("value");
		WebElement myItineraryButton = getDriver().findElement(By.id("my_itinerary"));
		myItineraryButton.click();
		WebElement searchField = getDriver().findElement(By.id("order_id_text"));
		searchField.clear();
		searchField.sendKeys(orderId);
		WebElement goButton = getDriver().findElement(By.id("search_hotel_id"));
		goButton.click();
		String afterHotelName = getDriver()
				.findElement(By
						.xpath("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/input"))
				.getAttribute("value");
		// String afterLocation = getDriver()
		// .findElement(
		// By.id("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]/input"))
		// .getAttribute("value");
		String afterRoomType = getDriver()
				.findElement(
						By.id("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[12]/input"))
				.getAttribute("value");
		String afterRoomNr = getDriver()
				.findElement(
						By.id("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]/input"))
				.getAttribute("value");
		String afterPricePerNight = getDriver()
				.findElement(
						By.id("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[13]/input"))
				.getAttribute("value");
		String afterTotalDays = getDriver()
				.findElement(
						By.id("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/input"))
				.getAttribute("value");
		Assert.assertEquals(beforeHotelName, afterHotelName);
		// Assert.assertEquals(beforeLocation, afterLocation);
		Assert.assertEquals(beforeRoomType, afterRoomType);
		Assert.assertEquals(beforeRoomNr, afterRoomNr);
		Assert.assertEquals(beforePricePerNight, afterPricePerNight);
		Assert.assertEquals(beforeTotalDays, afterTotalDays);
	}
}
