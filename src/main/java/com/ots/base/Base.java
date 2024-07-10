package com.ots.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ots.dataprovider.ConfigReader;
import com.ots.factory.BrowserFactory;

public class Base {

	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("LOG:INFO - Starting Browser - Running Before Method");
		
		driver=BrowserFactory.startBrowser(ConfigReader.getProperty("browserName"), ConfigReader.getProperty("appURLQA")+"/login");
		
		System.out.println("LOG:INFO - Browser and Application up and running");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("LOG:INFO - Closing Browser - Running After Method");
		
		BrowserFactory.closeBrowser(driver);
		
		System.out.println("LOG:INFO - Session Closed");
	}
	
	
}
