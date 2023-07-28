//***********************************************************************************
//* Description
//*------------
//* Add Additional Information Validation
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 09/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0223 	      09/05/2023   Gobithan     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddAditionalInformationValidation extends DriverIntialization {
	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, methods);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				testnav.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				managepage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE ADDITIONAL INFORMATION DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- ADDITIONAL INFORMATION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 10, managepage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0223-01", 1);

		extent.createTest("STEP :5 ADD ADDITIONAL INFORMATION VALIDATION");
		/* CAPTIONAL FIELD VALIDATION */
		validation(testnav.captionvalidaion, 0);
		
		/* RECORD TYPE FIELD FIELD VALIDATION */
		validation(testnav.recordtypevalidaion, 1);
		
		/* MAX LENGTH FIELD VALIDATION */
		validation(testnav.maxlengthvalidaion, 2);

		Thread.sleep(1000);
		TestConfigPage.additionalcancel.click();
		
		/* LOGOUT */
		logout.LogoutFunction();
	}

	static String validation_ex = null;
	static String reportmsg = null;
	static int j = 0;

	public static void validation(WebElement validation_xpath, int j) {
		try {

			String excelPath = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
			String excelSheetName = "Test_Configure";
			String testCaseId = "TC-TCN-0223";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Test_Configure");

			XSSFRow row = sheet.getRow(firstRow + j);
			validation_ex = (String) row.getCell(2).getStringCellValue();
			reportmsg = (String) row.getCell(3).getStringCellValue();

			testnav.addbtn.click();
			Thread.sleep(1000);

			String ActualValidation = validation_xpath.getText();

			String ExpectedValidation = validation_ex;
			testCase = extent.createTest(reportmsg);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}

	}
}
