
//***********************************************************************************
//* Description
//*------------
//* AddGroupinTestConfig_UnderTheTestParameterTab
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 06/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0383           06/06/2023     Niluxy       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddGroupinTestConfig_UnderTheTestParameterTab extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestConfigNavigation config = new TestConfigNavigation();

	static String test = null;
	static String groupkey = null;

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		extent.createTest("TC-TCN-0383:AddGroupinTestConfig_UnderTheTestParameterTab");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURATION CARD");
		Thread.sleep(2000);

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);
		
		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);
		
		// ADD THE CONFIGURE TEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0383-first");
		Thread.sleep(4000);

		// CHECK ADD GROUP KEY BUTTON ADD THE TEST PARAMETERS
		Thread.sleep(1000);
		AddGroupKey.groupKey("Test Configuragtion Module", "Test_Configure", "TC-TCN-0383-second");

		// DOWN THE PAGE
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	
		// SELECT THE DATA FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0383-second");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0383-second");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			test = (String) row.getCell(1).getStringCellValue();
			groupkey = (String) row.getCell(2).getStringCellValue();

		}
		/* CHECK FIRST DATA OF THE TABLE */
        Thread.sleep(2000);
		firstrowdata("DATA ADDED IN FIRST ROW", TestConfigPage.tablefirstcloum, TestConfigPage.tableSecondcloum,
		test,groupkey);

		 //LOGOUT TO THE SYSTEM
		 Logout.LogoutFunction();

	}		

// METHOD FOR CHECKING THE DATA ADDED FIRST IN THE TABLE */

	public static void firstrowdata(String test_case, WebElement firstdata_xpath, WebElement seconddata_xpath,
			String firstexpecteddata, String secondexpecteddata) {
		String actualdata = firstdata_xpath.getText();
		String actualseconddata = seconddata_xpath.getText();
		boolean data = false;
		testCase = extent.createTest(test_case);
		if (actualdata.equals(firstexpecteddata)  && actualseconddata.equals(secondexpecteddata)) {
			data = true;
		}

		if (data) {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + firstexpecteddata);
			testCase.log(Status.PASS, "Correct last data added in first row");

			testCase.log(Status.INFO, "Actual Data :- " + actualseconddata);
			testCase.log(Status.INFO, "Expected Data :- " + secondexpecteddata);
			testCase.log(Status.PASS, "Correct last data added in first row");
		} else {
			testCase.log(Status.INFO, "Actual Data :- " + actualdata);
			testCase.log(Status.INFO, "Expected Data :- " + firstexpecteddata);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");

			testCase.log(Status.INFO, "Actual Data :- " + actualseconddata);
			testCase.log(Status.INFO, "Expected Data :- " + secondexpecteddata);
			testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
		}
	}

}
