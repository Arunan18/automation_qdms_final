//***********************************************************************************
//* Description
//*------------
//*  Accepted value update function
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     :19/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-096			 19/05/2023    MATHUSAN     Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AcceptedConditionvalidationfunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	 static AddGroupKey AGK =new AddGroupKey();
	@Test

	public static void AcceptedConditionvalidation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ACM);

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// Click the Manage Configure Scorall Page
		managetestconfigurationscorallpage();

		// Click the Select Accepted Condition
		SelectAcceptedCondition();

		// Give the Data Excel
		testCase = extent.createTest("Step-05--ACCPTED VALUE VALIDATION");
		dataforexcel("//*[text()='Add Condition']/../../..//p", 0);
		dataforexcel("//*[text()='Add Condition']/../../..//p", 1);
		dataforexcel("//*[text()='Add Condition']/../../../div[2]/div[2]", 2);

		// Click Refresh Button
		driver.navigate().refresh();

		// Click Logout Button
		Logout.LogoutFunction();

	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() throws InterruptedException {
		try {
			TestConfigPage.managetestcongigurescrollpage.click();
			testCase = extent.createTest("CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						ManageTestsPage.acceptconditionheading.click();
						testCase = extent.createTest("ACCEPT CONDITION HEADING FOUND");
						testCase.log(Status.PASS, "TEST PASS");
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2000);
				} else {
					break;
				}

			}
		}catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("ACCEPT CONDITION HEADING NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// Click the Select Accepted Condition

	public static void SelectAcceptedCondition() throws InterruptedException {

		PageFactory.initElements(driver, AGK);

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-096-01", 1);

		// Click the Accepted Condition Input box
		Thread.sleep(2000);
		try {
			Boolean isVisible1 = ManageTestsPage.acceptconditioninputbox.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.acceptconditioninputbox.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.acceptedconditioninputbox.click();
					testCase = extent.createTest("CLICK ACCEPT CONDITION INPUTBOX");
					testCase.log(Status.PASS, "TEST PASS");
				}
			} 
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK ACCEPT CONDITION INPUTBOX");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK ACCEPT CONDITION INPUTBOX");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

     //Get the  Data For Excel

	static String Accptedvaluevalidation = null;
	static String Actualvalue = null;
	static String Expectedvalue = null;

	static String Accptedvaluevalidation1 = null;
	static String validationmsg = null;
	static String reportmsg = null;

	public static void dataforexcel(String validation_xpath, int ronum) throws InterruptedException, IOException {
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-096";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		DataFormatter gh = new DataFormatter();
		XSSFRow row = sheet.getRow(firstRow + ronum);
		XSSFCell cell = row.getCell(2);
		XSSFCell cell1 = row.getCell(3);
		XSSFCell cell2 = row.getCell(4);
		Accptedvaluevalidation = gh.formatCellValue(cell);
		validationmsg = gh.formatCellValue(cell1);
		reportmsg = gh.formatCellValue(cell2);

		try {
			ManageTestsPage.acceptedconditioninputbox.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			Thread.sleep(1000);
			ManageTestsPage.acceptedconditioninputbox.sendKeys(Accptedvaluevalidation);
			testCase = extent.createTest("ACCPTED VALUE VALIDATION");
			testCase.log(Status.PASS, "TEST PASS");
			
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT ACCPTED VALUE VALIDATION");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		// Click the Save Equation
		
		try {
			Boolean isVisible2 = ManageTestsPage.acceptconditionsaveequationbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible2, "definition");
			if (isVisible2 == true) {

				Boolean isEnabled2 = ManageTestsPage.acceptconditionsaveequationbutton.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled2, "definition");

				if (isEnabled2 == true) {

					ManageTestsPage.acceptconditionsaveequationbutton.click();
					testCase = extent.createTest("CLICK ACCEPT CONDITION SAVE EQUATION BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
				}
			} 
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK ACCEPT CONDITION SAVE EQUATION BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK ACCEPT CONDITION SAVE EQUATION BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	
		
		

		Thread.sleep(1000);
		try {
			// Compare The Actual & Expected value
			Actualvalue = driver.findElement(By.xpath(validation_xpath)).getText();
			testCase = extent.createTest("GET TEXT THE ACTUAL VALUE");
			testCase.log(Status.PASS, "TEST PASS");
		}catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT GET TEXT THE ACTUAL VALUE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		Expectedvalue = validationmsg;

		try {

			Assert.assertEquals(Actualvalue, Expectedvalue);
			testCase = extent.createTest(reportmsg);
			testCase.log(Status.PASS, "Test Pass");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

		} catch (Exception e) {
			testCase = extent.createTest(reportmsg + " not Visible");
			testCase.log(Status.PASS, "Test Fail");
			testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
			testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

		}

	}

}