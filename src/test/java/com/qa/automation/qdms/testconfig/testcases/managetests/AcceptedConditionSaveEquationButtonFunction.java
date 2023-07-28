//***********************************************************************************
//* Description
//*------------
//* * Accepted Condition save equation button function
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 25/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-095            25/05/2023    Niluxy       Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

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
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AcceptedConditionSaveEquationButtonFunction extends DriverIntialization {
	static TestParameterPage Test = new TestParameterPage();
	static TestConfigPage testpage = new TestConfigPage();
	static SampleCommonMethods Samcommon = new SampleCommonMethods();
	static ManageTestsPage Manangepage = new ManageTestsPage();
	static ActionCommonMethod Actioncommon = new ActionCommonMethod();
	static AddGroupKey groupkey = new AddGroupKey();
	static String addValue = null;
	static String expectedmessage = null;

	@Test

	public static void TestAddvalueDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, Actioncommon);
		PageFactory.initElements(driver, testpage);
		PageFactory.initElements(driver, Samcommon);
		PageFactory.initElements(driver, Manangepage);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// SCROLL THE PAGE
		managetestconfigurationscorallpage();

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-095-01", 1);

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Manage_Tests");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-095");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-095");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			addValue = (String) row.getCell(2).getStringCellValue();
			System.out.println("addValue" + addValue);
			expectedmessage = (String) row.getCell(3).getStringCellValue();
			System.out.println("expectedmsg" + expectedmessage);
		}

		SampleCommonMethods.sendvalue("STEP 5:  ACCEPTED CONDITION EQUATION TEXT BOX PROPERTIES",
				ManageTestsPage.acceptedconditioneqautiontextarea,
				"01-- ACCEPTED CONDITION EQUATIONR TEXTBOX IS DISPLAYED",
				"02-- ACCEPTED CONDITION EQUATION TEXTBOX IS ENABLED", addValue);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// CHECK THE SAVE BUTTON
		SampleCommonMethods.singleclick("STEP 6:  ACCEPTED CONDITION SAVE BUTTON PROPERTIES",
				ManageTestsPage.saveequationbutton, "01--SAVE BUTTON DISPLAYED", "02--SAVE BUTTON ENABLED");

		// CHECK THE EDIT UPDATION FUCNTION
		SampleCommonMethods.dataaddedsuccessmsg("STEP 7: DATA SAVED SUCCESS MESSAGE", ManageTestsPage.successMsg,
				expectedmessage);

		// CLICK REFRESH BUTTON
		Thread.sleep(2000);
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// method for Click the Manage Configure Scroll Page
	public static void managetestconfigurationscorallpage() {
		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/table/tbody/tr[2]/td[3]"))
				.click();
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("(//th[@class='ant-table-cell'])[11]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}

	}

}
