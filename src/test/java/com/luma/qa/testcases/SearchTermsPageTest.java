package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;
import com.luma.qa.pages.SearchTermsPage;

public class SearchTermsPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	SearchTermsPage searchTermsPage;
	
	public SearchTermsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.searchTermsPageLand();
		searchTermsPage = new SearchTermsPage();
	}
	
	@Test
	public void pageHeadingTest() {
		searchTermsPage.headingIsDisplayed();
	}
	
	@Test
	public void searchTermsLinkDisabledTest() {
		Assert.assertTrue(searchTermsPage.searchTermsLinksIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
