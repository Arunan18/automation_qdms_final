//***********************************************************************************
//* Description
//*------------
//* MANAGE TEST Additional INFORMATION DELETE FUNCTION
//***********************************************************************************
//*
//* Author           : MATHUSAN 
//* Date Written     : 05/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0226		      05/05/2023    MATHUSAN     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

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

public class AdditionalInformationDeletefunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	static Logout LO = new Logout();

	@Test

	public static void AdditionalInformationDeletefunction() throws InterruptedException, IOException {

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

		// Click the Additional Information Icon
		Additionalinformation();

		// Click the Additional Information Screen Delete
		Additionalinformationscreendelete();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
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
						ManageTestsPage.additionalinformationheading.click();
						testCase = extent.createTest("ADDITIONAL INFORMATION HEADING FOUND");
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
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("EDIT CONFIGURE HEADING HEADING NOT FOUND");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}

	public static void Additionalinformation() {
		PageFactory.initElements(driver, ACM);

		/* SELECT THE EDIT TEST PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04--ADDITIONAL INFORMATION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 10, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0226-01", 1);

	}

	static Boolean okbuttonclick = false;
	static int beforesearch = 0;
	static int aftersearch = 0;
	static String Searchvalue1 = null;

	public static void Additionalinformationscreendelete() throws InterruptedException, IOException {

		/* CHECK THE DATA COUNT IN TABLE BEFORE SEARCH */

		Thread.sleep(1000);
		try {
			WebElement beforedata = ManageTestsPage.additionalinformationtablecontainer2searchdata;
			beforesearch = beforedata.findElements(By.cssSelector("tbody tr")).size();
			System.out.println("beforesearch" + beforesearch);
			System.out.println(beforesearch - 1);
			testCase = extent.createTest("CHECK THE DATA COUNT IN TABLE BEFORE SEARCH");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CHECK THE DATA COUNT IN TABLE BEFORE SEARCH");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// SEND THE DATA

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "TC-TCN-0226";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		DataFormatter gh = new DataFormatter();
		XSSFRow row = sheet.getRow(firstRow);
		XSSFCell cell = row.getCell(2);
		Searchvalue1 = gh.formatCellValue(cell);

		try {
			driver.findElement(By.xpath("//tbody//td[text()='" + Searchvalue1 + "']")).click();
			testCase = extent.createTest("CLICK ADDITIONAL INFORMATION DELETE BUTTON");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK ADDITIONAL INFORMATION DELETE  BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK ADDITIONAL INFORMATION DELETE OK BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		// Click the Delete ok Button

		Thread.sleep(2000);

		try {
			Boolean IsVisible1 = ManageTestsPage.additionalinformationdeletebutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Delete Button Visible", "true", IsVisible1, "definition");
			if (IsVisible1 == true) {

				Boolean IsEnabled1 = ManageTestsPage.additionalinformationdeletebutton.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Delete Button Visible", "true", IsEnabled1, "definition");

				if (IsEnabled1 == true) {

					ManageTestsPage.additionalinformationdeletebutton.click();
					testCase = extent.createTest("CLICK ADDITIONAL INFORMATION DELETE OK BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
					okbuttonclick = true;

				}

			}
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK ADDITIONAL INFORMATION DELETE OK BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK ADDITIONAL INFORMATION DELETE OK BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		if (okbuttonclick == true) {

			Thread.sleep(500);

			String Actualvalue = null;
			try {
				Actualvalue = ManageTestsPage.testrecordsucessfullymessage.getText();

				testCase = extent.createTest("TEST RECORD SUCESSFULL MESSAGE GET");
				testCase.log(Status.PASS, "TEST PASS");
			} catch (NoSuchElementException E) {
				testCase = extent.createTest("TEST RECORD SUCESSFULL MESSAGE NOT GET");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

			String Expecteddata = "Test Record Deleted Sucessfully";

			try {
				try {
					Assert.assertEquals(Actualvalue, Expecteddata);
				} catch (Exception e) {
					// TODO: handle exception
				}
				testCase = extent.createTest("Test Record Delete Successfully");
				testCase.log(Status.PASS, "Test Pass");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expecteddata);

			} catch (Exception e) {
				testCase = extent.createTest("Test Record Delete Not Successfully");
				testCase.log(Status.PASS, "Test Fail");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expecteddata);
			}

		}

		/* CHECK THE DATA COUNT IN TABLE AFTER SEARCH */
		Thread.sleep(1000);

		try {
			WebElement afterdata = ManageTestsPage.additionalinformationtablecontainer2searchdata;
			aftersearch = afterdata.findElements(By.cssSelector("tbody tr")).size();
			System.out.println("aftersearch" + aftersearch);
			System.out.println(aftersearch - 1);
			testCase = extent.createTest("CHECK THE DATA COUNT IN TABLE AFTER SEARCH");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CHECK THE DATA COUNT IN TABLE  AFTER SEARCH");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}