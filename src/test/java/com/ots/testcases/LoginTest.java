package com.ots.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ots.base.Base;
import com.ots.dataprovider.CustomDataProviders;
import com.ots.pages.HomePage;
import com.ots.pages.LoginPage;

public class LoginTest extends Base
{
	LoginPage login;
	
	@Test(dataProvider = "loginTestData",dataProviderClass = CustomDataProviders.class)
	public void validLogin(String username,String password)
	{
		login=new LoginPage(driver);
		
		HomePage home=login.loginToApplication(username, password);
		
		Assert.assertTrue(home.isWelcomeMsgVisible(),"login failed");	
	}

	@Test
	public void verifyNewUserLink()
	{
		login=new LoginPage(driver);
		
		Assert.assertTrue(login.isLinkVisible(),"link not present");
	}
	
}
