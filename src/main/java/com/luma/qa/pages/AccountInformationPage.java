package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class AccountInformationPage extends TestBase {
	
	public AccountInformationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'Edit Account Information')]")
	WebElement accountInformationPageHeading;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastNameField;
	
	@FindBy(xpath="//input[@id='change-email']")
	WebElement changeEmailCheckbox;
	
	@FindBy(xpath="//input[@id='change-password']")
	WebElement changePasswordCheckbox;
	
	@FindBy(xpath="//span[contains(., 'Change Email')][@data-title='change-email-password']")
	WebElement changeEmailSectionHeading;
	
	@FindBy(xpath="//span[contains(., 'Change Password')][@data-title='change-email-password']")
	WebElement changePasswordSectionHeading;
	
	@FindBy(xpath="//span[contains(., 'Change Email and Password')][@data-title='change-email-password']")
	WebElement changeEmailAndPasswordSectionHeading;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(accountInformationPageHeading.isDisplayed());
	}
	
	public void emailChangeSectionIsDisplayed() {
		changeEmailCheckbox.click();
		Assert.assertTrue(changeEmailSectionHeading.isDisplayed());
	}
	
	public void passwordChangeSectionIsDisplayed() {
		changePasswordCheckbox.click();
		Assert.assertTrue(changePasswordSectionHeading.isDisplayed());
	}
	
	public void emailAndPasswordSectionIsDisplayed() {
		changeEmailCheckbox.click();
		changePasswordCheckbox.click();
		Assert.assertTrue(changeEmailAndPasswordSectionHeading.isDisplayed());
	}
}
