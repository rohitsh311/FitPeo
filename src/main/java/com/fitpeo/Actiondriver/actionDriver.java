package com.fitpeo.Actiondriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fitpeo.base.baseClass;


	public class actionDriver extends baseClass {

		public static void implicitWait(WebDriver driver, int seconds) {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		}

		public static void pageLoadTimeOut(WebDriver driver, int seconds) {
			driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
		}

		public  void explicitWait(WebDriver driver, WebElement element, Duration seconds) {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public  boolean isdiplayed(WebElement ele) {
			boolean flag = false;
			try {
				ele.isDisplayed();
				flag = true;
			} finally {
				if (flag) {
					System.out.println(ele.getText() + " found and is displayed");
				} else {
					System.out.println(ele.getText() + " is not located");
				}
			}
			return flag;
		}

		public  boolean isenabled(WebElement ele) {
			boolean flag = false;
			try {
				ele.isEnabled();
				flag = true;
			} finally {
				if (flag) {
					System.out.println(ele.getText() + " is enabled");
				} else {
					System.out.println(ele.getText() + " is disabled");
				}
			}
			return false;
		}

		public void navigation() {

			//driver.navigate().to("https://bookcart.azurewebsites.net/");
			driver.navigate().back();

		}

		public void movetowebelement(WebDriver driver, WebElement ele) {

			Actions a = new Actions(driver);
			a.moveToElement(ele).click().perform();

		}

}

