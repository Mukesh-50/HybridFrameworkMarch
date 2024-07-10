package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ots.utility.Utility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	private By username = By.xpath("//input[contains(@placeholder,'Enter Email')]");

	private By password = By.name("password1");

	private By loginButton = By.xpath("//button[normalize-space()='Sign in']");

	private By createNewUser = By.xpath("//a[normalize-space()='New user? Signup']");

	public boolean isLinkVisible() 
	{
		boolean status = Utility.getElement(driver, createNewUser).isDisplayed();

		return status;
	}

	/*
	 * Sync issues Element is hidden Element is not clickable Scroll JavaScriptClick
	 * 
	 */

	public HomePage loginToApplication(String uname, String pass) 
	{
		Utility.getElement(driver, username).sendKeys(uname);
		
		/*
		WebElement element=Utility.getElement(driver, username);
		
		element.sendKeys(uname);
		*/

		Utility.getElement(driver, password).sendKeys(pass);
		

		Utility.clickElement(driver,Utility.getElement(driver, loginButton));

		HomePage home = new HomePage(driver);

		return home;

	}

}
