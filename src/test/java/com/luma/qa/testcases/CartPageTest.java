package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CartPage;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;

public class CartPageTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public CartPageTest() {
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
		homePage.cartPageLand();
		cartPage = new CartPage();
	}

	@Test
	public void cartPageHeadingTest() {
		cartPage.cartPageHeadingDisplay();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
