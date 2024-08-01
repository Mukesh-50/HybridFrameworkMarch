package com.ots.testcases;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridTest {
	@Test
	public void remoteTest() throws MalformedURLException, InterruptedException {

		FirefoxOptions opt = new FirefoxOptions();

		URL gridURL = new URL("http://13.125.233.42:4444/wd/hub");

		WebDriver driver = new RemoteWebDriver(gridURL, opt);

		driver.get("https://www.selenium.dev/");
		
		System.out.println(driver.getTitle());

		driver.quit();

	}

	@Test
	public void remoteTestOnChrome() throws MalformedURLException, InterruptedException {

		ChromeOptions opt = new ChromeOptions();

		URL gridURL = new URL("http://13.125.233.42:4444/wd/hub");

		WebDriver driver = new RemoteWebDriver(gridURL, opt);

		driver.get("https://www.selenium.dev/");

		System.out.println(driver.getTitle());

		driver.quit();

	}
	
	@Test
	public void remoteTestOnEdge() throws MalformedURLException, InterruptedException {

		EdgeOptions opt = new EdgeOptions();

		URL gridURL = new URL("http://13.125.233.42:4444/wd/hub");

		WebDriver driver = new RemoteWebDriver(gridURL, opt);

		driver.get("https://www.selenium.dev/");

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
