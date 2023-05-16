package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;
import com.luma.qa.pages.WriteForUsPage;

public class WriteForUsPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	WriteForUsPage writeForUsPage;
	
	public WriteForUsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.writeForUsPageLand();
		writeForUsPage = new WriteForUsPage();
	}
	
	@Test
	public void pageLandTest() {
		writeForUsPage.logoIsDisplayed();
	}
	
	@Test
	public void writeForUsLinkDisabledTest() {
		Assert.assertTrue(writeForUsPage.writeForUsLinkIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
