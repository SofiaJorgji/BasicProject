package com.sqa.sj.adactintestsuite;

import org.openqa.selenium.*;
import org.testng.annotations.*;

public class TC17 extends AdactinTest {

	@Test
	public void ap17() {
		String orderId = "1KA5AMC9Z6";
		WebElement bookedItineraryLink =
				getDriver().findElement(By.cssSelector("a[href='BookedItinerary.php']"));
		bookedItineraryLink.click();
		WebElement searchOrderId = getDriver().findElement(By.id("order_id_text"));
		searchOrderId.clear();
		searchOrderId.sendKeys(orderId);
		WebElement goButton = getDriver().findElement(By.id("search_hotel_id"));
		goButton.click();
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
