package com.sqa.sj.ebay;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.sj.auto.*;

public class EbayTest extends AbstractLoginTest {

	public EbayTest(String baseUrl) {
		super("https://www.ebay.com/");
	}

	@BeforeMethod
	public void emptyCart() {
		getLog().info("Emptying shopping cart...");
		getDriver().get(getBaseUrl());
		WebElement cartButton = getDriver().findElement(By.id("gh-cart-i"));
		cartButton.click();
		// while (isPresent(By.linkText("Remove"))) {
		while (isPresent(By.cssSelector(".action:nth-child(1)"))) {
			WebElement removeFromCartButton = getDriver().findElement(By.linkText("Remove"));
			removeFromCartButton.click();
		}
	}

	@Override
	public void login(String username, String password) {
		getLog().info("Logging into " + this.getBaseUrl());
		getDriver().get(getBaseUrl());
		WebElement signInButton = getDriver().findElement(By.cssSelector("#gh-ug > a"));
		signInButton.click();
		WebElement usernameField = getDriver().findElement(By.cssSelector("#pri_signin *[type='text']"));
		WebElement passwordField = getDriver().findElement(By.cssSelector("#pri_signin *[type='password']"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		passwordField.submit();
	}

	@Override
	public void logout() {
		getLog().info("Logging out of " + this.getBaseUrl());
		getDriver().get(getBaseUrl());
		WebElement accountLoginButton = getDriver().findElement(By.className("gh-eb-arw"));
		accountLoginButton.click();
		WebElement signOutButton = getDriver().findElement(By.cssSelector("#gh-uo > a"));
		signOutButton.click();
	}
}
