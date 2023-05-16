package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class PrivacyAndPolicyPage extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	public PrivacyAndPolicyPage() {
		PageFactory.initElements(driver, this);
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//span[contains(., 'Privacy Policy')]")
	WebElement privacyPolicyPageHeading;
	
	public void headingIsDisplayed() {
		Assert.assertTrue(privacyPolicyPageHeading.isDisplayed());
	}
	
	public boolean privacyPolicyLinkIsDisabled() {
		try {			
			return commonFooterLinksSection.privacyPolicyLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}

}
