package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'My Account')]")
	WebElement myAccountPageHeading;
	
	@FindBy(xpath="//a[@href='https://magento.softwaretestingboard.com/newsletter/manage/']")
	WebElement newsLetterSubscriptionEditLink;
	
	@FindBy(xpath="//a[contains(., 'Newsletter Subscriptions')]")
	WebElement newsLetterPageLink;
	
	@FindBy(xpath="//a[contains(., 'Account Information')]")
	WebElement accountInformationPageLink;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(myAccountPageHeading.isDisplayed());
	}
	
	public NewsLetterSubscriptionPage newsLetterPageLand() {
		newsLetterSubscriptionEditLink.click();
		return new NewsLetterSubscriptionPage();
	}
	
	public AccountInformationPage accountInfoPageLand() {
		accountInformationPageLink.click();
		return new AccountInformationPage();
	}
}
