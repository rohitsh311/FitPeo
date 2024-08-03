package com.fitpeo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fitpeo.base.baseClass;

public class navigateToHomepage extends baseClass {

	@BeforeMethod
	public void setup() {
		launchWebpage();}
	
	@Test
	public void homePage_validation() {
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, "https://fitpeo.com/");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
