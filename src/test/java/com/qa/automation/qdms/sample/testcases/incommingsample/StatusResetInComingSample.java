//***********************************************************************************
//* Description
//*------------
//* Status Reset Functionality in Incoming Samples
//***********************************************************************************
//*
//* Author           : Saththiyarajah Sayanthan
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0165                    27/04/2023   Sayan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class StatusResetInComingSample extends DriverIntialization {
	
	
	static String status = null;
	
	@Test
	
	
	public static void resetContactSearch() throws InterruptedException, IOException {
		
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Incoming Sample");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Incoming Sample", "TC-INC-SAM-0165");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Samples Module.xlsx",
				"Incoming Sample", "TC-INC-SAM-0165");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			status = (String) row.getCell(1).getStringCellValue();
		
			
		}
		
		
		LoginTest.Login();
		
		Thread.sleep(500);
		SampleNavigationPage.sampleXpath();

		
		// --------------------------------------------------------------------------------------
//			STEP-01--RAW MATERIAL TAB IS DISPLAYED & STEP-02--RAW MATERIAL TAB IS ENABLED
		// --------------------------------------------------------------------------------------

			Thread.sleep(3000);
		if (driver.findElement(By.xpath("//a[@href=\'#/samples\']")).isDisplayed()) {
			testCase = extent.createTest("STEP-01--RAW MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//a[@href=\'#/samples\']")).isEnabled()) {
				testCase = extent.createTest("STEP-02--RAW MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//a[@href=\'#/samples\']")).click();
					Thread.sleep(2000);
				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP-02--RAW MATERIAL BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-01--RAW MATERIAL BUTTON IS DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		
		// --------------------------------------------------------------------------------------
		// STEP-03--INCOMING SAMPLE BUTTON IS DISPLAYED & STEP-04-INCOMING SAMPLE MODULE BUTTON IS
		// ENABLED
		// --------------------------------------------------------------------------------------
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]")).isDisplayed()) {
			testCase = extent.createTest("STEP-03--INCOMING SAMPLE MODULE BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]")).isEnabled()) {
				testCase = extent.createTest("STEP-04-INCOMING SAMPLE MODULE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//div[@class='sc-htoDjs jApeNY']/div[1]/div[1]")).click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP-03--INCOMING SAMPLE MODULE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-04-INCOMING SAMPLE MODULE BUTTON IS ENABLED");
			testCase.log(Status.PASS, "TEST FAIL ❎");

		}

		// ---------------------------------------------------------------------------------------
		// Count Number of elemenets before search
		// ---------------------------------------------------------------------------------------
		boolean clickNextPage = true;
		int BeforeCount = 0;

		ArrayList<String> BeforestringList = new ArrayList<String>();

		String CodeXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div[1]/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
		String CodeXpath_lastPart = "]/td[16]";
		while (clickNextPage) {

			for (int i = 2; i < 250; i++) {

				try {
					String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart)).getText();

					BeforestringList.add(text);
					BeforeCount = BeforeCount + 1;
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		Thread.sleep(500);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("before count " + BeforeCount);
		System.out.println(BeforestringList);

		


		// Status Search
		// --------------------------------------------------------------------------------------

		try {
			driver.findElement(By.xpath(
					"//th[16]//div[1]//span[2]"))
					.click();
			Thread.sleep(1000);

		} catch (Exception e) {

		}
		

		// Status Search btn
		// --------------------------------------------------------------------------------------

		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@class='ant-select-selection-search-input']")).click();
			driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//input[@class='ant-select-selection-search-input']")).sendKeys(status);
			Thread.sleep(2000);

		} catch (Exception e) {

		}

		try {
			driver.findElement(By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-primary ant-btn-sm']")).click();
			Thread.sleep(2000);

		} catch (Exception e) {

		}
		// --------------------------------------------------------------------------------------
		// Status Search -> reset button
		// --------------------------------------------------------------------------------------
		if (driver.findElement(By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-sm']"))
				.isDisplayed()) {
			testCase = extent.createTest("STEP-04--RESET BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS ☑");
			if (driver.findElement(By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-sm']"))
					.isEnabled()) {
				testCase = extent.createTest("STEP-05--RESET BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ☑");
				try {
					driver.findElement(By.xpath("//div[@class='ant-dropdown ant-dropdown-placement-bottomRight ']/div/div/div[2]/div/button[@class='ant-btn ant-btn-sm']")).click();
					Thread.sleep(2000);

				} catch (Exception e) {

				}
				Thread.sleep(3000);
			} else {
				testCase = extent.createTest("STEP-05--RESET BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST FAIL ❎");
			}
		} else {
			testCase = extent.createTest("STEP-04--RESET BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL ❎");
		}

		// Search after Count
		// --------------------------------------------------------------------------------------

		ArrayList<String> AfterstringList = new ArrayList<String>();
		clickNextPage = true;
		int AfterCount = 0;

		while (clickNextPage) {

			for (int i = 2; i < 250; i++) {

				try {
					String text = driver.findElement(By.xpath(CodeXpath_firstPart + i + CodeXpath_lastPart)).getText();

					AfterCount = AfterCount + 1;
					AfterstringList.add(text);
				} catch (Exception e) {
				}
			}
			
			if (clickNextPage == true) {
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.PAGE_DOWN).build().perform();
				clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
						.isEnabled();
				driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
				Thread.sleep(2000);
			} else {
				break;
			}
		}

		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println("after count " + AfterCount);
		System.out.println(AfterstringList);
		// *****************************************************************************************************
//										STEP-08--CONFIRM THE RESET BUTTON	
		// *****************************************************************************************************
		try {
			testCase = extent.createTest("STEP-08--CONFIRM THE RESET BUTTON");

			try {
				Assert.assertEquals(BeforeCount, AfterCount);
				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

				testCase.log(Status.PASS, "RESET WORKED");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "BeforeCount :- " + BeforeCount);
				testCase.log(Status.INFO, "AfterCount :- " + AfterCount);

				testCase.log(Status.FAIL, "RESET WORKED");
			}
		} catch (Exception e) {

		}
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		MultiSearchMethods.Logout();

	}


	// ********************************************************************************************************
//			 THE METHOD IS FOR GENERATING REPORT 
	// ********************************************************************************************************
	public static void TestCasePrint(String TestCaseName, Object expectedValue, Object actualValue) throws InterruptedException {
		boolean position = true;

		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.PASS, "TEST PASS ☑");
		} else {
			testCase.log(Status.INFO, "Actual value: " + actualValue.toString());
			testCase.log(Status.INFO, "Expected value: " + expectedValue.toString());
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		
		
		
	}
	

}
