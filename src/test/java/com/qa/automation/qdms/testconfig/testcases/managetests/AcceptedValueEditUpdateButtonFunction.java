//***********************************************************************************
//* Description
//*------------
//* ACCEPTED VALUE EDIT UPDATE BUTTON  FUNCTION -MANAGE TEST CONFIGURE
//EDIT UPDATE BUTTON FUCNTION- MTC-MT-068
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-068              16/05/2023  Niluxy    Orginal Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AcceptedValueEditUpdateButtonFunction extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static SampleCommonMethods common = new SampleCommonMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	static String expectedmessage = null;
	static String tobeedit = null;
	static String condition = null;
	static String tobeeditnumber = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, common);
		PageFactory.initElements(driver, groupkey);

		extent.createTest("TESTCASEN0:TC-MT-068-ACCEPETED VALUE EDIT UPDATE BUTTON FUNCTION");

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		action.clicking(TestConfigPage.testconfigurationcard, 2000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		action.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// SCROLLING THE PAGE
		Thread.sleep(2000);
		AcceptedValueIconFunction.scroll();

		// CHOOSE THE ACCEPTED VALUE DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 8, manage.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-068-01", 1);

		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", manage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--EQUATION ICON ENABLED", manage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-068");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-068");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			tobeedit = (String) row.getCell(2).getStringCellValue();
			condition = (String) row.getCell(3).getStringCellValue();
			tobeeditnumber = (String) row.getCell(4).getStringCellValue();
			expectedmessage = (String) row.getCell(5).getStringCellValue();
		}

		// CHOOSE THE ACCEPTED VALUE EDIT DATA FROM EXCEL
		Thread.sleep(3000);
		ActionCommonMethod.actionS(0, 4, manage.acceptedvalueContainer, "edit", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-068-01", 2);

		/* ACCEPTED VALUE EDIT ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 5: ACCEPTED VALUE EDIT ICON PROPERTIES", manage.acceptedvalueEditIcon,
				"01--ACCEPTED VALUE EDIT ICON DISPLAYED", "02--ACCEPTED VALUE EDIT ICON ENABLED",
				manage.acceptedvalueinsideEditHeading, "Edit Accepted Value",
				"03--ON CLICK THE ACCEPTED VALUE EDIT ICON IT'S REDERECT TO CORRECT WINDOW");

		// CHOOSE THE CONDITION
		Thread.sleep(2000);
//		SampleCommonMethods.fieldmethoddropdown("STEP 6:CONDITION TYPE FIELD", ManageTestsPage.conditionfield,
//				"01-- CONDITION TYPE FIELD DISPLAYED", "02-- CONDITION TYPE FIELD ENABLED",
//				"//span[@title='" + condition + "']", "03-- DATA SUCCESSFULLY SELECTED");

		// SEND AND EDIT THE VALUE FROM EXCEL
		ManageTestsPage.acceptedvalueinsideNumberTextbox.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.sendvalue("STEP 7: EDIT ACCEPTED VALUE TEXT BOX PROPERTIES",
				ManageTestsPage.acceptedvalueinsideNumberTextbox, "01--EDIT ACCEPTED VALUE TEXTBOX IS DISPLAYED",
				"02--EDIT ACCEPTED VALUE TEXTBOX IS ENABLED", tobeeditnumber);

		// CHECK THE UPDATE BUTTON
		SampleCommonMethods.singleclick("STEP 8: EDIT ACCEPTED VALUE UPDATE BUTTON PROPERTIES",
				ManageTestsPage.acceptedvalueinsideUpdatebutton, "01--UPDATE BUTTON DISPLAYED",
				"02--UPDATE BUTTON ENABLED");

		// CHECK THE EDIT UPDATION FUCNTION
		SampleCommonMethods.dataaddedsuccessmsg("STEP 9: EDIT DATA UPDATED SUCCESS MESSAGE", manage.successMsg,
				expectedmessage);

		// REFRESH THE PAGE
		Thread.sleep(2000);
		driver.navigate().refresh();
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
