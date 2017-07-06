package com.sqa.sj.auto;

import org.openqa.selenium.support.*;

import com.sqa.sj.adactin.*;

public class BasicPage extends Core {

	public BasicPage(BasicTest test) {
		super(test);
		PageFactory.initElements(getDriver(), this);
	}
}
