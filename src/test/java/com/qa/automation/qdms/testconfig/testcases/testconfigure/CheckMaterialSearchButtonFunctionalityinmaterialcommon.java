
//***********************************************************************************
//* Description
//*------------
//* CHECK MATERIAL SEARCH BUTTON FUNCTION IN MATERIAL COMMON
//***********************************************************************************
//*
//* Author           : MATHUSAN 
//* Date Written     : 05/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0162		      05/05/2023    MATHUSAN     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
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

public class CheckMaterialSearchButtonFunctionalityinmaterialcommon extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	static Logout LO = new Logout();

	@Test

	public static void materialSearchTextBoxFunctionalityinmaterialcommon() throws InterruptedException, IOException {

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

		// Click Manage Test Configuration Scroll Page
		ManageTestConfigurationScrollPage();

		// Click Accepted Value Button
		AcceptedValue();

		// Take the Data for Excel
		TextBoxFunctionalityInputinmaterialcommon();

		// Click The Material Button
		MaterialButton();

		// Click the Refresh
		driver.navigate().refresh();

		// Click the Logout
		Logout.LogoutFunction();

	}

	// Click Manage Test Configuration Scroll Page

	public static void ManageTestConfigurationScrollPage() {

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
						TestConfigPage.acceptedvalueedit.click();
						testCase = extent.createTest("ACCEPTED VALUE HEADING FOUND");
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
			testCase = extent.createTest("ACCEPTED VALUE HEADING NOT MOVE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// Click Accepted Value Button

	public static void AcceptedValue() {

		/* SELECT THE EDIT TEST PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04--ACCEPTED VALUE  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0162-01", 1);

	}

	// Take the Data for Excel

	static String Accptedvaluevalidation = null;
	static String Accptedvaluevalidation1 = null;

	public static void TextBoxFunctionalityInputinmaterialcommon() throws IOException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0162";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow);

		Accptedvaluevalidation = (String) row.getCell(2).getStringCellValue();
		Accptedvaluevalidation1 = (String) row.getCell(3).getStringCellValue();

		/* SELECT THE DROP DOWN FOR PARAMETER TYPE FEILD */

		Actions actions = new Actions(driver);
		if (Accptedvaluevalidation != "") {
			boolean findthevalue = false;
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					TestConfigPage.individualdropdown.click();
					Thread.sleep(1000);
					System.err.println(" //div[contains(text(), '" + Accptedvaluevalidation + "')]");
					driver.findElement(By.xpath("//div[text()='" + Accptedvaluevalidation + "']")).click();
					testCase = extent.createTest("ACCEPTED PARAMETER DROPDOWN CLICK");
					testCase.log(Status.PASS, "TEST PASS");
					findthevalue = true;
					break;

				} catch (Exception e) {
					actions.sendKeys(Keys.ARROW_DOWN).perform();

				}
			}
		}

	}

	// Click The Material Button

	public static void MaterialButton() throws InterruptedException {

		PageFactory.initElements(driver, LO);

		PageFactory.initElements(driver, TCP);

		// CLICK THE MATERIAL BUTTON//

		try {
			Boolean isVisible1 = TestConfigPage.acceptedvaluematerialbuttonspan.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");
			if (isVisible1 == true) {

				Boolean isEnabled1 = TestConfigPage.acceptedvaluematerialbuttonspan.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

				if (isEnabled1 == true) {

					TestConfigPage.acceptedvaluematerialbuttoninput.click();
					testCase = extent.createTest("ACCEPTED VALUE MATERIAL BUTTON CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Click the Common Radio Button

		try {
			Boolean isVisible2 = TestConfigPage.acceptedvaluecommonbuttonspan.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible2, "definition");
			if (isVisible2 == true) {

				Boolean isEnabled2 = TestConfigPage.acceptedvaluecommonbuttonspan.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled2, "definition");

				if (isEnabled2 == true) {

					TestConfigPage.acceptedvaluecommonbuttoninput.click();
					testCase = extent.createTest("ACCEPTED VALUE COMMON BUTTON CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE COMMON RADIO BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE COMMON RADIO BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Click the Material Search Icon
		Thread.sleep(1000);

		try {
			Boolean isVisible3 = TestConfigPage.acceptedvaluematerialsearchicon.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Icon Visible", "true", isVisible3, "definition");
			if (isVisible3 == true) {
				Boolean isEnabled3 = TestConfigPage.acceptedvaluematerialsearchicon.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Icon Enable", "true", isEnabled3, "definition");

				if (isEnabled3 == true) {
					TestConfigPage.acceptedvaluematerialsearchicon.click();
					testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH ICON CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}
			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL SEARCH ICON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE MATERIAL SEARCH ICON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Click text box send the data

		Thread.sleep(1000);

		try {
			Boolean isVisible4 = TestConfigPage.MaterialTextBox.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Text Box Visible", "true", isVisible4, "definition");
			if (isVisible4 == true) {

				Boolean isEnabled4 = TestConfigPage.MaterialTextBox.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Text Box Enable", "true", isEnabled4, "definition");

				if (isEnabled4 == true) {

					/* SELECT THE TEXT BOX FOR PARAMETER TYPE FEILD */

					Thread.sleep(1000);
					TestConfigPage.MaterialTextBox.click();
					Thread.sleep(1000);
					TestConfigPage.MaterialTextBox.sendKeys(Accptedvaluevalidation1);
					testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH TEXTBOX CLICK");
					testCase.log(Status.PASS, "TEST PASS");
					testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH TEXTBOX SEND DATA ");
					testCase.log(Status.PASS, "TEST PASS");
				}
			}
		} catch (Exception e) {
			testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH TEXTBOX NOT CLICK");
			testCase.log(Status.FAIL, "TEST FAIL");
			testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH TEXTBOX NOT SEND DATA ");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Click the Search Button

		Thread.sleep(1000);

		try {
			Boolean isVisible5 = TestConfigPage.acceptedvaluematerialsearchbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Search Button Visible", "true", isVisible5, "definition");
			if (isVisible5 == true) {

				Boolean isEnabled5 = TestConfigPage.acceptedvaluematerialsearchbutton.isEnabled();
				PropertiesCommonMethods.TestReportsq("2.Search Button Enable", "true", isEnabled5, "definition");

				if (isEnabled5 == true) {

					TestConfigPage.acceptedvaluematerialsearchbutton.click();
					testCase = extent.createTest("ACCEPTED VALUE MATERIAL SEARCH  CLICK");
					testCase.log(Status.PASS, "TEST PASS");
				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE SEARCH BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK THE SEARCH BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
