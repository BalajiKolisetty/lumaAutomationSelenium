package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.AdvancedSearchPage;
import com.luma.qa.pages.CommonFooterLinksSection;

public class AdvancedSearchPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	AdvancedSearchPage advancedSearchPage;
	
	public AdvancedSearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.advancedSearchPageLand();
		advancedSearchPage = new AdvancedSearchPage();
	}
	
	@Test
	public void pageHeadingTest() {
		advancedSearchPage.pageHeadingIsDisplayed();
	}
	
	@Test
	public void advancedSearchLinkDisabledTest() {
		Assert.assertTrue(advancedSearchPage.advancedSearchLinkIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
