//***********************************************************************************
//* Description
//*------------
//* ACCEPTED VALUE SAVE BUTTON  FUNCTION -MANAGE TEST CONFIGURE
// MTC-MT-060
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 25/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-060              25/05/2023    Niluxy          Original Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AcceptedValueSaveButtonFunction extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static SampleCommonMethods common = new SampleCommonMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	static String expectedmessage = null;
	static String addValue = null;
	static String tobeeditnumber = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, common);
		PageFactory.initElements(driver, groupkey);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		extent.createTest("TESTCASEN0:TC-MT-060-ACCEPETED VALUE SAVE BUTTON FUNCTION");

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// SCROLLING THE PAGE
		Thread.sleep(2000);
		AcceptedValueIconFunction.scroll();

		// CHOOSE THE ACCEPTED VALUE DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-060-01", 1);

		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", ManageTestsPage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--EQUATION ICON ENABLED", ManageTestsPage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-060");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-060");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			addValue = (String) row.getCell(2).getStringCellValue();
			System.out.println("addValue" + addValue);
			expectedmessage = (String) row.getCell(3).getStringCellValue();
			System.out.println("expectedmsg" + expectedmessage);
		}

		Thread.sleep(2000);
		// CLICK ON THE PARAMETER DROPDOWN BUTTON
		SampleActionMethods.clicking(ManageTestsPage.acceptedvalueparameterdropdowntextbox, 2000,
				"STEP 5:CHECKING THE PARAMETER TEXTBOX");
		// CHOOSE THE VALUE
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();

		// CHECK THE SAVE BUTTON
		SampleCommonMethods.singleclick("STEP 6: EDIT ACCEPTED VALUE SAVE BUTTON PROPERTIES",
				ManageTestsPage.acceptedvalueSaveButton, "01--SAVE BUTTON DISPLAYED", "02--SAVE BUTTON ENABLED");

		// CHECK THE EDIT UPDATION FUCNTION
		SampleCommonMethods.dataaddedsuccessmsg("STEP 7: EDIT DATA SAVED SUCCESS MESSAGE", ManageTestsPage.successMsg,
				expectedmessage);

		// CLICK ON THE CLOSE ICON
		Thread.sleep(3000);
		SampleActionMethods.clicking(ManageTestsPage.EditkeytestClose, 20, "STEP 8:CHECKING THE CLOSE ICON");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
