//***********************************************************************************
//* Description
//*------------
//* TestActiveStatusShoudbeCheckInSample
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 09/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0389           09/06/2023    Priyanka       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestActiveStatusShoudbeCheckInSample extends DriverIntialization {

	static String data = null;
	static String accepted = null;
	static Boolean click = null;
	static String testtype = null;
	static String type = null;
	static String sampletype = null;
	static String actions = null;

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static IncomingSamplePage incsamplepage = new IncomingSamplePage();
	static PlantLabTrailSamplePage plantlabpage = new PlantLabTrailSamplePage();

	@Test
	public static void TestMangeEditActive() throws IOException, InterruptedException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, incsamplepage);
		PageFactory.initElements(driver, plantlabpage);

		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest, TestConfigPage.managetest,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* MANAGE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0389-data";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			data = (String) row.getCell(1).getStringCellValue();
			click = (boolean) row.getCell(2).getBooleanCellValue();
			testtype = (String) row.getCell(3).getStringCellValue();
			sampletype = (String) row.getCell(4).getStringCellValue();

			ActionCommonMethod.actionS(0, 16, ManageTestsPage.managetexttablecontainer, "edit",
					"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0389-data-01", 1);

			type = driver.findElement(By.xpath("//td[contains(text(),'" + data + "')]/following-sibling::td[5]"))
					.getText();

			Thread.sleep(3000);
			Boolean active = driver.findElement(By.xpath("//input[@id = 'activeTest']")).isSelected();

			if (click != active) {

				Thread.sleep(3000);

				driver.findElement(By.xpath("//input[@id = 'activeTest']/..")).click();
				Thread.sleep(3000);

				ManageTestsPage.updatebtn.click();

				Thread.sleep(3000);
				ActionCommonMethod.actionS(0, 16, ManageTestsPage.managetexttablecontainer, "edit",
						"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0389-data-01", 1);

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

			} else {
				ManageTestsPage.cancelbtn.click();
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

		Thread.sleep(2000);

		if (type.equals("RAW_MATERIAL")) {

			Thread.sleep(2000);

			SampleActionMethods.clicking(ManageTestsPage.tcgLogo, 3, "LOGO CLICKED SUCCESFULLY");

			SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

			SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 2,
					"STEP 2 - CHECKING RAW MATERIAL MENU");

			try {

				if (sampletype.equals("Incoming Sample")) {

					SampleNavigationPage.incommingSampleXpath().click();

				} else {
					SampleNavigationPage.inprocessSampleXpath().click();
				}

				ActionCommonMethod.actionS(0, 18, IncomingSamplePage.IncSamTableContainer, "Test Status",
						"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0389-data-01", 5);
			} catch (Exception e) {

			}

		} else if (type.equals("FINISH_PRODUCT")) {

			SampleActionMethods.clicking(ManageTestsPage.tcgLogo, 2, "LOGO CLICKED SUCCESFULLY");

			SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

			SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 2,
					"STEP 2 - CHECKING FINISH PRODUCT MENU");

			try {
				if (sampletype.equals("Plant-Lab Trial Sample")) {

					SampleNavigationPage.labTrialSampleXpath().click();

				} else {
					SampleNavigationPage.productionSampleXpath().click();
				}
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			ActionCommonMethod.actionS(3, 7, PlantLabTrailSamplePage.tableContainer, "Test Status",
					"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0389-data-01", 5);

		}

		List<WebElement> bb = driver.findElements(By.xpath("(//div[@class='ant-ribbon-wrapper'])"));
		int count = bb.size();

		for (int i = 1; i <= count; i++) {

			String actualdat = driver.findElement(By.xpath("//div[@class='ant-ribbon-wrapper'][" + i + "]/div/div/li"))
					.getText();
			String expect = actualdat.trim();

			Thread.sleep(1000);
			if (data.equals(expect)) {

				String inactive = driver.findElement(By.xpath("(//li[contains(text(),'* Test is InActive')])[1]"))
						.getText();
				System.out.println("INNACTIVE *****" + inactive);
				if (inactive.equals("")) {

					testCase = extent.createTest("TEST CARD IS ACTIVE");
					try {

						Assert.assertEquals(expect, data);
						testCase.log(Status.INFO, "Actual Validation :- " + expect);
						testCase.log(Status.INFO, "Expected Validation :- " + data);
						testCase.log(Status.PASS, "Pass");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Validation :- " + expect);
						testCase.log(Status.INFO, "Expected Validation :- " + data);
						testCase.log(Status.FAIL, "Fail");
					}
				} else if (inactive != "") {

					testCase = extent.createTest("TEST CARD IS INACTIVE");
					try {

						Assert.assertEquals(inactive, "* Test is InActive");
						testCase.log(Status.INFO, "Actual Validation :- " + inactive);
						testCase.log(Status.INFO, "Expected Validation :- " + "* Test is InActive");
						testCase.log(Status.PASS, "Pass");
					} catch (AssertionError e) {
						testCase.log(Status.INFO, "Actual Validation :- " + inactive);
						testCase.log(Status.INFO, "Expected Validation :- " + "* Test is InActive");
						testCase.log(Status.FAIL, "Fail");
					}

				}
				break;

			} else {

				testCase = extent.createTest("TEST IS INACTIVE BECAUSE TEST IN NEW STATUS..  ");

			}

		}

		driver.navigate().refresh();

		// LOGOUT FUNCTION

		Logout.LogoutFunction();

	}

}
