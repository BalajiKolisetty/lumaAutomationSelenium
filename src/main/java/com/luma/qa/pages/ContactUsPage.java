package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class ContactUsPage extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection = new CommonFooterLinksSection();
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
//		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//span[contains(., 'Contact Us')]")
	WebElement contactUsPageHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(contactUsPageHeading.isDisplayed());
	}
	
	public boolean contactUsLinkIsDisabled() {
		try {			
			return commonFooterLinksSection.contactUsLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}

}
