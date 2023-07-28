package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

public class TestConfigMethods extends DriverIntialization {

	/*
	 * Author: RAHUL.S THIS METHOD IS FOR TEST CONFIGURE STEP NUMBER CLICKING
	 * DATE:2023/06/22 TIME: 7.00PM
	 */
	public static void clickButton(int number) throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-steps-horizontal')]//div[" + number
							+ "]//div[@class='ant-steps-item-icon']")))
					.click();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	/*
	 * Author: RAHUL.S THIS METHOD IS FOR CLICKING BUTTON,ICON,DESCRIPTION ETC
	 * DATE:2023/06/22 TIME: 7.00PM
	 */
	public static void clickElement(WebElement pageAndElement, String report) throws InterruptedException, IOException {
		try {
			if (pageAndElement.isDisplayed()) {
				testCase = extent.createTest(report);
				testCase.log(Status.INFO, "THE ELEMENT IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (pageAndElement.isEnabled()) {
					testCase = extent.createTest(report);
					testCase.log(Status.INFO, "THE ELEMENT IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					WebDriverWait wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOf(pageAndElement)).click();
					testCase = extent.createTest(report);
					testCase.log(Status.INFO, "THE ELEMENT IS CLICKED");
					testCase.log(Status.PASS, "TEST PASS");
				}
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest(report);
			testCase.log(Status.INFO, "THE ELEMENT NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest(report);
			testCase.log(Status.INFO, "THE ELEMENT NOT CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (Exception e) {
			testCase = extent.createTest(report);
			testCase.log(Status.INFO, "THE ELEMENT NOT FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}


	//NILUX
	//COMMON METHOD FOR NAVIGATE TO TESTCONFIGURE 7 TABS
	public static void navigate_TestConfigureTabs(int tabNumber) throws InterruptedException, IOException {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_UP).perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[contains(@class,'ant-steps-horizontal')]//div[3]//div[@class='ant-steps-item-icon']")))
					.click();

			try {
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//div[@class='ant-steps-item-icon'])["+tabNumber+"]"))).click();
              System.out.println(tabNumber+"aaaaaaa");

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("CHECKING THE TEST CONFIGURE MODULE ELEMENT");
				testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("CHECKING THE TEST CONFIGURE MODULE ELEMENT");
				testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE CLICKED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			} catch (Exception e) {
				testCase = extent.createTest("CHECKING THE TEST CONFIGURE MODULE ELEMENT");
				testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND OR CLICKED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE TEST CONFIGURE TAB ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("CHECKING THE TEST CONFIGURE TAB ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE TEST CONFIGURE TAB ELEMENT");
			testCase.log(Status.INFO, "THE ELEMENT CAN NOT BE FOUND OR CLICKED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}


	/*
	 * Author: RAHUL.S THIS METHOD IS FOR SEARCH VALUE IN ANY PAGE DATE:2023/06/26
	 * TIME: 1.20PM
	 */
	public static void searchvalue(String SearchValue, int column) throws InterruptedException {

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();

		WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button"));
		boolean nextBtn = next.isEnabled();

		List<WebElement> Colu = driver
				.findElements(By.xpath("//tr[contains(@class,'ant-table-row')]/child::td[" + column + "]"));

		List<WebElement> sectionList = Colu;
		List<String> list = new ArrayList<String>();
		nextBtn = true;
		while (nextBtn) {
			for (WebElement linkElement : sectionList) {
				String linkText = linkElement.getText();
				System.out.println(linkText);
				list.add(linkText);
				boolean isExist = list.contains(SearchValue);
				if (isExist) {
					break;

				}
			}

			boolean isExist = list.contains(SearchValue);
			Thread.sleep(3000);
			nextBtn = next.isEnabled();
			System.out.println("ele" + isExist);
			System.out.println("next" + nextBtn);
			if (nextBtn && isExist != true) {
				next.click();

			} else
				break;
		}
	}
}


