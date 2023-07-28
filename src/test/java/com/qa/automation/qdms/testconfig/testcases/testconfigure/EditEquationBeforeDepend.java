//***********************************************************************************
//* Description
//*------------
//* Edit Equipment Before Depend
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 04/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0136		 	04/05/2023   Gobithan     Orginal Version
//* TC-TCN-0139			04/05/2023
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
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

public class EditEquationBeforeDepend extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static ManageTestsPage manage = new ManageTestsPage();
	static TestConfigPage testnav = new TestConfigPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, manage);

		// LOGIN
		LoginTest.Login();

		// TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES",
				testnav.ManageCofigureMenuBar, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW");
		Thread.sleep(1000);

		// PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[1]", "(//span[@aria-label='check'])[1]");

		// SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");

		// SELECT THE VALUE
		AddGroupKey.actionS(0, 14, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0136-01", 1);
Thread.sleep(1500);
		// CLICK THE CONFIGURE EQUATION FORM
		TestConfigPage.configureequation.click();

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		/* SELECT THE EDIT VALUE IN POPUP WINDOW */
		Thread.sleep(1000);
		extent.createTest("STEP_05-- EQUATION BUTTON POPUP WINDOW EDIT BUTTON PROPERTIES");
		ActionCommonMethod.actionS(0, 3, testnav.equipmenttablecontainer, "edit", "Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0136-01", 2);

		/* EDIT EQUIPMENT */
		editequipment();

		/* BEFORE DEPENT EDIT SUCCESS MESSAGE */
		message();

		/* LOGOUT TO THE SYSTEM */
		Thread.sleep(2000);
		Logout.LogoutFunction();
	}

	public static void editequipment() throws IOException {
		/* Excel Sheet Value Passing */

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0136";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		XSSFRow row = sheet.getRow(firstRow);

		String edit = (String) row.getCell(3).getStringCellValue();

		manage.EditEquipment.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SampleCommonMethods.fieldmethodselect("STEP_06-- EDIT EQUIPMENT FIELD PROPERTIES", manage.EditEquipment,
				"01--EDIT EQUIPMENT FIELD IS DISPLAYED", "02--EDIT EQUIPMENT FIELD IS ENABLED", edit,
				"03--DATA EDITED IN EQUIPMENT FIELD");

	}

	/* BEFOR EDIT SUCCESS MESSAGE */
	static boolean savebtn = false;

	public static void message() throws InterruptedException {
		try {
			Thread.sleep(1000);
			testnav.updatebtn.click();
			savebtn = true;
		} catch (Exception e) {

		}

		if (savebtn == true) {
			extent.createTest("STEP_06-- EDIT EQUATION DEPEND MESSAGE");
			try {
				if (driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[2]/div[1]/div[2]")).isDisplayed()
						&& testnav.testdependValidationmsg.isDisplayed()) {
					testCase = extent.createTest("01--EDIT EQUATION IS DEPEND");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} catch (Exception e) {
				testCase = extent.createTest("01--EDIT EQUATION VALUE IS NOT DEPEND");
				testCase.log(Status.PASS, "TEST PASS");
			}
		}
	}

}
