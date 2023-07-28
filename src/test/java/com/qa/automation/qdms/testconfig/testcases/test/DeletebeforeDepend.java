
//***********************************************************************************
//* Description
//*------------
//* DELETE FUNCTIONALITY-TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//* TC-Test-0037       26/04/2023   Niluxy       Orginal Version
//* 
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class DeletebeforeDepend extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ActionCommonMethod common = new ActionCommonMethod();
	static SampleCommonMethods succmsg = new SampleCommonMethods();

	static String tobedelete = "";
	public static String datacount = "";
	public static String message = "";

	@Test
	public static void Delete() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, common);
		PageFactory.initElements(driver, succmsg);
		extent.createTest("TC-Test-0037-Check Delete Test Functionality (Delete Function");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);

		// CLICK THE TEST CONFIGURATION MODULE
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000, "STEP 1:CHECK THE TESTCONFIGRATION");

		// CLICK THE TEST HEADER MODULE
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 1000, "STEP 2:CHECK THE TEST MODULE");

		// CLICK THE TEST SUB MODULE
		SampleActionMethods.clicking(TestConfigPage.testleftnav, 1000, "STEP 3:CHECK THE TEST SUB MODULE");

		// DELETE SELECTED PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP 4: TEST DELETE ICON");
		ActionCommonMethod.actionS(0, 1, TestConfigPage.tableContainer, "delete", "Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0037-01", 1);

		// CLICK OK BUTTON IN DELETE
		action.clicking(TestConfigPage.deleteButton, 200, "STEP_05:CHECK THE DELETE OK BUTTON");
		Thread.sleep(2000);

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0037");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0037");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			String tobedelete = (String) row.getCell(1).getStringCellValue();
			message = (String) row.getCell(2).getStringCellValue();
			datacount = (String) row.getCell(3).getStringCellValue();
		}
		/* CHECKING THE DATA DELETED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 6:CHECK THE DATA IS DELETED", TestConfigPage.successMsg, message);

		/* CHECKING THE TABLE DATA COUNT CHANGED OR NOT */
		SampleCommonMethods.notequal("STEP 7: CHECK THE DATA COUNT IN THE DATA TABLE", TestConfigPage.tablecount,
				String.valueOf(datacount));

		// SEARCH THE DATA HAS DELETED OR NOT
		deleteDataConfirm();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

//METHOD FOR DELETE CONFIRMATION
	public static void deleteDataConfirm() throws InterruptedException, IOException {

		String data = TestConfigNavigation.excel("Test Configuragtion Module", "Test", "TC-Test-0037", 1);

		TestConfigPage.SearchTestIcon.click();
		Thread.sleep(2000);
		TestConfigPage.SearchTestTextBox.sendKeys(data);
		TestConfigPage.SearchTestTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		TestConfigPage.SearchTestSearchbutton.click();
		Thread.sleep(3000);
		String ActualData = TestConfigPage.SearchTestTextBox.getAttribute("value");
		String ExpectedData = TestConfigNavigation.excel("Test Configuragtion Module", "Test", "TC-Test-0037", 4);

		testCase = extent.createTest("STEP 08:CHECK THE DELETE FUNCTION");
		AssertJUnit.assertNotSame(ActualData, ExpectedData);
		try {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "Expectedvalue :- " + ExpectedData);
			testCase.log(Status.INFO, "CORRECT,THE VALUE IS NOT THERE IN THE TABLE");
			testCase.log(Status.PASS, ActualData);
		} catch (Exception e) {
			testCase.log(Status.INFO, "Actualvalue :- " + ActualData);
			testCase.log(Status.INFO, "ExpectedValue :- " + ExpectedData);
			testCase.log(Status.INFO, "WRONG,THE VALUE IS STILL THERE IN THE TABLE");
			testCase.log(Status.FAIL, ActualData);

		}

	}

}
