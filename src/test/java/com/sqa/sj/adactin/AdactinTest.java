package com.sqa.sj.adactin;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.sj.helpers.*;

/**
 * @author Jorgji, Sofia
 * @version 1.0
 */
public class AdactinTest extends AbstractLoginTest {

	public AdactinTest() {
		super("http://adactin.com/HotelApp");
	}

	@BeforeClass
	public void adactinLogin() {
		login("sofiajorgji20", "testAdactin");
	}

	@AfterClass
	public void adactinLogout() {
		logout();
	}

	/**
	 * @see com.sqa.sj.helpers.AbstractLoginTest#login()
	 */
	@Override
	public void login(String username, String password) {
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

	/**
	 * @throws InterruptedException
	 * @see com.sqa.sj.adactin.AbstractLoginTest#logout()
	 */
	@Override
	public void logout() {
		WebElement logoutField = getDriver().findElement(By.cssSelector("a[href='Logout.php']"));
		// WebElement logoutField =
		// getDriver().findElement(By.linkText("Logout"));
		// Thread.sleep(20000);
		logoutField.click();
	}
}
