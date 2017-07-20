package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class TC16 extends AdactinTest {

	@Test
	public void ap16() {
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
		WebElement bookedItineraryLink =
				getDriver().findElement(By.cssSelector("a[href='BookedItinerary.php']"));
		bookedItineraryLink.click();
		try {
			String hotelName = getDriver()
					.findElement(By
							.xpath("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/input"))
					.getAttribute("value");
			if (hotelName.equals("Hotel Creek")) {
				System.out.println("Hotel name is displayed correctly");
			}
		} catch (Exception e) {
			System.out.println("Hotel name is not displayed correctly");
		}
		try {
			String hotelName = getDriver()
					.findElement(By
							.xpath("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]/input"))
					.getAttribute("value");
			if (hotelName.equals("Sofia")) {
				System.out.println("Name is displayed correctly");
			}
		} catch (Exception e) {
			System.out.println("Name is not displayed correctly");
		}
		try {
			String hotelName = getDriver()
					.findElement(By
							.xpath("html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]/input"))
					.getAttribute("value");
			if (hotelName.equals("Sydney")) {
				System.out.println("Location is displayed correctly");
			}
		} catch (Exception e) {
			System.out.println("Location is not displayed correctly");
		}
	}
}
