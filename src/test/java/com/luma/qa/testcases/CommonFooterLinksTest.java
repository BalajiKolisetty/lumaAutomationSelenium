package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;

public class CommonFooterLinksTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	
	public CommonFooterLinksTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@Test
	public void newsLetterSubscriptionTest() {
		commonFooterLinksSection.newsLetterSubscription(prop.getProperty("username"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
