//***********************************************************************************
//* Description
//*------------
//* Edit Equation Save Button Function
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 15/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0214	 		15/05/2023     Gobithan     Original Version
//* 
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationSaveButton extends DriverIntialization {

	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	
	@Test
	public static void action() throws InterruptedException, IOException
	{
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, manage);
		
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
				"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", manage.managetestconfigure,
				"Manage Tests Configure", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		
		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "//th[normalize-space()='Accepted Condition']");

		/* SELECT THE EQUATION BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EQUATION BUTTON PROPERTIES");

		/* SELECT THE EDIT VALUE */
		AddGroupKey.actionS(0, 9, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0214-01", 1);
		
		/* CONDITION EDIT BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_05-- CONFIGURE EQUATION EDIT BUTTON PROPERTIES");
		/* SELECT THE EDIT VALUE */
		ActionCommonMethod.actionS(0, 4, manage.configureequationcontainer, "edit", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0214-01", 2);
		
		/* EDIT VALUE */
		editvalue();
		
		/* LOGOUT */
		Logout.LogoutFunction();
		
	}
	
	static String editvalue = null;
	static String message = null;

	public static void editvalue() throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0214";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow);
		editvalue = (String) row.getCell(3).getStringCellValue();
		message = (String) row.getCell(4).getStringCellValue();

		testnav.Textboxequation.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		SampleCommonMethods.sendvalue("STEP_06-- EDIT EQUATION TEXT BOX PROPERTIES", testnav.Textboxequation,
				"01--EDIT TEXTBOX IS DISPLAYED", "02--EDIT TEXTBOX IS ENABLED", editvalue);

		SampleCommonMethods.singleclick("STEP_07-- EDIT EQUATION SAVE BUTTON PROPERTIES", testnav.savebtnn,
				"01--SAVE BUTTON DISPLAYED", "02--SAVE BUTTON ENABLED");

		SampleCommonMethods.dataaddedsuccessmsg("STEP_08-- EDIT DATA UPDATED SUCCESS MESSAGE", manage.successMsg,
				message);

	}
	
}
