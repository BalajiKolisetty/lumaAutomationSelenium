package com.luma.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonFooterLinksSection;
import com.luma.qa.pages.OrdersAndReturnsPage;

public class OrdersAndReturnsPageTest extends TestBase {
	
	CommonFooterLinksSection commonFooterLinksSection;
	OrdersAndReturnsPage ordersAndReturnsPage;
	
	public OrdersAndReturnsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonFooterLinksSection = new CommonFooterLinksSection();
		commonFooterLinksSection.ordersAndReturnsPageLand();
		ordersAndReturnsPage = new OrdersAndReturnsPage();
	}
	
	@Test
	public void pageHeadingTest() {
		ordersAndReturnsPage.pageHeadingIsDisplayed();
	}
	
	@Test
	public void ordersAndReturnsLinkDisabledTest() {
		Assert.assertTrue(ordersAndReturnsPage.ordersAndReturnsLinkIsDisabled());
//		System.out.println("it is disabled");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
