//***********************************************************************************
//* Description
//*------------
//* Edit Equation Function In Accepted Condition
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0205		 	11/05/2023     Gobithan     Original Version
//* TC-TCN-0207			11/05/2023
//* TC-TCN-0209			11/05/2023
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
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditEquationFunctionInAcceptedCondition extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage manage = new ManageTestsPage();
	static TestConfigPage testnav = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();
	static ActionCommonMethod action = new ActionCommonMethod();
	static Logout logout = new Logout();

	@Test
	public static void action() throws IOException, InterruptedException
	{
		/* PROPERTYS METHOD */
		propertys();
		
		/* EDIT VALUE METHOD */
		editvalue();

		driver.navigate().refresh();
		
		/* LOGOUT */
		Logout.LogoutFunction();
	}
	
	public static void propertys() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, grouptest);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, testconfig);

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
		AddGroupKey.actionS(0, 11, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0205-01", 1);

		/* CONDITION EDIT BUTTON DISPLAYED & ENABLED */
		extent.createTest("STEP_05-- CONDITION EDIT BUTTON PROPERTIES");
		/* SELECT THE EDIT VALUE */
		ActionCommonMethod.actionS(0, 1, manage.acceptedcondition, "edit", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0205-01", 2);
	}

	static String editvalue = null;
	static String message = null;

	public static void editvalue() throws IOException, InterruptedException {
		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0205";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow);
		editvalue = (String) row.getCell(3).getStringCellValue();
		message = (String) row.getCell(4).getStringCellValue();

		manage.editconditiontxtarea.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		SampleCommonMethods.sendvalue("STEP_06-- EDIT CONDITION TEXT AREA PROPERTIES", manage.editconditiontxtarea,
				"01--EDIT CONDITION TEXTAREA IS DISPLAYED", "02--EDIT CONDITION TEXTAREA IS ENABLED", editvalue);

		SampleCommonMethods.singleclick("STEP_07-- ACCEPTED CONDITION UPDATE BUTTON PROPERTIES", manage.updatebtn,
				"01--UPDATE BUTTON DISPLAYED", "02--UPDATE BUTTON ENABLED");
		
		Thread.sleep(2000);
		SampleCommonMethods.dataaddedsuccessmsg("STEP_08-- EDIT DATA UPDATED SUCCESS FULLY", manage.successMsg,
				message);
		Thread.sleep(2000);
	}

}
