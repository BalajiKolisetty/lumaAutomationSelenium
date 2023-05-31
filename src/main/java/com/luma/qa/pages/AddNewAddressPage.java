package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class AddNewAddressPage extends TestBase {
	
	public AddNewAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'Add New Address')]")
	WebElement pageHeading;

	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(pageHeading.isDisplayed());
	}
}
