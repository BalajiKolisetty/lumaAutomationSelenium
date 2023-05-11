package com.luma.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop; 
	
	public TestBase(){
		try{
			prop = new Properties();
			FileInputStream input = new FileInputStream("C:\\Users\\Balaji\\eclipse-workspace\\LumaAutomationTest\\src\\main\\java\\com\\luma\\qa\\config\\config.properties");	
			prop.load(input);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static  void initialization() {
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.msedge.driver", "C:\\Users\\Balaji\\Downloads\\msedgedriver_arm64\\msedgedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
}
