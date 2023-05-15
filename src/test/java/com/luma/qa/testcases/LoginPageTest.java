package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.HomePage;
import com.luma.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	CommonHeaderLinksSection commonHeaderLinksSection;
	LoginPage loginPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.loginPageLand();
		loginPage = new LoginPage();
	}
	
	@Test
	public void pageTitleTest() {
		String actualPageTitle = driver.getTitle();
		Assert.assertEquals(actualPageTitle, "Customer Login", "Login page titles doesn't match");
	}
	
	@Test
	public void loginTest() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void miniCartTest() {
		commonHeaderLinksSection.miniCartIconBasicValidation();
	}
	
	@Test
	public void productSearchButtonDisabledTest() {
		commonHeaderLinksSection.productSearchButtonIsDisabled();
	}
	
	@Test
	public void productSearchButtonEnabledTest() {
		commonHeaderLinksSection.productSearchButtonIsEnabled();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
