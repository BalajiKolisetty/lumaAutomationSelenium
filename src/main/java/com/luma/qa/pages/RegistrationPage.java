package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
	
	@FindBy(xpath="//span[contains(., 'Create New Customer Account')]")
	WebElement pageHeading;
	
	@FindBy(xpath="//div[@id='firstname-error']")
	WebElement firstNameFieldBlankError;
	
	@FindBy(xpath="//div[@id='lastname-error']")
	WebElement lastNameFieldBlankError;
	
	@FindBy(xpath="//div[@id='email_address-error']")
	WebElement emailAddresseFieldBlankError;
	
	@FindBy(xpath="//div[@id='password-error']")
	WebElement passwordFieldBlankError;
	
	@FindBy(xpath="//div[@id='password-confirmation-error']")
	WebElement confirmPasswordFieldBlankError;
	
	@FindBy(xpath="//div[@id='password-confirmation-error'][contains(., 'Please enter the same value again.')]")
	WebElement passwordsNotmatchError;
	
	@FindBy(xpath="//span[@id='password-strength-meter-label']")
	WebElement passwordStrengthIndicator;
	
	@FindBy(xpath="//div[@class='mage-error']")
	WebElement passwordComplexityError;
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(pageHeading.isDisplayed());
	}
	
	public void registration(String firstName, String lastName, String email, String password, String confirmPassword) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailIdField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		
		try {			
			createAccountButton.click();
			WebDriverWait waitForRegistrationSuccessBanner = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForRegistrationSuccessBanner.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div"))).isDisplayed();
			System.out.println("Registration success..!!");
		}
		
		catch(Exception e) {
			if (firstNameField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(firstNameFieldBlankError.isDisplayed());
//				System.out.println("Firstname is empty");
			}
			
			if (lastNameField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(lastNameFieldBlankError.isDisplayed());
//				System.out.println("Lastname is empty");
			}
			
			if (emailIdField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(emailAddresseFieldBlankError.isDisplayed());
//				System.out.println("Email is empty");
			}
			
			if (passwordField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(passwordFieldBlankError.isDisplayed());
//				System.out.println("Password is empty");
			}
			
			if (confirmPasswordField.getAttribute("value").isEmpty()) {
				Assert.assertTrue(confirmPasswordFieldBlankError.isDisplayed());
//				System.out.println("Confirm password is empty");
			}
			
			if (!passwordField.getAttribute("value").equals(confirmPasswordField.getAttribute("va;ue"))) {
				Assert.assertTrue(passwordsNotmatchError.isDisplayed());
//				System.out.println("Passwords don't match");
			}
			
			if (passwordStrengthIndicator.getText().equals("Weak")) {
				Assert.assertTrue(passwordComplexityError.isDisplayed());
//				System.out.println("Password complexity error");
			}
		}
	}
}
