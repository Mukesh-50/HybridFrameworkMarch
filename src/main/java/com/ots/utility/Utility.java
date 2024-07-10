package com.ots.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ots.dataprovider.ConfigReader;

public class Utility 
{

	public static String getTextAndAcceptAlert(WebDriver driver)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		String alt_text=alt.getText();
		
		alt.accept();
		
		return alt_text;
	}
	
	public static void getTextAndAcceptAlert(WebDriver driver,String dataToType)
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		alt.sendKeys(dataToType);
	
	}
	
	public static WebElement getElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(ConfigReader.getProperty("highlightElement").equalsIgnoreCase("true"))
		{
			highLightElement(driver, element);
		}
	
		return element;
	}
	
	public static WebElement getElement(WebDriver driver,By locator,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		if(ConfigReader.getProperty("highlightElement").equalsIgnoreCase("true"))
		{
			highLightElement(driver, element);
		}
	
		return element;
	}
	
	public static WebElement highLightElement(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		waitForSeconds(1);

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
		
		return element;

	}
	
	public static void clickElement(WebDriver driver, WebElement element) {
	
		try 
		{
			element.click();
		} 
		catch (Exception e) 
		{
			System.out.println("WebElement Click Failed - Trying with Actions class click");

			Actions act = new Actions(driver);

			try 
			{
				act.click(element).perform();
			} catch (Exception e1) 
			{
				System.out.println("Actions class click Failed - Trying with JavaScript click");

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", element);

			}
		}

	}
	
	public static void clickElement(WebDriver driver, By locator) {
		
		WebElement element=driver.findElement(locator);
		
		Utility.highLightElement(driver, element);
		
		try 
		{
			element.click();
		} 
		catch (Exception e) 
		{
			System.out.println("WebElement Click Failed - Trying with Actions class click");

			Actions act = new Actions(driver);

			try {
				act.click(driver.findElement(locator)).perform();
			} catch (Exception e1) {
				System.out.println("Actions class click Failed - Trying with JavaScript click");

				JavascriptExecutor js = (JavascriptExecutor) driver;

				js.executeScript("arguments[0].click();", driver.findElement(locator));

			}
		}

	}

	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);

		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted " + e.getMessage());
		}
	}
	

	public static String getDateTime() {
		return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
	}

	public static void captureScreenshot(WebDriver driver, WebElement element) 
	{
		File src = element.getScreenshotAs(OutputType.FILE);

		File dest = new File(
				System.getProperty("user.dir") + "/screenshots/Element_Screenshot_" + getDateTime() + ".png");

		try {
			FileHandler.copy(src, dest);

		} catch (IOException e) {
			System.out.println("Failed To Capture Screenshot" + e.getMessage());
		}
	}

	public static String captureScreenshotAsBase64(WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;

		String src = ts.getScreenshotAs(OutputType.BASE64);
		
		return src;

	}
	
	
	public static void captureScreenshot(WebDriver driver) 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "/screenshots/Screenshot_" + getDateTime() + ".png");

		try {
			FileHandler.copy(src, dest);

		} catch (IOException e) {
			System.out.println("Failed To Capture Screenshot" + e.getMessage());
		}
	}

}
