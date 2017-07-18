package com.sqa.sj.sonoma;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.sj.auto.*;

public class WilliamsSonomaTest extends AbstractLoginTest {

	private static boolean popupTerminated = false;

	public WilliamsSonomaTest() {
		super("http://williams-sonoma.com");
	}

	public void checkForPopup() {
		if (!popupTerminated) {
			if (isPresent(By.cssSelector("a.stickyOverlayMinimizeButton"))) {
				WebElement popupCloseIcon = getDriver().findElement(By.cssSelector("a.stickyOverlayMinimizeButton"));
				getLog().info("Popup is being closed");
				popupCloseIcon.click();
				popupTerminated = true;
			} else {
				getLog().info("Popup is not present and can not be closed.");
			}
		}
	}

	@Override
	public void login(String username, String password) {
		getLog().info("Logging in to " + this.getBaseUrl() + " with username:password = " + username + ":" + password);
		getDriver().get(getBaseUrl());
		checkForPopup();
		Actions accountHover = new Actions(getDriver());
		WebElement myAccountButton = getDriver().findElement(By.cssSelector(".my-account > a"));
		accountHover.moveToElement(myAccountButton).perform();
		WebElement signInButton = (new WebDriverWait(getDriver(), 10)
				.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("li.sign-in > a")))));
		signInButton.click();
		this.takeScreenshot("Logging In Screenshot");
		WebElement usernameField = getDriver().findElement(By.id("login-email"));
		WebElement passwordField = getDriver().findElement(By.id("login-password"));
		usernameField.clear();
		passwordField.clear();
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		this.takeScreenshot("Credentials In Screenshot");
		usernameField.submit();
	}

	@Override
	public void logout() {
		getLog().info("Logging out of " + this.getBaseUrl());
		WebElement logoutButton = getDriver().findElement(By.className("sign-out"));
		logoutButton.click();
	}
}