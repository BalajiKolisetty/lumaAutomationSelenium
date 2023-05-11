package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.qa.base.TestBase;

public class RegistrationPage extends TestBase {
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastNameField;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement newsLetterSignupCheckbox;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement emailIdField;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement confirmPasswordField;
	
	@FindBy(xpath="//button[@type='submit'][contains(., 'Create an Account')]")
	WebElement createAccountButton;
}
