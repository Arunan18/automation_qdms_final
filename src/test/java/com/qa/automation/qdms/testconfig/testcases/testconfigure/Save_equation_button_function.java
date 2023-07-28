//***********************************************************************************
//* Description
//*------------
//* Save_equation_button_function
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 07/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0134          07/06/2023    Priyanka       Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class Save_equation_button_function extends DriverIntialization {

	static String expectedmessage = "";
	static String parameter = "";

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	@Test
	public static void FPTestActiveWithKeyTest() throws IOException, InterruptedException {

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",

				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", TestConfigPage.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				TestConfigPage.testleftnav, TestConfigPage.testparameterleftnav, TestConfigPage.testconfigleftnav,
				TestConfigPage.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", TestConfigPage.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", TestConfigPage.testconfigurationheading,
				"Configure Test", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0134-first");
		Thread.sleep(2000);

		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0134-secound");
		Thread.sleep(3000);

		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0134-secound");
		Thread.sleep(2000);

		// STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0134-third");
		Thread.sleep(300);

		String messages = TestConfigPage.successmessage.getText();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0134-data");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0134-data");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);

			expectedmessage = (String) row.getCell(1).getStringCellValue();

		}

		/* DATA ADDED SUCCESS MESSAGE */
		testCase = extent.createTest("EQUATION ADDED SUCESSFUTLLY");
		try {
			Assert.assertEquals(messages, expectedmessage);
			testCase.log(Status.INFO, "Actual Data :- " + messages);
			testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
			testCase.log(Status.PASS, "Message Enable");
		} catch (AssertionError e) {
			testCase.log(Status.INFO, "Actual Data :- " + messages);
			testCase.log(Status.INFO, "Expected Data :- " + expectedmessage);
			testCase.log(Status.FAIL, "Wrong Message Not Enable");
		}

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
