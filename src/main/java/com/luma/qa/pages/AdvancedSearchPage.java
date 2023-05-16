package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class AdvancedSearchPage extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	
	public AdvancedSearchPage() {
		PageFactory.initElements(driver, this);
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//span[contains(., 'Advanced Search')]")
	WebElement advancedSearchPageHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(advancedSearchPageHeading.isDisplayed());
	}
	
	public boolean advancedSearchLinkIsDisabled() {
		try {			
			return commonFooterLinksSection.advancedSearchLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}
}
