package com.ots.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
	
	private By cartIcon=By.xpath("//button[normalize-space()='Cart']");
	
	private By manageOption=By.xpath("//span[normalize-space()='Manage']");
	
	private By manageCourses=By.xpath("//a[normalize-space()='Manage Courses']");
	
	public boolean isWelcomeMsgVisible()
	{
		boolean status=driver.findElement(welcomeMsg).isDisplayed();
		
		return status;
	}
	


}
