package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class WhatsNewPage extends TestBase{
	
	public WhatsNewPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@id='page-title-heading']")
	WebElement pageHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(pageHeading.isDisplayed());
	}
	

}
