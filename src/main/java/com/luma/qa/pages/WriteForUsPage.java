package com.luma.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class WriteForUsPage extends TestBase {
	CommonFooterLinksSection commonFooterLinksSection;
	
	public WriteForUsPage() {
		PageFactory.initElements(driver, this);
		commonFooterLinksSection = new CommonFooterLinksSection();
	}
	
	@FindBy(xpath="//*[@id=\"page\"]/header/nav/div[1]/a/img")
	WebElement imageOnWriteForUsPage;
	
	public void logoIsDisplayed() {
		Assert.assertTrue(imageOnWriteForUsPage.isDisplayed());
	}
	
	public boolean writeForUsLinkIsDisabled() {
		try {			
			return commonFooterLinksSection.writeForUsLink.isEnabled();
		}
		
		catch (NoSuchElementException e) {
			return true;
		}
	}

}
