package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class AddressBookPage extends TestBase {
	
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'Address Book')]")
	WebElement pageHeading;
	
	@FindBy(xpath="")
	WebElement addNewAddressPageButton;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(pageHeading.isDisplayed());
	}
}
