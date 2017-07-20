package com.sqa.sj;

import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import com.sqa.sj.helpers.*;

public class SampleSauceTest {

	public static final String USERNAME =
			AutoBasics.getProp("sl-username", "src/main/resources/", "config.properties", null);

	public static final String ACCESS_KEY =
			AutoBasics.getProp("sl-accesskey", "src/main/resources/", "config.properties", null);

	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Test
	public void desireCapabTest() throws MalformedURLException {
		// DesiredCapabilities caps = DesiredCapabilities.chrome();
		// caps.setCapability("platform", "Windows XP");
		// caps.setCapability("version", "43.0");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "OS X 10.9");
		caps.setCapability("version", "59.0");
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("https://williams-sonoma.com");
		System.out.println("title of page is: " + driver.getTitle());
		driver.quit();
	}
}
