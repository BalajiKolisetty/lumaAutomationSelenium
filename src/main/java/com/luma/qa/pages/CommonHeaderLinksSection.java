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
	
	@FindBy(xpath="//*[@id=\"search_mini_form\"]/div[2]/button")
	WebElement productSearchButton;
	
	@FindBy(xpath="//a[@class='action showcart']")
	WebElement miniCartIcon;
	
	@FindBy(xpath="//span[@class='counter qty']")
	WebElement cartWhenQuantityIsPresent;
	
	@FindBy(xpath="//strong[contains(., 'You have no items in your shopping cart.')]")
	WebElement noProductsInCartMessage;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement checkoutButtonDisplayInMiniCart;
	
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
	
	public RegistrationPage registrationPageLand() {
		createNewAccountLink.click();
		return new RegistrationPage();
	}
	
	public void miniCartIconBasicValidation() {
		String stringQuantityInCart = cartWhenQuantityIsPresent.getText();
		
		try {
			int numberQuantityInCart = Integer.parseInt(stringQuantityInCart); 
			if (numberQuantityInCart > 0) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				miniCartIcon.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='top-cart-btn-checkout']")));
				Assert.assertTrue(checkoutButtonDisplayInMiniCart.isDisplayed());
			}
		}
		
		catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			miniCartIcon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(., 'You have no items in your shopping cart.')]")));
			Assert.assertTrue(noProductsInCartMessage.isDisplayed());
		}
	}
	
	public void productSearchButtonIsDisabled() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		if (productSearchField.getAttribute("value").isEmpty()) {
			Assert.assertFalse(productSearchButton.isEnabled());
		}
	}
	
	public void productSearchButtonIsEnabled() {
		productSearchButtonIsDisabled();
		productSearchField.sendKeys("shirt");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button"))).isDisplayed();
		Assert.assertTrue(productSearchButton.isDisplayed());
	}
}

