//***********************************************************************************
//* Description
//*------------
//* GROUP TEST EDIT VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 10/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-002			 10/05/2023   Gobithan     Orginal Version
//*
//*****************************************************************************
package com.qa.automation.qdms.testconfig.testcases.grouptests;

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
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class GroupTestEditValidation extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, action);

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

		/* GROUP TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- GROUP TEST PROPERTIES", testnav.GroupTest,
				"01--GROUP TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--GROUP TEST LEFT NAVIGATION BUTTON ENABLED",
				grouptest.grouptestheading, "Group Tests",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* SELECT THE VALUE */
		ActionCommonMethod.actionS(0, 6, GroupTestsPage.grouptestcontainer, "Form", "Test Configuragtion Module.xlsx",
				"Group_Tests", "MTC-GT-002-01", 1);

		/* CHECK VALIDATION */
		validation(grouptest.groupnamevalidation);

		/* LOGOUT */
		Logout.LogoutFunction();

	}

	static String validation_ex = null;
	static String reportmsg = null;
	static String value = null;

	public static void validation(WebElement validation_xpath) {
		try {
			String excelPath = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
			String excelSheetName = "Group_Tests";
			String testCaseId = "MTC-GT-002";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Group_Tests");

			for (int j = firstRow; j <= lastRow; j++) {
				XSSFRow row = sheet.getRow(j);
				value = (String) row.getCell(2).getStringCellValue();
				validation_ex = (String) row.getCell(3).getStringCellValue();
				reportmsg = (String) row.getCell(4).getStringCellValue();

				Thread.sleep(1000);
				grouptest.groupname.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
				grouptest.groupname.sendKeys(value);
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

			}
		} catch (Exception e) {

		}

	}
}
