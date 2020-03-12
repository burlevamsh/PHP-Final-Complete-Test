package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.ReferingSelectors;
import com.pages.XLSLFile;

import browser_details.WrapperClass;

public class TestCases extends WrapperClass{
	ReferingSelectors referpages;
	
	@BeforeTest
	public void lanchbrowserDetails() {
		lanchBrowser("chrome","https://www.phptravels.net/home");
		referpages=new ReferingSelectors(driver);
	}
	
	@DataProvider(name="td")
	public Object[][] testdata(){
		return XLSLFile.getXLSXFile(".\\TestData\\TestData.xlsx");	
	}
	
	
	@Test(dataProvider="td")
	public void testcase(String userName,String phone,String message) throws InterruptedException, IOException {
		
		referpages.dropdownSelector();
		Thread.sleep(10000);
		referpages.goToOffer();
		Thread.sleep(500);
		referpages.goToSummerVacationPage();
		Thread.sleep(10000);
		referpages.details(userName);
		referpages.phone(phone);
		referpages.message(message);
		referpages.contactClick();
		referpages.alert();
		screenshot(".\\ScreenSchots\\alertmessage.png");
		String expected="Thanks For Contacting";
		Assert.assertEquals(referpages.actual, expected);
		
	}
	
	@AfterTest
	public void closeSession() {
		quit();
	}
	

}
