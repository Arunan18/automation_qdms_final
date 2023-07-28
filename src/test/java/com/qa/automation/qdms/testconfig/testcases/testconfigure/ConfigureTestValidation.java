//***********************************************************************************
//* Description
//*------------
//* CONFIGURE TEST VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0241			 01/05/2023   Gobithan     Orginal Version
//* TC-TCN-0001		     01/05/2023   Gobithan	   Test Button Function
//*****************************************************************************
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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ConfigureTestValidation extends DriverIntialization {
	static TestConfigPage testnav = new TestConfigPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				testnav.testleftnav, testnav.testparameterleftnav, testnav.testconfigleftnav,
				testnav.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", testnav.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", testnav.testconfigurationheading, "Configure Test",
				"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* VALIDATION TESTCASE */
		testCase = extent.createTest("STEP_04-- TEST CONFIG VALIDATION");

		/* TEST EMPTY VALIDATION */
		parametervalidation(0, testnav.testvalidation);

		/* TEST TYPE EMPTY VALIDATION */
		parametervalidation(1, testnav.testtypevalidation);

		/* PREFIX EMPTY VALIDATION */
		parametervalidation(2, testnav.prefixemptyvalidation);

		/* MATERIAL MAIN EMPTY VALIDATION */
		parametervalidation(3, testnav.materialmainvalidation);

		/* REPORT EMPTY VALIDATION */
		parametervalidation(4, testnav.reportvalidation);

		/* PREFIX SPECIAL CHRECTER VALIDATION */
		parametervalidation(5, testnav.prefixnumbervalidation);

		/* PREFIX SPACE VALIDATION */
		parametervalidation(6, testnav.prefixnumbervalidation);
		
		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}

	/* CHECK VALIDATION FOR TEST CONFIG */
	public static void parametervalidation(int rowline, WebElement validation_xpath)
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0241";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow + rowline);

		String test = (String) row.getCell(1).getStringCellValue();
		String testtype = (String) row.getCell(2).getStringCellValue();
		String prefix = (String) row.getCell(3).getStringCellValue();
		String maincaegory = (String) row.getCell(4).getStringCellValue();
		String reportformat = (String) row.getCell(5).getStringCellValue();
		String validationmsg = (String) row.getCell(6).getStringCellValue();
		String reportmsg = (String) row.getCell(7).getStringCellValue();

		Thread.sleep(2000);

		try {

			/* Select the drop down for Test Field */
			Actions actions = new Actions(driver);
			if (test != "") {
				boolean findthevalue = false;
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						testnav.testfield.click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//span[normalize-space()='" + test + "']")).click();

						findthevalue = true;
						break;

					} catch (Exception e) {
						actions.sendKeys(Keys.ARROW_DOWN).perform();
					}
				}
			}

			/* Select the drop down for Test Type Field */
			if (testtype != "") {
				boolean findthevalue = false;
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						testnav.testtype.click();
						driver.findElement(By.xpath("//div[@title='" + testtype + "']")).click();

						findthevalue = true;
						break;

					} catch (Exception e) {
						actions.sendKeys(Keys.ARROW_DOWN).perform();
					}
				}
			}

			testnav.prefix.sendKeys(prefix);

			/* Select the drop down for Main Category Field */
			if (maincaegory != "") {
				boolean findthevaluee = false;
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						testnav.maincategory.click();
						driver.findElement(By.xpath("//div[@title='" + maincaegory + "']")).click();

						findthevaluee = true;
						break;

					} catch (Exception e) {
						actions.sendKeys(Keys.ARROW_DOWN).perform();
					}
				}
			}

			/* Select the drop down for Report Field */
			if (reportformat != "") {
				boolean findthevaluee = false;
				for (int i = 0; i < 20; i++) {
					try {
						Thread.sleep(1000);
						testnav.reportfield.click();
						Thread.sleep(1000);
						driver.findElement(By.xpath("//div[@title='" + reportformat + "']")).click();

						findthevaluee = true;
						break;

					} catch (Exception e) {
						actions.sendKeys(Keys.ARROW_DOWN).perform();
					}
				}
			}

			testnav.submitbtn.click();
			Thread.sleep(1000);

			String ActualValidation = validation_xpath.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest(reportmsg);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		Thread.sleep(1000);
		/* REFERESH THE PAGE */
		driver.navigate().refresh();
	}

}
