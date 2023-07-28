//***********************************************************************************
//* Description
//*------------
//*Single Search Functionality, ResetButton Functionality - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-006          27/04/2023      Saranka     Original Version
//*  MTC-GT-007          27/04/2023      Saranka      Reset Button
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

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
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.managetests.SingleSearchFunctionality;

public class SigleSearchFunctionalityandCheckResetButtonFunctionlaity extends DriverIntialization {
	static TestConfigPage SearchReset = new TestConfigPage();
	static String SearchData = null;
	static String expectedValue = null;
	
//==================================================== M E T H O D ============================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
//________________________________________________________
// LOGIN
//________________________________________________________	
		
		LoginTest.Login();
		
//________________________________________________________
// NAVIGATE TO TEST CONFIGURE
//________________________________________________________
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.navigateToGroupTest();
		
//__________________________________________________________
//        STEP-01--GROUP NANME SEARCH ICON IS DISPLAYED &	
//        STEP-02--GROUP NAME  SEARCH ICON IS ENABLED
//__________________________________________________________		
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.SearchIconClick();
		
//_________________________________________________________________________________
//   STEP-03--GROUP NAME SEARCH TEXTBOX IS DISPLAYED  
//   STEP-04--GROUP NAME SEARCH TEXTBOX IS ENABLED
//_________________________________________________________________________________
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.SearchTextbox();
		
//________________________________________________________________________________
//   STEP-05--GROUP NAME SEARCH BUTTON DISPLAYED &	
//   STEP-06--GROUP NAME SEARCH BUTTON ENABLED
//________________________________________________________________________________	
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.SearchButton();
		
//________________________________________________________________________________
//   STEP-07--RESET BUTTON VISIBLE AND ENABLE 
//________________________________________________________________________________			
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.ResetButtonEnableAndVisible();
		
//________________________________________________________________________________
//   STEP-08--RESET BUTTON CLICK AFTER VALIDATE 
//________________________________________________________________________________			
		
		SigleSearchFunctionalityandCheckResetButtonFunctionlaity.ValidateResetButtonfunction();
		
//________________________________________________________________________________
//  LOGOUT
//_______________________________________________________________________________		
		
		MultiSearchMethods.Logout();
	}
	

//====================================================== T E S T C A S E =====================================================
//_________________________________________________________________________
// NAVIGATE TO MANAGE TEST CONFIGURE
//__________________________________________________________________________	

	public static void navigateToGroupTest() {
		PageFactory.initElements(driver, SearchReset);

		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO MANAGE TEST CONFIGURE
		SampleCommonMethods.methodoneclick("STEP:1 MANGECONFIGURE PROPERTIES", TestConfigPage.MANGECONFIGURE,
				"MANGECONFIGURE SIDE BUTTON IS DISPLAY", "MANGECONFIGURE SIDE BUTTON IS ENABLED",
				TestConfigPage.ParameterText, "MANGECONFIGURE SIDE BUTTON",
				"ON CLICK THE MANGECONFIGURE BUTTON IT'S REDERECT TO CORRECT FORM");

		// NAVIGATE TO MANAGE GROUP TEST
		SampleActionMethods.clicking(TestConfigPage.GroupTest, 2, "GROUP TEST SIDE BUTTON");
	}

//________________________________________________________________________________
//	 THE METHOD IS FOR GENERATING REPORT 
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
//STEP-01--GROUP NANME SEARCH ICON IS DISPLAYED &	
//STEP-02--GROUP NAME  SEARCH ICON IS ENABLED
//_________________________________________________________________________________		

	public static void SearchIconClick() throws InterruptedException {

		PageFactory.initElements(driver, SearchReset);
		Thread.sleep(2000); 

		if (TestConfigPage.SearchIconGroupName.isDisplayed()) {
			testCase = extent.createTest("STEP-01-- GROUP NAME SEARCH ICON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");

			if (TestConfigPage.SearchIconGroupName.isEnabled()) {
				testCase = extent.createTest("STEP-02- GROUP NAME SEARCH ICON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				TestConfigPage.SearchIconGroupName.click();

			} else {
				testCase = extent.createTest("STEP-02 GROUP NAME SEARCH ICON IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-01 GROUP NAME SEARCH ICON IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}

	}

//_________________________________________________________________________________
//   STEP-03--GROUP NAME SEARCH TEXTBOX IS DISPLAYED  
//	STEP-04--GROUP NAME SEARCH TEXTBOX IS ENABLED
//_________________________________________________________________________________

	public static void SearchTextbox() throws InterruptedException, IOException {
		PageFactory.initElements(driver, SearchReset);

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Group_Tests");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Group_Tests", "MTC-GT-006");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Group_Tests", "MTC-GT-006");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			SearchData = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();
		}
		Thread.sleep(2000);

		if (TestConfigPage.SearchGroupNameTextBox.isDisplayed()) {
			testCase = extent.createTest("STEP-03 GROUP NAME SEARCH TEXTBOX IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.SearchGroupNameTextBox.isEnabled()) {
				testCase = extent.createTest("STEP-04 GROUP NAME SEARCH TEXTBOX IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					TestConfigPage.SearchGroupNameTextBox.sendKeys(SearchData + (Keys.ENTER));

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-04 GROUP NAME SEARCH TEXTBOX IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-03  GROUP NAME SEARCH TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.PASS, "TEST FAIL");
		}

	}

//________________________________________________________________________________
//STEP-05--GROUP NAME SEARCH BUTTON DISPLAYED &	
//STEP-06--GROUP NAME SEARCH BUTTON ENABLED
//________________________________________________________________________________		

	public static void SearchButton() throws InterruptedException {
		PageFactory.initElements(driver, SearchReset);

		if (TestConfigPage.SearchButtonGroupName.isDisplayed()) {
			testCase = extent.createTest("STEP-05- GROUP NAME SEARCH BUTTON IS DISPLAYED");
			testCase.log(Status.PASS, "TEST PASS");
			if (TestConfigPage.SearchButtonGroupName.isEnabled()) {
				testCase = extent.createTest("STEP-06- GROUP NAME SEARCH BUTTON  IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS");
				try {
					TestConfigPage.SearchButtonGroupName.click();

					Thread.sleep(3000);

				} catch (Exception e) {

				}
			} else {
				testCase = extent.createTest("STEP-07- GROUP NAME SEARCH BUTTON  IS NOT ENABLED");
				testCase.log(Status.PASS, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP-08- GROUP NAME SEARCH BUTTON  IS NOT DISPLAYED");
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

//___________________________________________________________________
// RESET BUTTON ENABLE AND VISIBLE 
//____________________________________________________________________
	public static void ResetButtonEnableAndVisible() throws InterruptedException {
		PageFactory.initElements(driver, SearchReset);

		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.ResetButtonGroupName, 2, " STEP:11 RESET BUTTON ");
	}

//__________________________________________________________________________
//  VALIDATE AFTER CLCIK RESET BUTTON
//___________________________________________________________________________	
	public static void ValidateResetButtonfunction() throws InterruptedException {
		PageFactory.initElements(driver, SearchReset);

	
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
