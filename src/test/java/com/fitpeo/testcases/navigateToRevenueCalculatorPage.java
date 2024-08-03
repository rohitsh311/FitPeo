package com.fitpeo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fitpeo.base.baseClass;
import com.fitpeo.pageObjects.homePage;

public class navigateToRevenueCalculatorPage extends baseClass {
	
	
	
	@BeforeMethod
	public void setup() {
		launchWebpage();
		}
	
	@Test
	public void revenue_calc() {
		homePage home= new homePage();
		home.rev_calc_page_navigation();
	}

	//@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
