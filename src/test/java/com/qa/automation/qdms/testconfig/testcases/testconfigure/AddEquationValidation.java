//***********************************************************************************
//* Description
//*------------
//* Add Equation Validation
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 05/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0133		 	05/05/2023     Gobithan     Original Version
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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddEquationValidation extends DriverIntialization {
	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static SampleCommonMethods sample = new SampleCommonMethods();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, mangetest);

		/* LOGIN */
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES",
				testnav.ManageCofigureMenuBar, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,
				"Manage Tests Configure", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		/* SELECT THE VALUE */
		AddGroupKey.actionS(0, 14, mangetest.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0133-01", 1);

		/* CLICK THE ACCEPTED CRITERIA FORM */
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'ant-steps-item-icon')])[3]")).click();

		/* WINDOW REFRESH */
		driver.navigate().refresh();

		// EQUATION VALIDATION
		extent.createTest("STEP_05-- ADD EQUATION VALIDATION");
		equationinvalid();
		driver.navigate().refresh();

		/* EMPTY VALIDATION FOR EQUIPMENT TYPE FIELD */
		parametervalidation(testnav.equipmenttypevalidation, 2);

		/* EMPTY VALIDATION FOR TEST PARAMETER FIELD */
		parametervalidation(testnav.testparametervalidation, 3);

		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}

	static String dropdown = null;
	/* VALIDATION METHOD */
	public static void parametervalidation(WebElement validation_Xpath, int rowval)
			throws InterruptedException, IOException {
		/* Add Equipment Validation */

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0133";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow + rowval);

		String validationmsg = (String) row.getCell(2).getStringCellValue();
		String reportmsg = (String) row.getCell(3).getStringCellValue();
		String dropdown = (String) row.getCell(4).getStringCellValue();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		testnav.eqsavebtn.click();
		Thread.sleep(1000);

		String ActualValidation = validation_Xpath.getText();

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
	}

	public static void equationinvalid() throws InterruptedException, IOException {
		SampleCommonMethods.singleclick("STEP-06-- RADIO BUTTON PROPERTYS", testnav.resultradiobtn,
				"01--RESULT RADIO BUTTON IS DISPLAYED", "02--RESULT RADIO BUTTON IS ENABLED");

		/* Select the drop down for Test Parameter Type Field */
		if (dropdown != "") {
			Actions actionss = new Actions(driver);
			boolean findthevaluee = false;
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
					String dropdown = driver
							.findElement(By.xpath(
									"//body/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]"))
							.getText();

					if (dropdown.equals(dropdown)) {
						driver.findElement(By.xpath(
								"//body/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]"))
								.click();
					}
					findthevaluee = true;
					break;

				} catch (Exception e) {
					actionss.sendKeys(Keys.ARROW_DOWN).perform();
				}
			}
		}
		driver.findElement(By.xpath("//textarea[@class='ant-input equation_playground textEmph']")).sendKeys("++");

		parametervalidation(testnav.equationvalidation, 1);
	}
}
