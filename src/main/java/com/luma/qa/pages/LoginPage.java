package com.luma.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.luma.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	

}
