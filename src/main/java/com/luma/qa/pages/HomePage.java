package com.luma.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.luma.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(., 'Welcome')]")
	WebElement welcomeMessage;
	
	public void welcomeMessageIsDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(., 'Welcome')]"))).isDisplayed();
	}
}
