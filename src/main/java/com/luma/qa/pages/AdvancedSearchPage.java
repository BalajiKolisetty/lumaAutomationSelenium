package com.luma.qa.pages;

import java.time.Duration;

import org.checkerframework.checker.units.qual.min;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	@FindBy(xpath="//input[@name='name']")
	WebElement searchByProductNameField;
	
	@FindBy(xpath="//input[@name='sku']")
	WebElement searchBySKUField;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement searchByDescriptionField;
	
	@FindBy(xpath="//input[@name='short_description']")
	WebElement searchByShortDescriptionField;
	
	@FindBy(xpath="//input[@name='price[from]']")
	WebElement fromPriceField;
	
	@FindBy(xpath="//input[@name='price[to]']")
	WebElement toPriceField;
	
	@FindBy(xpath="//*[@id=\"form-validate\"]/div/div/button")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	WebElement allFieldsAreEmptySearchBanner;
	
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
