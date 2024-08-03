package com.fitpeo.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fitpeo {

	public static void main(String[] args) throws Exception {
		revenue_calculator_test();
	}

	class SliderValueException extends Exception {
		public SliderValueException(String message) {
			super(message);
		}
	}

	class TextBoxValueException extends Exception {
		public TextBoxValueException(String message) {
			super(message);
		}
	}

	class ReimbursementValueException extends Exception {
		public ReimbursementValueException(String message) {
			super(message);
		}
	}

	public static WebDriver driver = new ChromeDriver();
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	static fitpeo f = new fitpeo();

	public static void revenue_calculator_test() throws Exception {
		// Setup WebDriver

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			// Navigate to FitPeo Homepage
			driver.get("https://fitpeo.com");
			driver.manage().window().maximize();

			// Navigate to Revenue Calculator Page
			WebElement revenueCalculatorLink = wait
					.until(ExpectedConditions.elementToBeClickable(By.linkText("Revenue Calculator")));
			revenueCalculatorLink.click();

			// Scroll down to the Slider section
			WebElement sliderSection = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-orientation='horizontal']")));
			js.executeScript("arguments[0].scrollIntoView(true);", sliderSection);

			// Slide unti value of 817 is shown in textbox
			Actions a = new Actions(driver);
			a.dragAndDropBy(sliderSection, 93, 0).perform();

			// Validate the bottom text field is updated to 817
			WebElement textField = driver.findElement(By.id(":r0:"));

			if (!textField.getAttribute("value").equals("817")) {
				System.out.println("Text box value did not update correctly!");
				throw f.new TextBoxValueException("Text box value did not update correctly!");
			} else {
				System.out.println("Text value updated correctly!");
			}

			// Update the text field to 560 and validate it with respective slider value
			// textField.clear();
			// textField.sendKeys("560");
			// if(!sliderSection.getText().equals("560")) {
			// System.out.println("Slider value is not updated correctly!");
			// throw f.new SliderValueException("Slider value is not updated correctly!");
			//
			// }

			// Scroll down and select CPT Codes
			WebElement cptCodesSection = driver.findElement(By.cssSelector("[class='MuiBox-root css-1p19z09']"));
			js.executeScript("arguments[0].scrollIntoView(true);", cptCodesSection);
			WebElement chkbox_CPT99091 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			chkbox_CPT99091.click();

			WebElement chkbox_CPT99453 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			chkbox_CPT99453.click();

			WebElement chkbox_CPT99454 = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
			chkbox_CPT99454.click();

			WebElement chkbox_CPT99474 = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
			chkbox_CPT99474.click();

			// Validate Total Recurring Reimbursement
			WebElement reimbursementHeader = driver.findElement(
					By.xpath("//p[contains(text(),'Total Recurring Reimbursement for all Patients Per Month:')]"));

			System.out.println(reimbursementHeader.getText());

			if (!reimbursementHeader.getText().contains("$110700")) {
				System.out.println("Reimbursement value is incorrect!");
				throw f.new ReimbursementValueException("Reimbursement value is incorrect!");
			}

			System.out.println("All test cases passed successfully!");

		}

		catch (TextBoxValueException e) {
			System.out.println("TextBoxValueException caught: " + e.getMessage());
		}
		// catch (SliderValueException e) {
		// System.out.println("SliderValueException caught: " + e.getMessage());
		// }
		catch (ReimbursementValueException e) {
			System.out.println("ReimbursementValueException caught: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An unexpected exception occurred: " + e.getMessage());

		} finally {
			driver.quit();
		}

	}
}
