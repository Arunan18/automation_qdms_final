
//***********************************************************************************
//* Description
//*------------
//*KEY TEST ICON SAVE BUTTON FUNCTION -MANAGE TEST CONFIGURE

//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 15/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-049             15/05/2023    Niluxy        Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

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
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class KeyTestSaveButtonFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static AddGroupKey groupkey = new AddGroupKey();
	static String expectedmessage = null;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, actions);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupkey);

		extent.createTest("TESTCASEN0:MTC-MT-049-KEY TEST SAVE BUTTON FUNCTION");

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHOOSE THE KEY TEST DATA FROM EXCEL
		AddGroupKey.actionS(0, 1, ManageTestsPage.managetexttablecontainer, "Description",
			"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-049-01", 1);

		/* KEY TEST ICON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP 4:KEY TEST ICON PROPERTIES", ManageTestsPage.keytesticon,
				"01--KEY TEST ICON DISPLAYED", "02--KEY TEST ICON ENABLED", ManageTestsPage.Editkeytestheading,
				"Edit Key Test", "03--ON CLICK THE KEY TEST ICONIT'S REDERECT TO CORRECT WINDOW");

		// SELECTING THE CHECKBOX
		SampleActionMethods.clicking(ManageTestsPage.EditkeytestCheckbox, 2, "STEP 5:SELECTING THE CHECKBOX");

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-049");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-049");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			expectedmessage = (String) row.getCell(2).getStringCellValue();
			System.out.println("expectedmessage" + expectedmessage);

		}

		// CHECK THE SAVE BUTTON
		Thread.sleep(5000);
		SampleActionMethods.clicking(ManageTestsPage.EditkeytestSavebutton, 20, "STEP 6:SELECTING THE SAVE BUTTON");

		/* DATA ADDED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 7: DATA UPDATED SUCCESSFULLY", TestConfigPage.successMsg,
				expectedmessage);

		// CHECK THE CLOSE BUTTON
		Thread.sleep(4000);
		SampleActionMethods.clicking(ManageTestsPage.EditkeytestClose, 20, "STEP 8:CHECK THE CLOSE BUTTON");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}