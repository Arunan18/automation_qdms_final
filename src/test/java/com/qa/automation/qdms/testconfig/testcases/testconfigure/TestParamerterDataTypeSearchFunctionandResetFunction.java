//***********************************************************************************
//* Description
//*------------
//*Particular test Test Parameter data type search function- Test Configuration - Test Case
//* particular test Test Parameter data type Reset function
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 02/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0106         02/05/2023   Saranka     Original Version
//* TC-TCN-0104
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantFieldSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParamerterDataTypeSearchFunctionandResetFunction extends DriverIntialization {
	static TestConfigPage SearchReset = new TestConfigPage();
	static String Searchdata = null;
	static String expectedValue = null;
	static PlantFieldSearchMethods count = new PlantFieldSearchMethods();

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
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, SearchReset);
		PageFactory.initElements(driver, count);

//_____________________________LOGIN TO THE SYSTEM______________________________

		LoginTest.Login();

//_____________________________ NAVIGATE TO TEST CONFIGURATION_____________________________

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

//___________________________________ MANAGE CONFIGURE MENU BAR _________________________

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//_______________________________________ SCROLL ________________________________________		
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

//_________________________________________ 
//		NAVIGATE TO PARAMETER
//_______________________________________
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.TestParameterStepTwo, 2, "TEST PARAMETER STEP TWO");

//_________________________________________
// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
//________________________________________

		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

//_________________________________________ 
//REFERESH THE PAGE
//_________________________________________
		driver.navigate().refresh();

//_________________________________________
// SEAECH FUNCTION
//_________________________________________		

		SampleActionMethods.clicking(TestConfigPage.SearchIconDataType, 2, " DATA TYPE - SEARCH ICON");

		SampleActionMethods.clicking(TestConfigPage.PlaceHolderSearchDataType, 2, " DATA TYPE - SEARCH PLACEHOLDER");

//_______________________________________________
//  EXCEL METHOD
//_______________________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0106";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			Searchdata = (String) row.getCell(1).getStringCellValue();
			expectedValue = (String) row.getCell(2).getStringCellValue();

		}

		String text = Searchdata;
		WebElement ClickDropDown = driver.findElement(By.xpath("//div[contains(@title,'" + text + "')]"));

		try {
			ClickDropDown.click();
			testCase.log(Status.PASS, "DATA SEND");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, " DATA NOT SEND");
		}

//______________________________________________
// AFTER SEARCH
//______________________________________________

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
					String text1 = textFull.toLowerCase();
					if (!text1.contains(Searchdata)) {
						passorfail = false;
					}
					if (text1.contains(Searchdata)) {
						ExpectedList.add(text1);
					}
					ActualList.add(text1);
					actualElementCount = actualElementCount + 1;
				} catch (Exception e) {
				}
			}
			if (clickNextPage == true) {
				Actions actions1 = new Actions(driver);
				actions1.sendKeys(Keys.PAGE_DOWN).build().perform();
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

			TestCasePrint("SINGLE SEARCH CONFIRM", expectedValue, String.valueOf(Value));
		} catch (Exception e) {

		}
		TestConfigPage.tableContainer.sendKeys(Keys.ARROW_UP);

//_________________________________________		
// CHECK THE RESET BUTTON FUNCTIONALITY
//_________________________________________		

		SampleActionMethods.clicking(TestConfigPage.DataTypeReset, 2, "CHECK THE RESETBUTTON");

//_________________________________________
// CHECK THE DATA COUNT IN TABLE AFTER RESET
//_________________________________________		
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		CommonMethods.TestCasePrint("-CHECK RESET FUNCTION CORRECTLY", beforecount, aftercount);

//________________________________________		
// LOGOUT TO THE SYSTEM
//________________________________________			
		Logout.LogoutFunction();

	}
}
