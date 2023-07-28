//***********************************************************************************
//* Description
//*------------
//* Accepted Condition Edit Validation
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 17/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-102         17/05/2023   Gobithan     Orginal Version
//* MTC-MT-104         17/05/2023
//* MTC-MT-105		   17/05/2023
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
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

public class AcceptedConditionEditValidation extends DriverIntialization {

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

		/* PAGE SCROLL UNTIL ADDITIONAL INFORMATION */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//td[@class='ant-table-cell'])[13]");

		/* SELECT THE ACCEPTED CONDTION BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- ACCEPTED CONDTION BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-102-01", 1);

		/* SELECT THE ACCEPTED CONDTION EDIT BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_05-- ACCEPTED CONDTION EDIT BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 1, ManageTestsPage.acceptedconditioncontainer, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-102-01", 2);

		/* UPDATE BUTTON PROPERTYS */
		SampleCommonMethods.singleclick("STEP_06-- UPDATE BUTTON PROPERTYS", managepage.acceptedvalueinsideUpdatebutton,
				"01--UPDATE BUTTON DISPLAYED", "02--UPDATE BUTTON ENABLED");

		/* VALIDATION */
		extent.createTest("STEP_07-- EDIT CONDTION VALIDATION");
		validation(managepage.equationvalidation, 0);
		validation(managepage.equationspacevalidation, 1);
		validation(managepage.equationspacevalidation, 2);

		/* CANCEL BUTTON PROPERTYS */
		SampleCommonMethods.singleclick("STEP_08-- CANCEL BUTTON PROPERTYS", managepage.equationcancelbtn,
				"01--CANCEL BUTTON DISPLAYED", "02--CANCEL BUTTON ENABLED");

		/* ACCEPETED CONDITION CANCEL BUTTON */
		managepage.acceptedconditioncancelbtn.click();

		/* LOGOUT */
		logout.LogoutFunction();
	}

	static String validation_ex = null;
	static String reportmsg = null;
	static String value = null;
	static int j = 0;

	public static void validation(WebElement validation_xpath, int j) {
		try {

			String excelPath = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
			String excelSheetName = "Manage_Tests";
			String testCaseId = "MTC-MT-102";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Manage_Tests");

			XSSFRow row = sheet.getRow(firstRow + j);
			value = (String) row.getCell(3).getStringCellValue();
			validation_ex = (String) row.getCell(4).getStringCellValue();
			reportmsg = (String) row.getCell(5).getStringCellValue();

			managepage.editconditiontxtarea.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			managepage.editconditiontxtarea.sendKeys(value);
			if (managepage.acceptedvalueinsideUpdatebutton.isEnabled()) {
				managepage.acceptedvalueinsideUpdatebutton.click();
			} else {
				testCase = extent.createTest("UPDATE BUTTON IS NOT ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
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
