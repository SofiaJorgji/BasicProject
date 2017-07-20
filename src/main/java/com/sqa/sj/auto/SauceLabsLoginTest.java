package com.sqa.sj.auto;

import java.net.*;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.*;

import com.sqa.sj.auto.enums.*;
import com.sqa.sj.auto.exceptions.*;
import com.sqa.sj.helpers.*;

public abstract class SauceLabsLoginTest extends BasicTest {

	private String accessKey;

	private Browser browser;

	private String platform;

	private String user;

	private String version;

	public SauceLabsLoginTest(String baseUrl)
			throws BrowserNotSupportedBySauceLabsException {
		super(baseUrl);
	}

	public Object[][] config() {
		return new Object[][] { new Object[] { Browser.IE, "11", "Windows 8.1" },
				new Object[] { Browser.CHROME, "41", "Windows XP" },
				new Object[] { Browser.SAFARI, "7", "OS X 10.9" },
				new Object[] { Browser.FIREFOX, "35", "Windows 7" },
				new Object[] { Browser.CHROME, "59.0", "OS X 10.9" },
				new Object[] { Browser.IE, "11", "Windows 10" },
				new Object[] { Browser.FIREFOX, "35", "Windows 10" },
				new Object[] { Browser.FIREFOX, "45", "Windows 10" },
				new Object[] { Browser.SAFARI, "7", "OS X 10.11.6" } };
	}

	public Object[][] cred() {
		return new Object[][] {
				new Object[] { getProp("sl-username"), getProp("sl-accesskey") } };
	}

	@DataProvider
	public Object[][] dataProvider() {
		Object[][] totalData = DataHelper.joinData(cred(), config(), dp());
		System.out.println(DataHelper.displayData(totalData));
		return totalData;
	}

	abstract public Object[][] dp();

	public String getAccessKey() {
		return this.accessKey;
	}

	public Browser getBrowser() {
		return this.browser;
	}

	public String getPlatform() {
		return this.platform;
	}

	public String getTestName() {
		return this.getClass().getSimpleName() + ":" + getPlatform();
	}

	public String getUser() {
		return this.user;
	}

	public String getVersion() {
		return this.version;
	}

	/**
	 * @param username
	 * @param password
	 */
	// public void login(String username, String password) {
	// // TODO Auto-generated method stub
	// }
	public void preTest(String username, String accessKey, Browser browser,
			String version, String platform)
			throws BrowserNotSupportedBySauceLabsException {
		this.user = username;
		this.accessKey = accessKey;
		this.browser = browser;
		this.version = version;
		this.platform = platform;
		this.setDriver(setupSpecDriver());
		getDriver().get(getBaseUrl());
	}

	@Override
	@BeforeMethod(groups = "chrome")
	public void setUpChrome() {
	}

	@Override
	@BeforeMethod(groups = "firefox")
	public void setUpFirefox() {
	}

	// @Override
	// @BeforeMethod(groups = "ie")
	// public void setUpIE() {
	// }
	@Override
	@BeforeMethod(groups = "safari")
	public void setUpSafari() {
	}

	public WebDriver setupSpecDriver() throws BrowserNotSupportedBySauceLabsException {
		WebDriver driver = null;
		DesiredCapabilities caps = null;
		URL url = null;
		try {
			url = new URL("http://" + getUser() + ":" + getAccessKey()
					+ "@ondemand.saucelabs.com:80/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println("Can connect to Sauce Labs URL: {" + "http://" + getUser()
					+ ":" + getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub)");
		}
		switch (this.browser) {
		case CHROME:
			caps = DesiredCapabilities.chrome();
			break;
		case FIREFOX:
			caps = DesiredCapabilities.firefox();
			break;
		case IE:
			caps = DesiredCapabilities.internetExplorer();
			break;
		case SAFARI:
			caps = DesiredCapabilities.safari();
			break;
		default:
			throw new BrowserNotSupportedBySauceLabsException();
		}
		caps.setCapability("platform", this.platform);
		caps.setCapability("version", this.version);
		caps.setCapability("passed", true);
		String testName = getClass().getSimpleName() + " within the browser "
				+ this.browser.toString().toLowerCase() + ", running on OS-"
				+ this.platform;
		caps.setCapability("name", testName);
		driver = new RemoteWebDriver(url, caps);
		return driver;
	}

	@Override
	@BeforeMethod()
	public void setupTest() {
		// Goto Base URL
		// getDriver().get(getBaseUrl());
	}
}
