package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.AccountInformationPage;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.pages.MyAccountPage;

public class AccountInformationPageTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	AccountInformationPage accountInformationPage;
	
	public AccountInformationPageTest() {
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
		myAccountPage.accountInfoPageLand();
		accountInformationPage = new AccountInformationPage();
	}
	
	@Test
	public void pageHeadingTest() {
		accountInformationPage.pageHeadingIsDisplayed();
	}
	
	@Test
	public void emailChangeSectionDisplayedTest() {
		accountInformationPage.emailChangeSectionIsDisplayed();
	}
	
	@Test
	public void passwordChangeSectionIsDisplayedTest() {
		accountInformationPage.passwordChangeSectionIsDisplayed();
	}
	
	@Test
	public void passwordAndEmailChangeSectionIsDisplayedTest() {
		accountInformationPage.emailAndPasswordSectionIsDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
