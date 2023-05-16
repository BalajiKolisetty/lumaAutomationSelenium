package com.luma.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.SalePage;

public class SalePageTest extends TestBase{
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	SalePage salePage;
	
	public SalePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.salePageLand();
		salePage = new SalePage();
		
	}
	
	@Test
	public void pageTitleTest() {
		salePage.pageHeadingIsDisplayed();
	}

}
