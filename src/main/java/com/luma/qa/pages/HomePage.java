package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.luma.qa.base.TestBase;

import io.netty.handler.timeout.TimeoutException;

public class HomePage extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	CartPage cartPage;

	public HomePage() {
		PageFactory.initElements(driver, this);
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		cartPage = new CartPage();
	}
	
	@FindBy(xpath="//span[contains(., 'Welcome')]")
	WebElement welcomeMessage;
	
	@FindBy(xpath="//a[@title='Remove item']")
	WebElement productDeleteIcon;
	
	@FindBy(xpath="//span[contains(., 'OK')]")
	WebElement productDeleteOkButton;
	
	@FindBy(xpath="//span[contains(., 'Cancel')]")
	WebElement productDeleteCancelButton;
	
	@FindBy(xpath="//span[contains(., 'View and Edit Cart')]")
	WebElement cartPageLandLink;
	
	@FindBy(xpath="//input[@id='cart-item-170216-qty']")
	WebElement quantityEnterField;
	
	@FindBy(xpath="//span[contains(., 'Update')]")
	WebElement quantityUpdateFromMinicartButton;
	
	@FindBy(xpath="//span[contains(., 'Change')]")
	WebElement profileDropdown;
	
	@FindBy(xpath="//a[contains(., 'My Account')]")
	WebElement myAccountPageLink;
	
	public void welcomeMessageIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Welcome')]"))).isDisplayed();
	}
	
	public void miniCartValidation() {
		welcomeMessageIsDisplayed();
		String stringQuantityInCart = commonHeaderLinksSection.cartWhenQuantityIsPresent.getText();
		
		try {
			commonHeaderLinksSection.miniCartIcon.click();
			int numberQuantityInCart = Integer.parseInt(stringQuantityInCart);
			if (numberQuantityInCart > 0) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='top-cart-btn-checkout']"))).isDisplayed();
//				System.out.println("Items present in cart");
			}
		}
		
		catch (NumberFormatException e) {
			Assert.assertTrue(commonHeaderLinksSection.noProductsInCartMessage.isDisplayed());
//			System.out.println("no items present in cart");
		}
	}
	
	public void productDeleteFromMinicart() {
		welcomeMessageIsDisplayed();
		try {			
			commonHeaderLinksSection.miniCartIcon.click();
			WebDriverWait waitForDeleteIcon = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForDeleteIcon.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Remove item']")));
			productDeleteIcon.click();
			WebDriverWait waitForOkButton = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForOkButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'OK')]")));
			productDeleteOkButton.click();
			WebDriverWait waitForNoProductsMessage = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForNoProductsMessage.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(., 'You have no items in your shopping cart.')]"))).isDisplayed();
//			System.out.println("product deletion from mini cart successful");
		}
		
		catch (NoSuchElementException e) {
			Assert.assertTrue(commonHeaderLinksSection.noProductsInCartMessage.isDisplayed());
//			System.out.println("no items in cart");
		}
	}
	
	public void productUntDeleteFromMinicart() {
		welcomeMessageIsDisplayed();
		try {
			commonHeaderLinksSection.miniCartIcon.click();
			WebDriverWait waitForDeleteIcon = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForDeleteIcon.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Remove item']")));
			productDeleteIcon.click();
			WebDriverWait waitForCancelButton = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForCancelButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'OK')]")));
			productDeleteCancelButton.click();
			WebDriverWait waitForCheckoutButtonDisplay = new WebDriverWait(driver, Duration.ofSeconds(5));
			waitForCheckoutButtonDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='top-cart-btn-checkout']"))).isDisplayed();
//			System.out.println("no items deleted from mini cart");
		}
		
		catch (Exception e) {
			Assert.assertTrue(commonHeaderLinksSection.noProductsInCartMessage.isDisplayed());
//			System.out.println("no items in cart");
		}
	}
	
	public CartPage cartPageLand() {
		welcomeMessageIsDisplayed();
		commonHeaderLinksSection.miniCartIcon.click();
		String stringQuantityInCart = commonHeaderLinksSection.cartWhenQuantityIsPresent.getText();
		try {			
			int numberQuantityInCart = Integer.parseInt(stringQuantityInCart);
			if (numberQuantityInCart > 0) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='top-cart-btn-checkout']"))).isDisplayed();
				cartPageLandLink.click();
//				System.out.println("cart pageland successful");
			}
		}
		
		catch (NumberFormatException e) {			
//			System.out.println("no items in cart");
		}
		
		return new CartPage();
	}
	
	public void updateFromMiniCart(String newQuantity) {
		welcomeMessageIsDisplayed();
		commonHeaderLinksSection.miniCartIcon.click();
		
		String stringQuantityInMiniCart = quantityEnterField.getText();
		int integerQuantityInMiniCart = Integer.parseInt(stringQuantityInMiniCart);
		
		if (Integer.parseInt(newQuantity) == integerQuantityInMiniCart) {
			quantityEnterField.sendKeys(String.valueOf(newQuantity));
			Assert.assertFalse(quantityUpdateFromMinicartButton.isDisplayed());
		}
		
		else if ((Integer.parseInt(newQuantity) <= integerQuantityInMiniCart) || (Integer.parseInt(newQuantity) >= integerQuantityInMiniCart)) {
			quantityEnterField.sendKeys(String.valueOf(newQuantity));
			WebDriverWait waitForUpdateButton = new WebDriverWait(driver, Duration.ofSeconds(10));
			waitForUpdateButton.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Update')]")));
			quantityUpdateFromMinicartButton.click();
//			Assert.assertTrue(quantityUpdateFromMinicartButton.isDisplayed());
		}
	}
	
	public MyAccountPage myAccountPageLand() {
		welcomeMessageIsDisplayed();
		profileDropdown.click();
		myAccountPageLink.click();
		return new MyAccountPage();
	}
}

