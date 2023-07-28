//***********************************************************************************
//* Description
//*------------
//*Test Parameter search icon function- Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0092         01/05/2023   Saranka     Original Version
//* TC-TCN-0095
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class PerticulatTestParameterSearchButtonAndResetButtonFunctionality extends DriverIntialization {
	static TestConfigPage resetAndSearchFunctionality = new TestConfigPage();
	static String Searchdata = null;
	static String SearchExpectedResult = null;
	static String ResetExpectedResult = null;
	static String SearchResultText = null;

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

	@Test
	public void SearchAndResetFun() throws InterruptedException, IOException {
		PageFactory.initElements(driver, resetAndSearchFunctionality);

//_______________________________
// LOGIN
//______________________________
		LoginTest.Login();

//________________________________________________
//  NAVIGATE TO TEST CONFIGURATION PARAMETER
//______________________________________________

// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}
		TestConfigPage.Editconfi.click();

		// NAVIGATE TO PARAMETER
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.TestParameterStepTwo, 2, "TEST PARAMETER STEP TWO");

		WebElement AddGroup = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		Thread.sleep(2000);
		AddGroup.click();

//______________________________________________________________
//STEP:1 PARAMETER SEARCH ICON VISIBLE AND ENABLE, 
//STEP:2 PARAMETER SEARCH TEXTBOX VISIBLE AND ENABLE 
//STEP:3 PARAMETER SEARCH BUTTON VISIBLE AND ENABLE		
//____________________________________________________________
		SampleActionMethods.clicking(TestConfigPage.SearchIconGroupName, 2, "STEP:1 PARAMETER GROUP SEARCH ICON");

		SampleActionMethods.clicking(TestConfigPage.SearchGroupNameTextBox, 2, "STEP:2 PARAMETER GROUP SEARCH TEXTBOX");

//_______________________________________________
//  EXCEL METHOD
//_______________________________________________
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0093"; 

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			Searchdata = (String) row.getCell(1).getStringCellValue();
			SearchExpectedResult = (String) row.getCell(2).getStringCellValue();
			ResetExpectedResult = (String) row.getCell(3).getStringCellValue();
			
			SearchResultText= (String) row.getCell(2).getStringCellValue();
		} 
//________________________________________________________________________		

		try { 
			Thread.sleep(2000);
			TestConfigPage.GroupTestParameterSearchTextBox.sendKeys(Searchdata);
			testCase.log(Status.PASS, "DATA SEND");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, " DATA NOT SEND");
		}

//______________________________________________
// AFTER SEARCH
//______________________________________________

		
// Verify search results are displayed correctly
		List<WebElement> searchResults = driver.findElements(By.xpath("(//div[@class='ant-table-container'])[4]"));
	String leo = SearchResultText;
	Thread.sleep(2000);
	WebElement TableRow = driver.findElement(By.xpath("(//td)[33]"));
	
	String actualText = TableRow.getText();
	System.out.println(" Data Spell:-" + actualText);
	String expectedText = "";
	testCase = extent.createTest(" AFTER SEARCH GET TEXT");
	boolean data = true;
	try {
		assertEquals(actualText, expectedText);
	} catch (AssertionError e) {
		// TODO: handle exception
	}
	if (data) {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.PASS, "Text Correct");
	} else {
		testCase.log(Status.INFO, " Actual Text:" + actualText);
		testCase.log(Status.INFO, " Expected Text:" + expectedText);
		testCase.log(Status.FAIL, "Text Correct");
	}

	

//_____________________________________________
// CHECK THE RESET BUTTON FUNCTIONALITY
//_______________________________________________	
		
		
		WebElement afterSearchIcon = driver.findElement(By.xpath("//span[@class='ant-dropdown-trigger ant-table-filter-trigger ant-dropdown-open']"));
		afterSearchIcon.click();
		SampleActionMethods.clicking(TestConfigPage.ResetButtonGroupName, 2, "RESETBUTTON");

		
		
		//searchResults = driver.findElements(By.xpath("//table[@class='ant-table-fixed']//tbody//tr"));
		assertEquals(searchResults.size(), ResetExpectedResult);

		driver.navigate().refresh();
		
		Logout.LogoutFunction();

	}

}
