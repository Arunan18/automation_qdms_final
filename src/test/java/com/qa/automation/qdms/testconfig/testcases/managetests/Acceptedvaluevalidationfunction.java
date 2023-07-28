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
//* MTC-MT-070			 19/05/2023    MATHUSAN     Original Version
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class Acceptedvaluevalidationfunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();

	@Test

	public static void AcceptedvalueupdateFuntion() throws InterruptedException, IOException {

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

		// Click the Select Accepted Value
		SelectAcceptedValue();

		// Click the Data for Excel
		EditAcceptedValue();

		// Click Refresh Button
		driver.navigate().refresh();

		// Click Logout Button
		Logout.LogoutFunction();
	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() {
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]"))
				.click();
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[11]")).click();
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
		}

	}

	// Click the Select Accepted Value

	public static void SelectAcceptedValue() throws InterruptedException {

		PageFactory.initElements(driver, ACM);

		// SELECT THE ACCEPTED VALUE TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-070-01", 1);

	}

	// Click the Data for Excel

	static String Accptedvaluevalidation = null;
	static boolean selectparameter = false;
	static String Actualvalue = null;
	static String Expectedvalue = null;

	public static void EditAcceptedValue() throws IOException, InterruptedException {

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-070";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		testCase = extent.createTest("Step-05--ACCPTED VALUE VALIDATION");
		for (int i = firstRow; i <= lastRow; i++) {
			DataFormatter gh = new DataFormatter();
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(2);
			Accptedvaluevalidation = gh.formatCellValue(cell);

		}

		// Click the Select Test Parameter
		Boolean isVisible1 = driver.findElement(By.xpath("//input[@id='parameter']")).isDisplayed();
		PropertiesCommonMethods.TestReportsq("1.Button Visible", "true", isVisible1, "definition");

		if (isVisible1 == true) {

			Boolean isEnabled1 = driver.findElement(By.xpath("//input[@id='parameter']")).isEnabled();
			PropertiesCommonMethods.TestReportsq("2.Button Enable", "true", isEnabled1, "definition");

			if (isEnabled1 == true) {

				driver.findElement(By.xpath("//input[@id='parameter']")).click();
				selectparameter = true;

			}

		}

		if (selectparameter = true) {
			driver.findElement(By.xpath("//input[@id='parameter']")).sendKeys(Accptedvaluevalidation);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary sc-gZMcBi jVssxC']")).click();
			Actualvalue = driver
					.findElement(
							By.xpath("(//div[text()='Accepted Value']/../..//div[@class='input_wrapper']/div[2])[1]"))
					.getText();
			Expectedvalue = "Parameter can't be empty";

			try {

				Assert.assertEquals(Actualvalue, Expectedvalue);
				testCase = extent.createTest("Parameter can't be empty");
				testCase.log(Status.PASS, "Test Pass");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

			} catch (Exception e) {
				testCase = extent.createTest("Parameter can't be empty not Visible");
				testCase.log(Status.PASS, "Test Fail");
				testCase.log(Status.INFO, "Actualvalue:" + Actualvalue);
				testCase.log(Status.INFO, "Expecteddata:" + Expectedvalue);

			}

		}
	}

}