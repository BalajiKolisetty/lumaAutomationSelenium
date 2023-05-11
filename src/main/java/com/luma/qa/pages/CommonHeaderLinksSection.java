package com.luma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.luma.qa.base.TestBase;

public class CommonHeaderLinksSection extends TestBase {
	
	public CommonHeaderLinksSection() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(., 'Sign In')]")
	WebElement signInlink;
	
	@FindBy(xpath="//a[contains(., 'Create an Account')]")
	WebElement createNewAccountLink;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement productSearchField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement productSearchButton;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement miniCartIcon;
	
	@FindBy(xpath="//span[contains(., 'Women')]")
	WebElement womenProductsDropdown;
	
	@FindBy(xpath="//span[contains(., 'Men')]")
	WebElement menProductsDropdown;
	
	@FindBy(xpath="//span[contains(., 'Gear')]")
	WebElement gearProductsFropdown;
	
	@FindBy(xpath="//span[contains(., 'Sale')]")
	WebElement salePageLink;
	
	public LoginPage loginPageLand() {
		signInlink.click();
		return new LoginPage();
	}
}
