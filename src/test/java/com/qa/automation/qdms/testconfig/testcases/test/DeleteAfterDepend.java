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
//* TC-Test-0041     26/04/2023   Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.DeleteFunctionMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class DeleteAfterDepend extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ActionCommonMethod common = new ActionCommonMethod();

	static String tobedeleteDepend = "";
	public static String datacountDepend = "";
	public static String messageDepend = "";

	@Test
	public static void Delete() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, common);

		extent.createTest("TC-Test-0041-Should not be able to delete Test after depended ( Material)");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);

		// CLICK THE TEST CONFIGURATION MODULE
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000, "STEP 1:CHECK THE TESTCONFIGRATION");

		// CLICK THE TEST HEADER MODULE
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 1000, "STEP 2:CHECK THE TEST MODULE");

		// CLICK THE TEST MODULE
		SampleActionMethods.clicking(TestConfigPage.testleftnav, 1000, "STEP 3:CHECK THE TEST SUB MODULE");

		/* DELETE SELECTED PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP 4: TEST DELETE ICON");
		ActionCommonMethod.actionS(0, 1, TestConfigPage.tableContainer, "delete", "Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0041-01", 1);

		// CLICK OK BUTTON IN DELETE MODEL
		action.clicking(TestConfigPage.deleteButton, 200, "STEP 5:CHECK THE DELETE OK BUTTON");
		Thread.sleep(2000);

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0041");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test", "TC-Test-0041");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			String tobedeleteDepend = (String) row.getCell(1).getStringCellValue();
			messageDepend = (String) row.getCell(2).getStringCellValue();
			datacountDepend = (String) row.getCell(3).getStringCellValue();

		}

		/* CHECKING THE DATA DELETED SUCCESS MESSAGE COMES OR NOT */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 6:CHECK THE DATA DELETED OR NOT", TestConfigPage.successMsg,
				messageDepend);

		/* CHECKING THE TABLE DATA COUNT CHANGE OR NOT */
		Thread.sleep(2000);
		SampleCommonMethods.equalpass("STEP 7: CHECK THE DATA COUNT IN THE DATA TABLE", TestConfigPage.tablecount,
				String.valueOf(datacountDepend));

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}
