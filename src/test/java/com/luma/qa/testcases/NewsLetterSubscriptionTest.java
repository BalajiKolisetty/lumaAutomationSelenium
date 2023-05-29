package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.pages.MyAccountPage;
import com.luma.qa.pages.NewsLetterSubscriptionPage;

public class NewsLetterSubscriptionTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	NewsLetterSubscriptionPage newsLetterSubscriptionPage;
	
	public NewsLetterSubscriptionTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.loginPageLand();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		homePage.myAccountPageLand();
		myAccountPage = new MyAccountPage();
		myAccountPage.newsLetterPageLand();
		newsLetterSubscriptionPage = new NewsLetterSubscriptionPage();
	}
	
	@Test
	public void pageHeadingIsDisplayedTest() {
		newsLetterSubscriptionPage.pageHeadingIsDisplayed();
	}
	
	@Test
	public void updateBannerDisplayTest() {
		newsLetterSubscriptionPage.subscriptionUpdateBannerIsDisplayed();
	}
	
	@Test
	public void subscriptionRemoveBannerTest() {
		newsLetterSubscriptionPage.subscriptionAddOrRemoveBannerIsDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
