package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;

public class RegistrationPageTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.registrationPageLand();
	}
	
	@Test
	public void pageTitleTest() {
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, "Create New Customer Account", "Registration page titles doesn't match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
