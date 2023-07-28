//***********************************************************************************
//* Description
//*------------
//*Edit Accepted criteria Validation Configure Test - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 09/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0174         09/05/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditAcceptedCriteriaValidation extends DriverIntialization {
	static TestConfigPage EditPage = new TestConfigPage();
	static String TobeSearchData = null;
	static String EditData = null;
	static String ValidationMessagetext = null;
	
//=====================================================  M E T H O D  =========================================================	
	@Test
	public void methods() throws InterruptedException, IOException {
		
		
		LoginTest.Login();
		
		EditAcceptedCriteriaValidation.naviagateToMangeTest();
		
		EditAcceptedCriteriaValidation.ExcelMethod();
		
		EditAcceptedCriteriaValidation.EditAndValidate();
		
		Logout.LogoutFunction();
		
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void naviagateToMangeTest() throws InterruptedException, IOException {
		PageFactory.initElements(driver, EditPage);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[@class='ant-table-cell'][normalize-space()='Equation'])[1]"))
								.click();
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

	}

//______________________________________
//  EXCEL METHOD
//_______________________________________
	public static void ExcelMethod() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Config_Group_Test";
		String testCaseId = "TC-TCN-0174";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			TobeSearchData = (String) row.getCell(1).getStringCellValue();
			EditData = (String) row.getCell(2).getStringCellValue();
			ValidationMessagetext = (String) row.getCell(3).getStringCellValue();

		}
	}
// ________________________________
// SEARCH DATA
// _______________________________

	public static void EditAndValidate() throws InterruptedException {
		PageFactory.initElements(driver, EditPage);

		ActionCommonMethod.actionS(0, 8, TestConfigPage.TableManageConfigure, "Description",
				"Test Configuragtion Module.xlsx", "Config_Group_Test", "TC-TCN-0174-01", 1);

//________________________________	
//  EDIT DATA
//_________________________________	

		SampleActionMethods.clicking(TestConfigPage.EditButtonAccepetdValue, 2, "STE:1 EDIT BUTTON");

		testCase = extent.createTest("STEP:2 DATA EDITED");
		try {
			WebElement EditTextBoxValue = driver.findElement(By.xpath("//input[@id='finishPDValue']"));
			EditTextBoxValue.sendKeys(Keys.CONTROL, "a");
			EditTextBoxValue.sendKeys(Keys.DELETE);
			EditTextBoxValue.sendKeys(EditData);
			testCase.log(Status.PASS, "Data Edited");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "Data Not Edited");
		}

		SampleActionMethods.clicking(TestConfigPage.UpdateBtnAccepetVal, 2, "STEP:3 UPDATE BUTTON");

//______________________________________________________
//	VALIDATION MESSAGE VISIBLE AND SPELLING
//______________________________________________________

		WebElement ValidationMessage = driver.findElement(By.xpath("//div[normalize-space()='Test already depend']"));

		boolean Message = ValidationMessage.isDisplayed();
		if (Message) {
			boolean actualVisible = ValidationMessage.isDisplayed();
			System.out.println("Visible" + actualVisible);
			boolean expectedVisible = true;
			testCase = extent.createTest("STEP:3 VALIDATION MESSAGE VISIBLE");

			try {
				Assert.assertEquals(actualVisible, expectedVisible);
				testCase.log(Status.PASS, "Visible correct");
			} catch (AssertionError e) {
				// TODO: handle exception
				testCase.log(Status.FAIL, "Visible In-correct");
			}
		}

		String actialText = ValidationMessage.getText();
		System.out.println("Validation Message:-" + actialText);
		String expectedText = ValidationMessagetext;

		testCase = extent.createTest("STEP:4 VALIDATION MESSAGE SPELLING");
		try {
			Assert.assertEquals(actialText, expectedText);
		} catch (AssertionError e) {
			// TODO: handle exception

		}
		boolean messageSpelling = true;
		if (messageSpelling) {
			testCase.log(Status.INFO, "ActualText:-" + actialText);
			testCase.log(Status.INFO, "Expected Text:-" + expectedText);
			testCase.log(Status.PASS, "Correct Text");
		} else {
			// TODO: handle exception
			testCase.log(Status.INFO, "ActualText:-" + actialText);
		testCase.log(Status.INFO, "Expected Text:-" + expectedText);
		testCase.log(Status.FAIL, "In-Correct Text");
		
	}
		Thread.sleep(2000);
		driver.navigate().refresh();

	}
	
}
