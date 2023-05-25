package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'My Account')]")
	WebElement myAccountPageHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(myAccountPageHeading.isDisplayed());
	}
	
	
}
