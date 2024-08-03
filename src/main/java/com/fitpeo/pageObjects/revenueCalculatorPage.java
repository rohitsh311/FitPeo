package com.fitpeo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fitpeo.base.baseClass;

public class revenueCalculatorPage extends baseClass {
	
	@FindBy(xpath = "//div[contains(text(),'Revenue Calculator')]")
	public WebElement revenue_calc_link;
	
	public  revenueCalculatorPage() {
		PageFactory.initElements(driver, this);

	}

}
