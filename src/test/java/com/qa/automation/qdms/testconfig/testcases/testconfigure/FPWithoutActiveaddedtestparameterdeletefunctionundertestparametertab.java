//***********************************************************************************
//* Description
//*------------
//* FPWithoutActiveaddedtestparameterdeletefunctionundertestparametertab
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 05/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0392           05/06/2023    Priyanka       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

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
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class FPWithoutActiveaddedtestparameterdeletefunctionundertestparametertab extends DriverIntialization {

	static String data = null;
	static String equation = null;
	static String message = null;
	static String datacount = null;

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	@Test
	public static void FPTestActiveWithKeyTest() throws IOException, InterruptedException {

		extent.createTest("TC-TCN-0392:FPWithoutActiveaddedtestparameterdeletefunctionundertestparametertab");

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", TestConfigPage.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				TestConfigPage.testleftnav, TestConfigPage.testparameterleftnav, TestConfigPage.testconfigleftnav,
				TestConfigPage.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", TestConfigPage.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", TestConfigPage.testconfigurationheading,
				"Configure Test", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0392-first");
		Thread.sleep(2000);

		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0392-secound");
		Thread.sleep(3000);

		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0392-secound");
		Thread.sleep(2000);

		TestConfigPage.previousbutton.click();

		Thread.sleep(2000);
		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0392-data";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			data = (String) row.getCell(1).getStringCellValue();
			message = (String) row.getCell(2).getStringCellValue();

			WebElement data1 = driver.findElement(By.xpath("(//table/tbody)[3]"));
			Thread.sleep(2000);
			extent.createTest("STEP:1");
			ActionCommonMethod.actionS(0, 10, data1, "delete", "Test Configuragtion Module.xlsx", "Test_Configure",
					"TC-TCN-0392-data-01", 1);

			TestConfigPage.DeletOkButtonEquation.click();

			/* DATA DELETED SUCCESS MESSAGE */
			SampleCommonMethods.dataaddedsuccessmsg("DATA DELETED SUCCESSFULLY", TestConfigPage.successMsg, message);

			/* TABLE DATA COUNT READUSED OR NOT */
			Object c = false;
			try {
				driver.findElement(By.xpath("td[text()='" + data + "']"));
				c = true;
			} catch (Exception e) {
				// TODO: handle exception
			}

			testCase = extent.createTest("ADD PARAMETER DELETE CONFIRMATION ");
			try {

				Assert.assertEquals(c, false);
				testCase.log(Status.INFO, "Actual Data :- " + c);
				testCase.log(Status.INFO, "Expected Data :- " + false);
				testCase.log(Status.PASS, "Correct, Data Count is Equal");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Data :- " + c);
				testCase.log(Status.INFO, "Expected Data :- " + true);
				testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");

			}

			// LOGOUT FUNCTION

			Logout.LogoutFunction();
		}
	}

}
