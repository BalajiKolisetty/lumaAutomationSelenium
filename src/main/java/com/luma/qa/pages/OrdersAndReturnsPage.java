package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class OrdersAndReturnsPage extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	
	public OrdersAndReturnsPage() {
		PageFactory.initElements(driver, this);
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//span[contains(., 'Orders and Returns')]")
	WebElement ordersAndReturnsPageHeading;

	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(ordersAndReturnsPageHeading.isDisplayed());
	}
	
	public boolean ordersAndReturnsLinkIsDisabled() {
		try {
			return commonFooterLinksSection.ordersAndReturnsLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}
}
