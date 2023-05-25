package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class CartPage extends TestBase {
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'Shopping Cart')]")
	WebElement cartPageHeading;
	
	@FindBy(xpath="//a[contains(., 'Check Out with Multiple Addresses')]")
	WebElement multipleAddressCheckoutLink;
	
	public void cartPageHeadingDisplay() {
		Assert.assertTrue(cartPageHeading.isDisplayed());
	}

}
