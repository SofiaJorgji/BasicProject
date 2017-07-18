package com.sqa.sj.auto;

import java.util.concurrent.*;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

public class BasicTest extends Core {

	public BasicTest(String baseUrl) {
		super(baseUrl);
	}

	@BeforeClass(enabled = true, groups = "chrome")
	public void setUpChrome() {
		System.out.println("Setup Chrome");
		// Set system property to use Chrome driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		// Setup the driver to use Chrome
		setDriver(new ChromeDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
	}

	@BeforeClass(enabled = false, groups = "firefox")
	public void setUpFirefox() {
		System.out.println("Setup Firefox");
		// Setup the driver to use IE
		setDriver(new FirefoxDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
	}

	// @BeforeClass(enabled = true, groups = "ie")
	// public void setUpIE() {
	// System.out.println("Setup IE");
	// // Set capability of IE driver to Ignore all zones browser protected
	// // mode settings.
	// DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	// caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
	// true);
	// // Set system property to use IE driver
	// System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
	// // Initialize InternetExplorerDriver Instance using new capability.
	// setDriver(new InternetExplorerDriver(caps));
	// // Set an implicit wait of up to 30 seconds
	// getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// // Maximize the window
	// getDriver().manage().window().maximize();
	// }
	@BeforeClass(enabled = false, groups = "safari")
	public void setUpSafari() {
		System.out.println("Setup Safari");
		// Set system property to use IE driver
		setDriver(new SafariDriver());
		// Set an implicit wait of up to 30 seconds
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the window
		getDriver().manage().window().maximize();
		// Goto Base URL
	}

	@BeforeMethod()
	public void setupTest() {
		// Goto Base URL
		getDriver().get(getBaseUrl());
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		// quit closes all instances of the browser.
		getDriver().quit();
		// close method would close current instance only.
		// ex: driver.close();
	}
}