package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

public class TC19 extends AdactinTest {

	@Test
	public void ap19() {
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
		WebElement bookNowButton = getDriver().findElement(By.id("book_now"));
		bookNowButton.click();
		String orderId = getDriver().findElement(By.id("order_no")).getAttribute("value");
		WebElement bookedItineraryLink =
				getDriver().findElement(By.cssSelector("a[href='BookedItinerary.php']"));
		bookedItineraryLink.click();
		WebElement searchField = getDriver().findElement(By.id("order_id_text"));
		searchField.clear();
		searchField.sendKeys(orderId);
		WebElement goButton = getDriver().findElement(By.id("search_hotel_id"));
		goButton.click();
		WebElement cancelButton = getDriver().findElement(By.xpath(
				"html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/input"));
		cancelButton.click();
		getDriver().switchTo().alert().accept();
		WebElement orderIdNr = getDriver().findElement(By.id("order_id_text"));
		orderIdNr.clear();
		orderIdNr.sendKeys(orderId);
		WebElement searchIdButton = getDriver().findElement(By.id("search_hotel_id"));
		searchIdButton.click();
		String noResults =
				getDriver().findElement(By.id("search_result_error")).getText();
		String[] results = noResults.split(" ");
		String actualNrOfResults = results[0];
		String expectedNrOfResults = "0";
		Assert.assertEquals(actualNrOfResults, expectedNrOfResults);
	}
}
