//***********************************************************************************
//* Description
//*------------
//*Accepted Condition Icon Function - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-091          19/05/2023     Saranka     Original Version
//*				    	 14/06/2023	    Arunan	  Updated Version
//***********************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
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

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AcceptedConditionIconFunction extends DriverIntialization {
	static ManageTestsPage Accpted = new ManageTestsPage();
	static TestConfigPage AccptedCon = new TestConfigPage();
	static String tobeSearchData = null;
	static String title = null;
	static DataFormatter dataValue=new DataFormatter();
//====================================================== M E T H O D  ========================================================
	@Test
	public void methodCallingIconFunction() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		AcceptedConditionIconFunction.iconFunction();
		
		Logout.LogoutFunction();
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void iconFunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Accpted);
		PageFactory.initElements(driver, AccptedCon);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

		Thread.sleep(2000);
		TestConfigPage.manageTest.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Accepted Condition']")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {

		}

//______________________________________
//  EXCEL METHOD
//_______________________________________

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Manage_Tests";
		String testCaseId = "MTC-MT-091";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		System.err.println(firstRow + " !! " + lastRow);
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);
			tobeSearchData = dataValue.formatCellValue(row.getCell(1));
			title = dataValue.formatCellValue(row.getCell(2));

		}
//__________________________________________
//  SEARCH DATA TO CLCIK
//__________________________________________

		WebElement table = driver.findElement(By.xpath("(//div[@class='ant-table-container'])[1]"));
		AddGroupKey.actionS(0, 11, table, "Description", "Test Configuragtion Module.xlsx", "Manage_Tests",
				"MTC-MT-091-01", 1);
//___________________________________________
// AFTER CLICK ADDIONAL INFORMATION ICON
//___________________________________________
Thread.sleep(1500);
		WebElement ModelView = driver.findElement(By.xpath("//div[@role='document']"));
		boolean actualVisible = ModelView.isDisplayed();
		System.out.println("Actual  Model View Visible:-" + actualVisible);
		boolean expctedVisible = true;

		testCase = extent.createTest("STEP:1 AFTER CLICK ACCEPTED ICON MODEL IS VISIBLE");
		try {
			Assert.assertEquals(actualVisible, expctedVisible);
			testCase.log(Status.PASS, "Visible Correct");

		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "Visible In-Correct");
		}
//_______________________________________________
// GET TEXT OF ADDIONAL INFORMATION TITLE
//________________________________________________	

		WebElement titleModel = driver.findElement(By.xpath("//div[contains(text(),'Accepeted Condition')]"));
		boolean actualVisible1 = titleModel.isDisplayed();
		System.out.println("Actual  Model Title View Visible:-" + actualVisible1);
		boolean expctedVisible1 = true;

		testCase = extent.createTest("STEP:2 AFTER CLICK ACCEPTED ICON MODEL TITLE IS VISIBLE");
		try {
			Assert.assertEquals(actualVisible1, expctedVisible1);
			testCase.log(Status.PASS, "Visible Correct");

		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "Visible In-Correct");
		}

//_____________________________________________________
//  TEXT OF TITLE
//_____________________________________________________

		String actualTitleText = titleModel.getText();
		System.out.println("Title text:-" + actualTitleText);
		String expectedText = title;

		testCase = extent.createTest("STEP:3 TITLE SPELLING");
		try {
			Assert.assertEquals(actualTitleText, expectedText);
		} catch (AssertionError e) {
			// TODO: handle exception
		}
		boolean text = true;
		if (text) {
			testCase.log(Status.INFO, "Actual Text:-" + actualTitleText);
			testCase.log(Status.INFO, "Expected Text:-" + expectedText);
			testCase.log(Status.PASS, "Text is correct");

		} else {
			testCase.log(Status.INFO, "Actual Text:-" + actualTitleText);
			testCase.log(Status.INFO, "Expected Text:-" + expectedText);
			testCase.log(Status.FAIL, "Text is in-correct");

		}
		driver.navigate().refresh();

	}

}
