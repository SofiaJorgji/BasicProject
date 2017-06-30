package com.sqa.sj.auto;

import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * @author Jorgji, Sofia
 * @version 1.0.
 */
public class AutoBasics {

	public static boolean isElementPresent(WebDriver driver, By by, Logger logger) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			logger.warn("Element was not found: " + by);
			return false;
		}
	}
}
