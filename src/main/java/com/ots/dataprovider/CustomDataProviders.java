package com.ots.dataprovider;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class CustomDataProviders 
{

	@DataProvider(name="loginTestData")
	public static Object[][] generateTestDataFromExcel()
	{
		Reporter.log("Preparing Data From Excel", true);
		
		Object [][]arr= ExcelReader.getDataFromExcel("LoginCredentials");
		
		Reporter.log("Test Data Prepared", true);
		
		return arr;
	}
	
}
