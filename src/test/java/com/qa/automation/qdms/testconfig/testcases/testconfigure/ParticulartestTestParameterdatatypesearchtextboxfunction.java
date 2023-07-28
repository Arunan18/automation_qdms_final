
//***********************************************************************************
//* Description
//*------------
//* ParticularTest Test Parameter data type search textbox function 
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     :23/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0100			 23/05/2023    MATHUSAN     Original Version
//* 
//************************************************************************************


package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ParticulartestTestParameterdatatypesearchtextboxfunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static TestConfigPage addPage = new TestConfigPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();

	@Test

	public static void TestParameterdatatypesearchtextboxfunction() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);

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

		// Click the Edit Configure
		EditConfigure();

		// Click the TestParameter
		testparameter();

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
						ManageTestsPage.editconfigureheading.click();
						testCase = extent.createTest("EDIT CONFIGURE HEADING FOUND");
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
		}  catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("EDIT CONFIGURE HEADING HEADING NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}


	}

	// Click the Select Equation

	public static void EditConfigure() throws InterruptedException {

		PageFactory.initElements(driver, ACM);
		Thread.sleep(3000);

		// SELECT THE EDIT CONFIGURE TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 14, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0100-01", 1);

	}

	static String SearchValue1 = null;

	// Click the TestParameter
	public static void testparameter() throws IOException, InterruptedException {

		try {
			Boolean isVisible1 = ManageTestsPage.testparametericon.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = ManageTestsPage.testparametericon.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					ManageTestsPage.testparametericon.click();
					testCase = extent.createTest("TEST PARAMETER CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}

			} 
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("TEST PARAMETER NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("TEST PARAMETER NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		
		
		try {
			// Click the Parameter Icon
			Boolean isVisible2 = ManageTestsPage.testparametericonbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Icon Visible", "true", isVisible2, "definition");
			if (isVisible2 == true) {

				Boolean isEnabled2 = ManageTestsPage.testparametericonbutton.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Icon Enable", "true", isEnabled2, "definition");

				if (isEnabled2 == true) {

					ManageTestsPage.testparametericonbutton.click();
					testCase = extent.createTest("TEST PARAMETER ICON BUTTON CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}
			} 
		}  catch (NoSuchElementException E) {
			testCase = extent.createTest("TEST PARAMETER ICON BUTTON NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("TEST PARAMETER ICON BUTTON NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		
		
		// Send the Data
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0100";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		testCase = extent.createTest("Step-05--ACCPTED VALUE VALIDATION");
		for (int i = firstRow; i <= lastRow; i++) {
			DataFormatter gh = new DataFormatter();
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(2);
			SearchValue1 = gh.formatCellValue(cell);

		}
		
		try {
			//Text box Function
			Boolean isVisible3 = ManageTestsPage.testparametertextboxfunction.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Text Box Visible", "true", isVisible3, "definition");
			if (isVisible3 == true) {

				Boolean isEnabled3 = ManageTestsPage.testparametertextboxfunction.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Text Box Enable", "true", isEnabled3, "definition");

				if (isEnabled3 == true) {

					ManageTestsPage.testparametertextboxfunction.click();

					Thread.sleep(1000);

					ManageTestsPage.testparametertextboxfunction.sendKeys(SearchValue1);

				}
			} 
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("TEST PARAMETER ICON TEXTBOX NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("TEST PARAMETER ICON TEXTBOX NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
