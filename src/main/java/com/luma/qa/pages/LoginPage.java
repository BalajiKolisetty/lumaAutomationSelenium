package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailIdField;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement passwordField;
	
	@FindBy(xpath="//button[@id='send2']")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot Your Passowrd?")
	WebElement passwordResetLink;
	
	@FindBy(xpath="//div[@id='email-error']")
	WebElement emailFieldError;
	
	@FindBy(xpath="//div[@id='pass-error']")
	WebElement passwordFieldError;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	WebElement invalidCredentialsOrSomeError;
	
	public void login(String email, String password) {
		try {			
			emailIdField.sendKeys(email);
			passwordField.sendKeys(password);
			loginButton.click();
		}
		
		catch (Exception e) {			
			if (emailIdField.getAttribute("value").isEmpty() && passwordField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(emailFieldError.isDisplayed());
				Assert.assertTrue(passwordFieldError.isDisplayed());
			}
			
			else if (emailIdField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(emailFieldError.isDisplayed());
			}
			
			else if (passwordField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(passwordFieldError.isDisplayed());
			}
			
			else {
				Assert.assertTrue(invalidCredentialsOrSomeError.isDisplayed());
			}
		}	
	}
}
