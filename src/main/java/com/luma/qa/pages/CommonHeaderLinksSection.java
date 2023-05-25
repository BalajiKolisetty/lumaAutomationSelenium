package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	@FindBy(xpath="//span[@class='counter-number']")
	WebElement cartWhenQuantityIsPresent;
	
	@FindBy(xpath="//strong[contains(., 'You have no items in your shopping cart.')]")
	WebElement noProductsInCartMessage;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']")
	WebElement checkoutButtonDisplayInMiniCart;
	
	@FindBy(xpath="//a[contains(., 'What')]")
	WebElement whatsNewPageLink;
	
	@FindBy(xpath="//span[contains(., 'Women')]")
	WebElement womenProductsDropdown;
	
	@FindBy(xpath="//span[contains(., 'Men')]")
	WebElement menProductsDropdown;
	
	@FindBy(xpath="//span[contains(., 'Gear')]")
	WebElement gearProductsDropdown;
	
	@FindBy(xpath="//a[contains(., 'Training')]")
	WebElement trainingDropdown;
	
	@FindBy(xpath="//span[contains(., 'Sale')]")
	WebElement salePageLink;
	
	@FindBy(xpath="//a[@id='ui-id-9']")
	WebElement womenTopsOption;
	
	@FindBy(xpath="//a[@id='ui-id-17']")
	WebElement menTopsOption;
	
	@FindBy(xpath="//a[contains(., 'Bags')]")
	WebElement bagsOption;
	
	@FindBy(xpath="//a[contains(., 'Video Download')]")
	WebElement videoDownloadOption;
	
	public LoginPage loginPageLand() {
		signInlink.click();
		return new LoginPage();
	}
	
	public RegistrationPage registrationPageLand() {
		createNewAccountLink.click();
		return new RegistrationPage();
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
	
	public WhatsNewPage whatsNewPageLand() {
		whatsNewPageLink.click();
		return new WhatsNewPage();
	}
	
	public void womenProductsDropdownHover() {
		Actions womenDropdownHover = new Actions(driver);
		womenDropdownHover.moveToElement(womenProductsDropdown).perform();
//		Assert.assertTrue(womenTopsOption.isDisplayed());
	}
	
	public void menProductsDropdownHover() {
		Actions menDropdownHover = new Actions(driver);
		menDropdownHover.moveToElement(menProductsDropdown).perform();
		menTopsOption.click();
//		Assert.assertTrue(menTopsOption.isDisplayed());
	}
	
	public void gearProductsDropdownHover() {
		Actions gearDropdownHover = new Actions(driver);
		gearDropdownHover.moveToElement(gearProductsDropdown).perform();
		Assert.assertTrue(bagsOption.isDisplayed());
	}
	
	public void trainingProductsDropdownHover() {
		Actions trainingDropdownHover = new Actions(driver);
		trainingDropdownHover.moveToElement(trainingDropdown).perform();
		Assert.assertTrue(videoDownloadOption.isDisplayed());
	}
	
	public SalePage salePageLand() {
		salePageLink.click();
		return new SalePage();
	}
}

