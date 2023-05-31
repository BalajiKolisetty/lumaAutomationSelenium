package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.AddNewAddressPage;
import com.luma.qa.pages.AddressBookPage;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;
import com.luma.qa.pages.MyAccountPage;

public class AddNewAddressTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;
	AddressBookPage addressBookPage;
	AddNewAddressPage addNewAddressPage;
	
	public AddNewAddressTest() {
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
		myAccountPage.addressPageLand();
		addressBookPage = new AddressBookPage();
		addressBookPage.addNewAddressPageLand();
		addNewAddressPage = new AddNewAddressPage();
	}
	
	@Test
	public void pageHeadingTest() {
		addNewAddressPage.pageHeadingIsDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
