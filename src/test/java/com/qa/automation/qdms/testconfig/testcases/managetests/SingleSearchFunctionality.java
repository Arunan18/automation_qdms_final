//***********************************************************************************
//* Description
//*------------
//*Add Validation - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-008         26/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class SingleSearchFunctionality extends DriverIntialization {
	static TestConfigPage SingleSearchPage = new TestConfigPage();
	static String SearchData = null;
	static String expectedValue = null;
	
@Test	
public void method() throws InterruptedException, IOException {
	
//_________________________________________________________________________
//  LOGIN
//__________________________________________________________________________	
	
	LoginTest.Login();
//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	SingleSearchFunctionality.navigateToTest();
	
//________________________________________________________________________________
// 	STEP-01--PLANT SEARCH ICON IS DISPLAYED 
//	STEP-02--PLANT SEARCH ICON IS ENABLED
//_________________________________________________________________________________		
	
	SingleSearchFunctionality.TestSearchIconClick();
//_________________________________________________________________________________
//    STEP-03--PLANT SEARCH TEXTBOX IS DISPLAYED  
// 	  STEP-04--PLANT SEARCH TEXTBOX IS ENABLED
//_________________________________________________________________________________
	
	SingleSearchFunctionality.testSearchTextbox();
	
//________________________________________________________________________________
//	 STEP-05--PLANT SEARCH BUTTON DISPLAYED &	
//	 STEP-06--PLANT SEARCH BUTTON ENABLED
//________________________________________________________________________________		
	
	SingleSearchFunctionality.TestSearchButton();
}
	

//=============================================  T E S T C A S E S =========================================================	

//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	public static void navigateToTest() {
		PageFactory.initElements(driver, SingleSearchPage);

// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

// NAVIGATE TO MANAGE TEST CONFIGURE
		SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", TestConfigPage.MANGECONFIGURE,
				"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", TestConfigPage.ParameterText,
				"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");
	}

//________________________________________________________________________________
//		 THE METHOD IS FOR GENERATING REPORT 
//_________________________________________________________________________________		
	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}
 
	}

//_________________________________________________________________________________
// 	STEP-01--PLANT SEARCH ICON IS DISPLAYED &	STEP-02--PLANT SEARCH ICON IS ENABLED
//_________________________________________________________________________________		

	public static void TestSearchIconClick() throws InterruptedException {

		PageFactory.initElements(driver, SingleSearchPage);
		Thread.sleep(3000);

		if (TestConfigPage.outSideSearchIcon.isDisplayed()) {
			testCase = extent.createTest("STEP-01--TEST SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");

			if (TestConfigPage.outSideSearchIcon.isEnabled()) {
				testCase = extent.createTest("STEP-02- TEST SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				TestConfigPage.outSideSearchIcon.click();

			} else {
				testCase = extent.createTest("STEP-02 TEST SEARCH ICON IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-01 TEST SEARCH ICON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}

	}

//_________________________________________________________________________________
//	    STEP-03--PLANT SEARCH TEXTBOX IS DISPLAYED  
//	 	STEP-04--PLANT SEARCH TEXTBOX IS ENABLED
//_________________________________________________________________________________

	public static void testSearchTextbox() throws InterruptedException, IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-008");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-008");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
		}
		Thread.sleep(2000);

		if (TestConfigPage.SearchPlaceHolder.isDisplayed()) {
			testCase = extent.createTest("STEP-03 TEST SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.SearchPlaceHolder.isEnabled()) {
				testCase = extent.createTest("STEP-04 TEST SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					TestConfigPage.SearchPlaceHolder.sendKeys(SearchData + (Keys.ENTER));

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-04 TEST SEARCH TEXTBOX IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03  TEST SEARCH TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}

	}

//________________________________________________________________________________
//	 STEP-05--PLANT SEARCH BUTTON DISPLAYED &	
//	 STEP-06--PLANT SEARCH BUTTON ENABLED
//________________________________________________________________________________		

	 public static void TestSearchButton() throws InterruptedException {
		 
		
		 if (TestConfigPage.SearchBtn.isDisplayed()) {
				testCase = extent.createTest("STEP-05- TEST SEARCH BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS");
				if (TestConfigPage.SearchBtn.isEnabled()) {
					testCase = extent.createTest("STEP-06-TEST SEARCH BUTTON  IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS");
					try {
						TestConfigPage.SearchBtn.click();

						Thread.sleep(3000);

					} catch (Exception e) {

					}
				} else {
					testCase = extent.createTest("STEP-06- TEST SEARCH BUTTON  IS NOT ENABLED");
					testCase.log(Status.PASS, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("STEP-05- TEST SEARCH BUTTON  IS NOT DISPLAYED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		
		 boolean clickNextPage = true;
	        int actualElementCount = 0;
	        boolean passorfail = true;
	        ArrayList<String> ActualList = new ArrayList<String>();
	        ArrayList<String> ExpectedList = new ArrayList<String>();
	        String NameXpath_firstPart = "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[";
	        String NameXpath_lastPart = "]/td[1]";
	        while (clickNextPage) {
	            for (int i = 2; i < 750; i++) {
	                try {
	                    String textFull = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart))
	                            .getText();
	                    String text = textFull.toLowerCase();
	                    if (!text.contains(SearchData)) {
	                        passorfail = false;
	                    }
	                    if (text.contains(SearchData)) {
	                        ExpectedList.add(text);
	                    }
	                    ActualList.add(text);
	                    actualElementCount = actualElementCount + 1;
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
	 
	 
	 try {
			int Value = actualElementCount;
			TestCasePrint("STEP-10--SINGLE SEARCH CONFIRM", expectedValue, String.valueOf(Value));
		} catch (Exception e) {

		}

} 
}
