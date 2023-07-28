
//***********************************************************************************
//* Description
//*------------
//* Review Test Parameter edit validation function under Test Configure
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 4/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0119            4/05/2023     Niluxy       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditValidationFunction_ReviewTestParameter extends DriverIntialization {

	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();

	static boolean testdata = true;
	static String abriviation = null;
	static String tobeedit = "";
	static String expectedmessage = "";

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, groupkey);
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK TEST CONFIGURATION
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST CONFIG");
		Thread.sleep(2000);

		// CLICK MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 2000, "STEP 3:CHECKING THE MANAGE TEST CONFIG MODULE ");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  DESCRIPTION PROPERTIES");
		AddGroupKey.actionS(0, 14, managepage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0119-01", 1);

		// CLICK TEST CONFIGURE LEFT BUTTON
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 200, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(3000);
		SampleActionMethods.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 200,
				"STEP 6:CHECKING THE RADIO BUTTON TEST PARAMETER");

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
DataFormatter data12 = new DataFormatter();
		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0119");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0119");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeedit = data12.formatCellValue(row.getCell(2));
			System.out.println("tobeedit qqqq" + tobeedit);

		}
		try {
			// FIND THE EDIT ICON ELEMENT FROM THE EXCEL
			Thread.sleep(3000);
			WebElement edit = driver.findElement(By.xpath("//td[contains(text(),'"+tobeedit+"')]//following-sibling::td[10]//span[contains(@class,'anticon-edit')]"));
			System.out.println(edit);
			if (edit.isDisplayed()) {
				System.out.println(edit + "{{{{{{{{{{");
				testCase = extent.createTest("STEP 7:EDIT ICON DISPLY");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (edit.isEnabled()) {
					testCase = extent.createTest("STEP 7:EDIT ICON ENABLE");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {
						edit.click();

					} catch (Exception e) {

					}

				} else {
					testCase = extent.createTest("ELEMENT IS NOT ENABLE");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("ELEMENT IS NOT DISPLY");
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			}
		} catch (Exception e) {
			testCase = extent.createTest("ELEMENT IS NOT DISPLAY");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		// CHECKING THE VALIDATIONS
		validation();
	}

	/*
	 * ______________________________________________________________________________________
	 */
//METHOD FOR VALIDATION//	
	public static void validation() throws IOException, InterruptedException {
		/* edit Validation in review test */

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0119";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		extent.createTest("STEP :9 REVIEW TEST  EDIT VALIDATION");
		for (int j = firstRow; j <= lastRow; j++) {
			XSSFRow row = sheet.getRow(j);
			tobeedit = (String) row.getCell(2).getStringCellValue();
			System.out.println("tobeedit" + tobeedit);
			tobeedit = (String) row.getCell(1).getStringCellValue();
			String parameter = (String) row.getCell(3).getStringCellValue();
			String validationmsg = (String) row.getCell(4).getStringCellValue();
			String testcase = (String) row.getCell(5).getStringCellValue();

			Thread.sleep(2000);	
			// CLICK ABBREVIATION FIELD AND CHECK ENABLED AND DISABLED		
			SampleActionMethods.clicking(TestConfigPage.abbriviationtextboxreviewtest, 2000,
					"CHECKING THE ABBREVIATION FIELD ");
			//REMOVE THE VALUE
			TestConfigPage.abbriviationtextboxreviewtest.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			try {
				TestConfigPage.abbriviationtextboxreviewtest.sendKeys(String.valueOf(parameter));
				TestConfigPage.updatebuttonreviewtest.click();
				Thread.sleep(1000);
				String ActualValidation = TestConfigPage.validationmessageedit_reviewtest.getText();
				String ExpectedValidation = validationmsg;
				testCase = extent.createTest(testcase);
				try {
					Assert.assertEquals(ActualValidation, ExpectedValidation);
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.PASS, "Pass");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
					testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
					testCase.log(Status.FAIL, "Fail");
				}
			} catch (Exception e) {

			}

		}
		Thread.sleep(2000);
		// CLICK CANCEL BUTTON
		TestConfigPage.CancelBtn.click();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
