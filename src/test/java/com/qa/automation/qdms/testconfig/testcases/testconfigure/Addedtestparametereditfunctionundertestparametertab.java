//***********************************************************************************
//* Description
//*------------
//* Added_testparameter_editfunction_under_testparameter_tab
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 07/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0391          07/06/2023    Priyanka       Original Version
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

public class Addedtestparametereditfunctionundertestparametertab extends DriverIntialization {

	static String parameter = null;
	static String type = null;
	static String unit = null;
	static String abriviation = null;
	static String inputmethods = null;
	static Boolean releventValue = false;
	static String decimaltype = null;
	static String tobeedit = "";
	static String expectedmessage = "";

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();
	static ReviewTestParameterCancelEditFunction relevent = new ReviewTestParameterCancelEditFunction();

	@Test
	public static void FPTestActiveWithKeyTest() throws IOException, InterruptedException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", TestConfigPage.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				TestConfigPage.testleftnav, TestConfigPage.testparameterleftnav, TestConfigPage.testconfigleftnav,
				TestConfigPage.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", TestConfigPage.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", TestConfigPage.testconfigurationheading, "Configure Test",
				"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0391-first");
		Thread.sleep(2000);

		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0391-secound");
		Thread.sleep(3000);

		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0391-secound");
		Thread.sleep(2000);

		TestConfigPage.previousbutton.click();
		Thread.sleep(2000);

		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0391-data");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0391-data");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeedit = (String) row.getCell(1).getStringCellValue();
			parameter = (String) row.getCell(2).getStringCellValue();
			type = (String) row.getCell(3).getStringCellValue();
			unit = (String) row.getCell(4).getStringCellValue();
			abriviation = (String) row.getCell(5).getStringCellValue();
			inputmethods = (String) row.getCell(6).getStringCellValue();
			decimaltype = (String) row.getCell(7).getStringCellValue();
			expectedmessage = (String) row.getCell(8).getStringCellValue();
			releventValue = (Boolean) row.getCell(9).getBooleanCellValue();
		}

		// FIND THE EDIT ELEMENT FROM THE EXCEL
		Thread.sleep(3000);

		try {
			WebElement edit = driver.findElement(By.xpath("//td[text()='" + tobeedit + "  "
					+ "']//following-sibling::td[10]//span[@class='anticon anticon-edit']"));
			if (edit.isDisplayed()) {
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

		/* EDIT PARAMETER FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		SampleCommonMethods.fieldmethoddropdown("STEP_8-- PARAMETER  FIELD PROPERTYS",
				TestConfigPage.parametertextboxreviewtest, "01-- PARAMETER FIELD DISPLAYED",
				"02-- PARAMETER  FIELD ENABLED", "//span[normalize-space()='" + parameter + "']",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethoddropdown("STEP_9--  TYPE FIELD PROPERTYS", TestConfigPage.typetextboxreviewtest,
				"01--  TYPE FIELD DISPLAYED", "02--  TYPE FIELD ENABLED", "//div[contains(@title,'" + type + "')]",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR UNIT TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		SampleCommonMethods.fieldmethoddropdown("STEP_10-- UNIT FIELD PROPERTYS", TestConfigPage.unittextboxreviewtest,
				"01-- UNIT FIELD DISPLAYED", "02-- UNIT FIELD ENABLED", "//div[contains(text(),'" + unit + "')]",
				"03-- DATA SUCCESSFULLY SELECTED");

		/* EDIT FOR ABBRIVIATION FIELD DISPLAYED & ENABLED & SELECTED */

		TestConfigPage.abbriviationtextboxreviewtest.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP_11-- ABBRIVIATION FIELD PROPERTYS",
				TestConfigPage.abbriviationtextboxreviewtest, "01-- ABBRIVIATION FIELD FIELD DISPLAYED",
				"02-- ABBRIVIATION FIELD ENABLED", abriviation);

		/* EDIT INPUT METHODS */
		SampleCommonMethods.fieldmethoddropdown("STEP_12-- INPUT METHODS FIELD PROPERTYS",
				TestConfigPage.inputmethodtextboxreviewtest, "01-- INPUT METHODS FIELD DISPLAYED",
				"02-- INPUT METHODS FIELD ENABLED", "//div[@title='" + inputmethods + "']",
				"03-- DATA SUCCESSFULLY SELECTED");

		// CLICK RELEVENT CHECKBOX ICON
		relevent.releventcheckbox();

		/* EDIT FOR DECIMAL TYPE FIELD DISPLAYED & ENABLED & SELECTED */
		Thread.sleep(2000);
		TestConfigPage.decimaaltextboxreviewtest.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		SampleCommonMethods.sendvalue("STEP_14-- DECIMAL TYPE FIELD PROPERTYS",
				TestConfigPage.decimaaltextboxreviewtest, "01-- DECIMAL TYPE FIELD DISPLAYED",
				"02-- DECIMAL TYPE FIELD ENABLED", decimaltype);

		// CLICK UPDATE BUTTON IN MANAGE TEST
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.updatebuttonreviewtest, 20, "STEP 15:CHECKING THE UPDATE BUTTON ICON ");

		/* DATA ADDED SUCCESS MESSAGE */
		Thread.sleep(2000);
		SampleCommonMethods.dataaddedsuccessmsg("STEP_16-- DATA UPDATED SUCCESSFULLY", TestConfigPage.successMsg,
				expectedmessage);

		// CLOSE THE WINDOW
		TestConfigPage.closebuttonreviewtest.click();

		/* CHECK FIRST DATA OF THE TABLE */
		Thread.sleep(1000);
		SampleCommonMethods.firstrowdata("STEP 17: EDITED DATA ADDED IN FIRST ROW", TestConfigPage.tablefirstrow,
				parameter);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
