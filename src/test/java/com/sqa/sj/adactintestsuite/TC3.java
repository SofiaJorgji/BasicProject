package com.sqa.sj.adactintestsuite;

import java.text.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

public class TC3 extends AdactinTest {

	@Test
	public void ap3() {
		new Select(getDriver().findElement(By.id("location")))
				.selectByVisibleText("Sydney");
		new Select(getDriver().findElement(By.id("hotels")))
				.selectByVisibleText("Hotel Creek");
		new Select(getDriver().findElement(By.id("room_type")))
				.selectByVisibleText("Standard");
		new Select(getDriver().findElement(By.id("room_nos")))
				.selectByVisibleText("1 - One");
		// 7 days from today's date
		DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		cal1.add(Calendar.DATE, -5);
		String fiveDaysBeforeToday = dateFormat1.format(cal1.getTime());
		// 5 days from today's date
		DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.DATE, -3);
		String threeDaysBeforeToday = dateFormat2.format(cal2.getTime());
		WebElement checkinDate = getDriver().findElement(By.id("datepick_in"));
		checkinDate.clear();
		checkinDate.sendKeys(fiveDaysBeforeToday);
		WebElement checkoutDate = getDriver().findElement(By.id("datepick_out"));
		checkoutDate.clear();
		checkoutDate.sendKeys(threeDaysBeforeToday);
		WebElement searchButton = getDriver().findElement(By.id("Submit"));
		searchButton.click();
		// String expectedError = "Check-In Date shall be before than Check-Out
		// Date";
		// WebElement error = getDriver().findElement(By.id("checkin_span"));
		// String actualError = error.getText();
		// Assert.assertEquals(actualError, expectedError);
	}
}
