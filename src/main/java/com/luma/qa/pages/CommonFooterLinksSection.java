package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.qa.base.TestBase;

public class CommonFooterLinksSection extends TestBase{

	public CommonFooterLinksSection() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(., 'Write for us')]")
	WebElement writeForUsLink;
	
	@FindBy(xpath="//a[contains(., 'Search Terms')]")
	WebElement searchTermsLink;
	
	@FindBy(xpath="//a[contains(., 'Privacy and Cookie Policy')]")
	WebElement privacyPolicyLink;
	
	@FindBy(xpath="/html/body/div[1]/footer/div/ul/li[3]/a")
	WebElement advancedSearchLink;
	
	@FindBy(xpath="//a[contains(., 'Orders and Returns')]")
	WebElement ordersAndReturnsLink;
	
	@FindBy(xpath="//a[contains(., 'Contact Us')]")
	WebElement contactUsLink;
	
	@FindBy(xpath="//input[@id='newsletter']")
	WebElement emailFieldForNewsLetterUpdates;
	
	@FindBy(xpath="//button[contains(., 'Subscribe')]")
	WebElement subscribeButton;
	
	public WriteForUsPage writeForUsPageLand() {
		writeForUsLink.click();
		return new WriteForUsPage();
	}
	
	public SearchTermsPage searchTermsPageLand() {
		searchTermsLink.click();
		return new SearchTermsPage();
	}
	
	public PrivacyAndPolicyPage privacyPolicyPageLand() {
		privacyPolicyLink.click();
		return new PrivacyAndPolicyPage();
	}
	
	public AdvancedSearchPage advancedSearchPageLand() {
		advancedSearchLink.click();
		return new AdvancedSearchPage();
	}
	
	public OrdersAndReturnsPage ordersAndReturnsPageLand() {
		ordersAndReturnsLink.click();
		return new OrdersAndReturnsPage();
	}
	
	public ContactUsPage contactUsPageLand() {
		contactUsLink.click();
		return new ContactUsPage();
	}
}
