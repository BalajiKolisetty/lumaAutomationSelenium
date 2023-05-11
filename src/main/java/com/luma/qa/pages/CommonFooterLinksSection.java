package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.qa.base.TestBase;

public class CommonFooterLinksSection extends TestBase{

	public CommonFooterLinksSection() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(., 'Selenium Video Courses')]")
	WebElement seleniumVideoCoursesLink;
	
	@FindBy(xpath="//a[contains(., 'Search Terms')]")
	WebElement searchTermsLink;
	
	@FindBy(xpath="//a[contains(., 'Privacy and Cookie Policy')]")
	WebElement privacyPolicyLink;
	
	@FindBy(xpath="//a[@class='action advanced'][contains(., 'Advanced Search')]")
	WebElement advancedSearchLink;
	
	@FindBy(xpath="//a[contains(., 'Orders and Returns')]")
	WebElement ordersAndReturnsLink;
	
	@FindBy(xpath="//a[contains(., 'Contact Us')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement emailFieldForNewsLetterUpdates;
	
	@FindBy(xpath="//button[contains(., 'Subscribe')]")
	WebElement subscribeButton;
}
