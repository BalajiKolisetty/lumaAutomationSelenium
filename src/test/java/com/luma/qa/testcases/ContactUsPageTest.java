package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;
import com.luma.qa.pages.ContactUsPage;

public class ContactUsPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	ContactUsPage contactUsPage;
	
	public ContactUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.contactUsPageLand();
		contactUsPage = new ContactUsPage();
	}
	
	@Test
	public void pageHeadingTest() {
		contactUsPage.pageHeadingIsDisplayed();
//		System.out.println("heading is visible");
	}
	
	@Test
	public void contactUsLinkDisabledTest() {
		Assert.assertTrue(contactUsPage.contactUsLinkIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
