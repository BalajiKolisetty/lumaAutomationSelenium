package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class SalePage extends TestBase {
	
	public SalePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='base'][contains(., 'Sale')]")
	WebElement salePageHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(salePageHeading.isDisplayed());
	}

}
