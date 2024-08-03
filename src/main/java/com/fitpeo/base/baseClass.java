package com.fitpeo.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.fitpeo.Actiondriver.actionDriver;


public class baseClass {

		public static Properties prop;

		public static WebDriver driver;

		

		// loadConfig method is to load the configuration
		@BeforeSuite
		public void loadConfig() {

			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						System.getProperty("user.dir") + "\\Configuration\\config.properties");
				prop.load(ip);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void launchWebpage() {
			// String browserName = prop.getProperty("browser");
			String browserName = prop.getProperty("browser");
			if (browserName.equalsIgnoreCase("Chrome")) {

				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("FireFox")) {

				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {

				driver = new InternetExplorerDriver();
			}
			driver.get(prop.getProperty("url"));
			// Maximize the screen
			driver.manage().window().maximize();
			// Delete all the cookies
			driver.manage().deleteAllCookies();
			// Implicit TimeOuts

			actionDriver.implicitWait(driver, 20);
			actionDriver.pageLoadTimeOut(driver, 30);
		}

		@AfterSuite
		public void afterSuite() {

		}

	}


