package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;

public class HomePageTest extends TestBase{

	CommonHeaderLinksSection commonmHeaderLinksSection;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonmHeaderLinksSection = new CommonHeaderLinksSection();
		commonmHeaderLinksSection.loginPageLand();
		loginPage = new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	
	@Test
	public void welcomeMessageTest() {
		homePage.welcomeMessageIsDisplayed();
	}
	
	@Test
	public void miniCartProductsPresentTest() {
		homePage.miniCartValidation();
	}
	
	@Test
	public void productDeleteFromMinicartTest() {
		homePage.productDeleteFromMinicart();
	}
	
	@Test
	public void productUnDeleteFromMinicartTest() {
		homePage.productUntDeleteFromMinicart();
	}
	
	@Test
	public void cartPageLandTest() {
		homePage.cartPageLand();
	}
	
	@Test
	public void quantityUpdateFromMiniCartTest() {
		homePage.updateFromMiniCart("11");
	}
	
	@Test
	public void myAccountPageLand() {
		homePage.myAccountPageLand();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
