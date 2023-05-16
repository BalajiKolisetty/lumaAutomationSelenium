package com.luma.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;

public class CommonHeaderLinksTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	public CommonHeaderLinksTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		commonHeaderLinksSection = new CommonHeaderLinksSection(); 
	}
	
	
	@Test
	public void miniCartTest() {
		commonHeaderLinksSection.miniCartIconBasicValidation();
	}
	
	@Test
	public void productSearchButtonDisabledTest() {
		commonHeaderLinksSection.productSearchButtonIsDisabled();
	}
	
	@Test
	public void productSearchButtonEnabledTest() {
		commonHeaderLinksSection.productSearchButtonIsEnabled();
	}
	
	@Test
	public void whatsNewPageLand() {
		commonHeaderLinksSection.whatsNewPageLand();
	}
	
	@Test
	public void womenDropdownHoverTest() {
		commonHeaderLinksSection.womenProductsDropdownHover();
	}
	
	@Test
	public void menDropdownHoverTest() {
		commonHeaderLinksSection.menProductsDropdownHover();
	}
	
	@Test
	public void gearDropdownHoverTest() {
		commonHeaderLinksSection.gearProductsDropdownHover();
	}
	
	@Test
	public void trainingDropdownHoverTest() {
		commonHeaderLinksSection.trainingProductsDropdownHover();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
