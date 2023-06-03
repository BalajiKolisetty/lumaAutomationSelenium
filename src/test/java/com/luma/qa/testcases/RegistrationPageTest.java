package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	RegistrationPage registrationPage;
	
	public RegistrationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.registrationPageLand();
		registrationPage = new RegistrationPage();
	}
	
	@Test
	public void pageHeadingTest() {
		registrationPage.pageHeadingIsDisplayed();
	}
	
	@Test
	public void registrationTest() {
		registrationPage.registration("Balaji", "K", "virat@kohli.com", "Balaji@", "Balaji8@");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
