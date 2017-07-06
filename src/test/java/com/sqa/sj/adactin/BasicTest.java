package com.sqa.sj.adactin;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

import com.sqa.sj.auto.*;

/**
 * @author Jorgji, Sofia
 * @version 1.0
 */
public class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl);
	}

	@BeforeClass(enabled = false)
	public void setUInternetExplorer() throws Exception {
		System.out.println("Setup driver");
		// Set system property to use IE driver
		System.setProperty("webdriver.ie.driver", "drivers/iedriver");
		// Setup the driver to use Chrome
		setDriver(new InternetExplorerDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Go to Base URL
		getDriver().get(getBaseUrl());
	}

	@Override
	@BeforeClass(enabled = true)
	public void setUpChrome() throws Exception {
		System.out.println("Setup driver");
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		// Setup the driver to use Chrome
		setDriver(new ChromeDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Go to Base URL
		getDriver().get(getBaseUrl());
	}

	@Override
	@BeforeClass(enabled = false)
	public void setUpFirefox() throws Exception {
		System.out.println("Setup driver");
		// Setup the driver to use Firefox
		setDriver(new FirefoxDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Go to Base URL
		getDriver().get(getBaseUrl());
	}

	@Override
	@BeforeClass(enabled = false)
	public void setUpSafari() throws Exception {
		System.out.println("Setup driver");
		// Setup the driver to use Safari
		setDriver(new SafariDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Go to Base URL
		getDriver().get(getBaseUrl());
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		System.out.println("Quitting driver");
		getDriver().quit();
	}

	// @Test
	// public void test1() {
	// getDriver().get(getBaseUrl());
	// this.takeScreenshot(); // Auto Test 1
	// this.takeScreenshot("Test Case 01"); // Test Case 01
	// this.takeScreenshot(); // Auto Test 2
	// this.takeScreenshot(); // Auto Test 3
	// this.testingName = "Adactin";
	// this.takeScreenshot("Adactin Test"); // Adactin Test
	// this.takeScreenshot();// Adactin Test 4
	// AutoBasics.takeScreenshot("screenshots/", "Adactin Test 5", getDriver(),
	// getLog());
	// }
	@Override
	@Test()
	public void testAdactin() throws Exception {
	}
}
