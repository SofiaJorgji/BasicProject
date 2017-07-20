package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class TC12 extends AdactinTest {

	@Test
	public void ap12() {
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
		String price =
				getDriver().findElement(By.id("price_night_dis")).getAttribute("value");
		String[] splitPrice = price.split(" ");
		String lastElement = splitPrice[splitPrice.length - 1];
		int pricePerNight = Integer.parseInt(lastElement);
		String noNights =
				getDriver().findElement(By.id("total_days_dis")).getAttribute("value");
		String[] splittingPrice = noNights.split(" ");
		String firstElement = splittingPrice[0];
		int numberOfNights = Integer.parseInt(firstElement);
		String noRooms =
				getDriver().findElement(By.id("room_num_dis")).getAttribute("value");
		String[] splittingnrRooms = noRooms.split(" ");
		String firstElem = splittingnrRooms[0];
		int numberOfRooms = Integer.parseInt(firstElem);
		// Calculate total price excluding GST
		double expectedTotalPrice =
				(double) pricePerNight * numberOfRooms * numberOfNights;
		System.out.println(expectedTotalPrice);
		String actualPrice =
				getDriver().findElement(By.id("total_price_dis")).getAttribute("value");
		String[] splPrice = actualPrice.split(" ");
		String thePrice = splPrice[splPrice.length - 1];
		double actualTotalPrice = Double.parseDouble(thePrice);
		System.out.println(actualTotalPrice);
		if (actualTotalPrice == expectedTotalPrice) {
			System.out.println("Expected and actual total prices match");
		} else {
			System.out.println("Expected and actual total prices do not match");
		}
	}
}
