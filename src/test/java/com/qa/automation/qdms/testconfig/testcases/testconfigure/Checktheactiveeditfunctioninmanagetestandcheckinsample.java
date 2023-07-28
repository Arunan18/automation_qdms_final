//***********************************************************************************
//* Description
//*------------
//* Check_the_active_editfunction_in_managetest
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 06/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0390          06/06/2023    Priyanka       Original Version
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class Checktheactiveeditfunctioninmanagetestandcheckinsample extends DriverIntialization {

	static String data = null;
	static String accepted = null;
	static Boolean click = null;

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();

	@Test
	public static void TestMangeEditActive() throws IOException, InterruptedException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, action);

		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0390-data";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			data = (String) row.getCell(1).getStringCellValue();
			click = (boolean) row.getCell(2).getBooleanCellValue();

			driver.findElement(By.xpath("//td[contains(text(),'" + data
					+ "')]/following-sibling::td//span[contains(@class,'anticon-edit')]")).click();
			Thread.sleep(3000);
			Boolean active = driver.findElement(By.xpath("//input[@id = 'activeTest']")).isSelected();

			if (click == true) {

				if (active == false) {

					Thread.sleep(3000);

					driver.findElement(By.xpath("//input[@id = 'activeTest']/..")).click();
					Thread.sleep(3000);

					ManageTestsPage.updatebtn.click();

				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("//td[contains(text(),'" + data
						+ "')]/following-sibling::td//span[contains(@class,'anticon-edit')]")).click();

				Object actual = driver.findElement(By.xpath("//input[@id = 'activeTest']")).isSelected();

				Thread.sleep(3000);

				ManageTestsPage.cancelbtn.click();
				try {
					testCase = extent.createTest("ACTIVE FIELD UPDATED SUCCESSFULLY");
					Assert.assertEquals(actual, true);
					testCase.log(Status.INFO, "Actual Data :- " + true);
					testCase.log(Status.INFO, "Expected Data :- " + actual);
					testCase.log(Status.PASS, "Correct, Data Count is Equal");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Data :- " + true);
					testCase.log(Status.INFO, "Expected Data :- " + actual);
					testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");

				}

			}

			else if (click == false) {
				if (active == true) {

					driver.findElement(By.xpath("//input[@id = 'activeTest']")).click();
					ManageTestsPage.updatebtn.click();
				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("//td[contains(text(),'" + data
						+ "')]/following-sibling::td//span[contains(@class,'anticon-edit')]")).click();

				Object actual = driver.findElement(By.xpath("//input[@id = 'activeTest']")).isSelected();

				Thread.sleep(3000);
				ManageTestsPage.cancelbtn.click();
				try {
					testCase = extent.createTest("ACTIVE FIELD UPDATED SUCCESSFULLY");
					Assert.assertEquals(actual, true);
					testCase.log(Status.INFO, "Actual Data :- " + true);
					testCase.log(Status.INFO, "Expected Data :- " + actual);
					testCase.log(Status.PASS, "Correct, Data Count is Equal");
				} catch (AssertionError e) {
					testCase.log(Status.INFO, "Actual Data :- " + true);
					testCase.log(Status.INFO, "Expected Data :- " + actual);
					testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");

				}
			}

		}

		Thread.sleep(3000);

		// Scroll up by a page
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(3000);

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "//table//thead//th[16]");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//td[contains(text(),'" + data + "')]/following-sibling::td[14]//span")).click();

		Thread.sleep(3000);
		Object activcheckbox = driver.findElement(By.xpath("//input[@id='active']")).isSelected();

		try {
			testCase = extent.createTest("ACTIVE FIELD UPDATED SUCCESSFULLY");
			Assert.assertEquals(activcheckbox, click);
			testCase.log(Status.INFO, "Actual Data :- " + click);
			testCase.log(Status.INFO, "Expected Data :- " + activcheckbox);
			testCase.log(Status.PASS, "Correct, Data Count is Equal");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + click);
			testCase.log(Status.INFO, "Expected Data :- " + activcheckbox);
			testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");

		}

		// LOGOUT FUNCTION

		Logout.LogoutFunction();

	}
}
