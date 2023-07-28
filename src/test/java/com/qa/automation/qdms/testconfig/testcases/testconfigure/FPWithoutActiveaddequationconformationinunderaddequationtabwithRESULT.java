//***********************************************************************************
//* Description
//*------------
//* FPWithoutActiveaddequationconformationinunderaddequationtabwithRESULT
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0388            01/06/2023    Priyanka       Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class FPWithoutActiveaddequationconformationinunderaddequationtabwithRESULT extends DriverIntialization {

	static String parameter = null;
	static String equation = null;

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	@Test
	public static void FPTestActiveWithKeyTest() throws IOException, InterruptedException {

		extent.createTest("TC-TCN-0388:FPWithoutActiveaddequationconformationinunderaddequationtabwithRESULT");

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				testnav.testleftnav, testnav.testparameterleftnav, testnav.testconfigleftnav,
				testnav.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", testnav.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", testnav.testconfigurationheading, "Configure Test",
				"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0388-first");
		Thread.sleep(2000);
		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0388-secound");
		Thread.sleep(3000);

		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0388-secound");
		Thread.sleep(2000);

		// STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0388-third");
		Thread.sleep(3000);

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0388-third";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		for (int i = firstRow; i <= lastRow; i++) {

			XSSFRow row = sheet.getRow(i);

			parameter = (String) row.getCell(2).getStringCellValue();
			equation = (String) row.getCell(3).getStringCellValue();

			System.out.println(parameter);
			System.out.println(equation);

			String data1 = driver.findElement(By.xpath("(//table)[2]//tr[2]//td[1]")).getText();
			String data2 = driver.findElement(By.xpath("(//table)[2]//tr[2]//td[2]")).getText();

			System.out.println(data1);
			System.out.println(data2);

			testCase = extent.createTest("ADD EQUATION CONFIRMATION");

			try {

				Assert.assertEquals(data1 + "," + data2, parameter + "," + equation);
				testCase.log(Status.INFO, "Actual Data :- " + data1 + "," + data2);
				testCase.log(Status.INFO, "Expected Data :- " + parameter + "," + equation);
				testCase.log(Status.PASS, "Correct, Data Count is Equal");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Data :- " + data1 + "," + data2);
				testCase.log(Status.INFO, "Expected Data :- " + parameter + "," + equation);
				testCase.log(Status.FAIL, "Wrong, Data Count is Not Equal");

			}
		}
	}
}
