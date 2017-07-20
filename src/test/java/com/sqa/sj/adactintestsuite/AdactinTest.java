package com.sqa.sj.adactintestsuite;

import org.openqa.selenium.*;

import com.sqa.sj.auto.*;

public class AdactinTest extends AbstractLoginTest {

	private static boolean popupTerminated = false;

	public AdactinTest() {
		super("http://adactin.com/HotelApp");
	}

	@Override
	public void login(String username, String password) {
		getLog().info("Logging in to " + this.getBaseUrl() + " with username:password= "
				+ username + ":" + password);
		getDriver().get(getBaseUrl());
		this.takeScreenshot("Pre-login");
		WebElement usernameField = getDriver().findElement(By.id("username"));
		WebElement passwordField = getDriver().findElement(By.id("password"));
		WebElement loginButton = getDriver().findElement(By.id("login"));
		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();
		this.takeScreenshot("After-login");
	}

	@Override
	public void logout() {
		// getLog().info("Logging out of " + this.getBaseUrl());
		// WebElement logoutField =
		// getDriver().findElement(By.cssSelector("a[href='Logout.php']"));
		// // WebElement logoutField =
		// // getDriver().findElement(By.linkText("Logout"));
		// logoutField.click();
	}
}