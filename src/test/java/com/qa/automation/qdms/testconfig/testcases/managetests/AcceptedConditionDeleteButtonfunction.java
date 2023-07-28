//***********************************************************************************
//* Description
//*------------
//* Manage Test Accepted value Delete Function
//***********************************************************************************
//*
//* Author           : Mathusan 
//* Date Written     :17/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-097			 17/05/2023    Mathusan     Original Version
//* MTC-MT-099
//* MTC-MT-100
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

public class AcceptedConditionDeleteButtonfunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	 static AddGroupKey AGK =new AddGroupKey();
	static String Accptedvaluevalidation = null;

	@Test

	public static void TestAddvalueDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

		PageFactory.initElements(driver, ACM);

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

		// Get a Success Dialogue Message
		Thread.sleep(1000);

		Successdailoguemessage();

		// Click the Refresh
		Thread.sleep(1000);
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() {
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

						ManageTestsPage.acceptedconditionheading.click();
						testCase = extent.createTest("ACCEPTED CONDITON HEADING FOUND");
						testCase.log(Status.PASS, "TEST PASS");

						pass = true;
					} catch (Exception e) {

					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
			testCase = extent.createTest("ACCEPTED CONDITON HEADING NOT MOVE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	// Click the Select Accepted Condition

	public static void SelectAcceptedCondition() throws InterruptedException {
		PageFactory.initElements(driver, AGK);

		PageFactory.initElements(driver, ACM);

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-097-01", 1);

		// SELECT THE ACCEPTED VALUE DELETE TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_05-- ACCEPTED CONDITION  DELETE  BUTTON FUNCTION");
		ActionCommonMethod.actionS(0, 1, ManageTestsPage.acceptedconditiontablecontainer4, "delete",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-097-01", 2);

		// Click the Delete ok Button

		Thread.sleep(2000);

		try {
			Boolean IsVisible1 = ManageTestsPage.acceptedconditiondeleteokbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Delete Button Visible", "true", IsVisible1, "definition");
			if (IsVisible1 == true) {

				Boolean IsEnabled1 = ManageTestsPage.acceptedconditiondeleteokbutton.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Delete Button Visible", "true", IsEnabled1, "definition");

				if (IsEnabled1 == true) {

					ManageTestsPage.acceptedconditiondeleteokbutton.click();
					testCase = extent.createTest("CLICK THE DELETE OK BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE DELETE OK BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE DELETE OK BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	public static void Successdailoguemessage() throws InterruptedException, IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-097";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		for (int i = firstRow; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);

			Accptedvaluevalidation = (String) row.getCell(3).getStringCellValue();

			SampleCommonMethods.dataaddedsuccessmsg("Check the OK Button Massage", ManageTestsPage.CantDeletethismodule,
					Accptedvaluevalidation);

		}

	}

}