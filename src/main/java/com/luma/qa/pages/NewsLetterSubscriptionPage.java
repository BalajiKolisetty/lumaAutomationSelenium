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

public class NewsLetterSubscriptionPage extends TestBase {
	
	public NewsLetterSubscriptionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='subscription']")
	WebElement newsLetterSubscriptionCheckbox;
	
	@FindBy(xpath="//button[contains(., 'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath="//span[contains(., 'Newsletter Subscription')]")
	WebElement newsLetterPageHeading;
	
	@FindBy(xpath="//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	WebElement subscriptionUpdateBanner;	
	
	public void pageHeadingIsDisplayed() {
		Assert.assertTrue(newsLetterPageHeading.isDisplayed());
	}
	
	public void subscriptionUpdateBannerIsDisplayed() {
		saveButton.click();
		WebDriverWait waitForUpdateBanner = new WebDriverWait(driver, Duration.ofSeconds(15));
		waitForUpdateBanner.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"))).isDisplayed();
//		System.out.println("subscription is updated");
	}
	
	public void subscriptionAddOrRemoveBannerIsDisplayed() {
		if (newsLetterSubscriptionCheckbox.isSelected()) {
			newsLetterSubscriptionCheckbox.click();
			saveButton.click();
			WebDriverWait waitForSubscriptionRemovedBanner = new WebDriverWait(driver, Duration.ofSeconds(15));
			waitForSubscriptionRemovedBanner.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div"))).isDisplayed();
//			System.out.println("subscription removed");
		}
		
		else {
			newsLetterSubscriptionCheckbox.click();
			saveButton.click();
			WebDriverWait waitForSubscriptionApplieddBanner = new WebDriverWait(driver, Duration.ofSeconds(15));
			waitForSubscriptionApplieddBanner.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div"))).isDisplayed();
//			System.out.println("subscription added");
		}
	}
}
