package com.sqa.sj.helpers;

import com.sqa.sj.adactin.*;

public abstract class AbstractLoginTest extends BasicTest {

	/**
	 * @param baseUrl
	 */
	public AbstractLoginTest(String baseUrl) {
		super(baseUrl);
	}

	abstract public void login(String username, String password);

	abstract public void logout();
}
