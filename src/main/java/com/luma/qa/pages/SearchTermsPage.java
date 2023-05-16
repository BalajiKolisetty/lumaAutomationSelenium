package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class SearchTermsPage extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	
	public SearchTermsPage() {
		PageFactory.initElements(driver, this);
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//span[contains(., 'Popular Search Terms')]")
	WebElement searchTermsPageheading;
	
	public void headingIsDisplayed() {
		Assert.assertTrue(searchTermsPageheading.isDisplayed());
	}
	
	public boolean searchTermsLinksIsDisabled() {
		try {			
			return commonFooterLinksSection.searchTermsLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}
}

