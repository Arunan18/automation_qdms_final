//***********************************************************************************
//* Description
//*------------
//* edit equation validation-manage test
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 4/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0138            4/05/2023      Niluxy          Original Version
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantFieldSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationValidation extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static AddGroupKey groupKey = new AddGroupKey();
	static ManageTestsPage manage = new ManageTestsPage();
	static String tobeedit = null;
	static String parameter = null;
	static String expectedmessage = null;
	static String validationmsg = null;
	static String testcase = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupKey);
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		// CLICK ON THE TEST CONFIGURATION CARD
		action.clicking(page.testconfigurationcard, 20, "STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG

		action.clicking(page.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		action.clicking(page.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Equation']")).click();
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
		// CHOOSE THE EQUATION DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 9, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-051-01", 1);
		// CLICK ON THE EDUATION EDIT ICON
		Thread.sleep(1000);
		action.clicking(page.Editquation_managetest, 20, "STEP 3:CHECKING THE EDITEQUATIONICON");

		Thread.sleep(2000);
		// CLICK ON THE EDUATION EDIT ICON
		action.clicking(page.ConfigureEquationedit, 20, "STEP 4:CHECKING THE CONFIQUREEQUATION");

		validation(TestConfigPage.belowvalidationeditfind, 0);
		validation(TestConfigPage.belowvalidationeditfind, 1);
		validation(TestConfigPage.belowvalidationeditfind, 2);
		validation(TestConfigPage.abovevalidationeditfinddefault, 3);
		validation(TestConfigPage.abovevalidationeditfinddefault, 4);

		Thread.sleep(2000);
		TestConfigPage.cancelbuttoninequationedit.click();
		Thread.sleep(2000);
		TestConfigPage.cancelbuttoninequationconfigure.click();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	static String validation_ex = null;
	static String reportmsg = null;
	static int j = 0;

	public static void validation(WebElement validation_xpath, int j) throws InterruptedException {
		try {

			String excelPath = System.getProperty("user.dir")
					+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
			String excelSheetName = "Test_Configure";
			String testCaseId = "TC-TCN-0138";

			int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
			int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

			FileInputStream file = new FileInputStream(excelPath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Test_Configure");

			XSSFRow row = sheet.getRow(firstRow + j);
			tobeedit = (String) row.getCell(1).getStringCellValue();
			System.out.println("tobeedit" + tobeedit);
			String parameter = (String) row.getCell(2).getStringCellValue();
			System.out.println("parameter" + parameter);

			validation_ex = (String) row.getCell(3).getStringCellValue();
			reportmsg = (String) row.getCell(4).getStringCellValue();

			TestConfigPage.Textboxequation.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
			TestConfigPage.Textboxequation.sendKeys(String.valueOf(parameter));

			TestConfigPage.EquationEditSaveButton.click();
			Thread.sleep(1000);

			String ActualValidation = validation_xpath.getText();

			String ExpectedValidation = validation_ex;
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
	}
}
