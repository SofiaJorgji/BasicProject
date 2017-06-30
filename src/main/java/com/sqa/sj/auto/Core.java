package com.sqa.sj.auto;

import org.apache.log4j.*;
import org.openqa.selenium.*;

/**
 * @author Jorgji, Sofia
 * @version 1.0
 */
public class Core {

	private Logger log = Logger.getLogger(this.getClass());

	private String baseUrl;

	private WebDriver driver;

	public Core(String baseUrl, WebDriver driver) {
		super();
		this.baseUrl = baseUrl;
		this.driver = driver;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public Logger getLog() {
		return this.log;
	}

	public boolean isPresent(By by) {
		return AutoBasics.isElementPresent(getDriver(), by, getLog());
	}
}
