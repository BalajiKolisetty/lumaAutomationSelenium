package com.luma.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.qa.base.TestBase;
import com.luma.qa.pages.CommonHeaderLinksSection;
import com.luma.qa.pages.WhatsNewPage;

public class WhatsNewPageTest extends TestBase {
	
	CommonHeaderLinksSection commonHeaderLinksSection;
	WhatsNewPage whatsNewPage;
	
	public WhatsNewPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		commonHeaderLinksSection = new CommonHeaderLinksSection();
		commonHeaderLinksSection.whatsNewPageLand();
		whatsNewPage = new WhatsNewPage();
	}
	
	@Test
	public void pageTitleTest() {
		whatsNewPage.pageHeadingIsDisplayed();
	}
}
