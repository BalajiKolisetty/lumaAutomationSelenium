package com.luma.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;

public class LoginPageTest extends TestBase{

	CommonHeaderLinksSection commonHeaderLinksSection;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
	}
	
	@Test
	public void loginPageLandTest() {
		commonHeaderLinksSection.loginPageLand();
	}
}
