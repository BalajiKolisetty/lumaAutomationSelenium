package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;
import com.luma.qa.pages.PrivacyAndPolicyPage;

public class PrivacyAndPolicyPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	PrivacyAndPolicyPage privacyAndPolicyPage;
	
	public PrivacyAndPolicyPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.privacyPolicyPageLand();
		privacyAndPolicyPage = new PrivacyAndPolicyPage();
	}
	
	@Test
	public void pageHeadingTest() {
		privacyAndPolicyPage.headingIsDisplayed();
	}
	
	@Test
	public void privacyPolicyLinkDisabledTest() {
		Assert.assertTrue(privacyAndPolicyPage.privacyPolicyLinkIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
