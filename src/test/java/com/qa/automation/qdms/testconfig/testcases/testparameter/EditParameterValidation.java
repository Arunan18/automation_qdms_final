//***********************************************************************************
//* Description
//*------------
//* EDIT PARAMETER VALIDATION
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0052			 27/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class EditParameterValidation extends DriverIntialization {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestParameterPage testpage = new TestParameterPage();
	static Logout logout = new Logout();
	
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testpage);
		PageFactory.initElements(driver, logout);
		
		/* LOGIN */
		LoginTest.Login();
		
		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED",
				"02--TEST TOP NAVIGATION BUTTON ENABLED", testnav.testleftnav,
				testnav.testparameterleftnav,testnav.testconfigleftnav,testnav.configgrouptestleftnav,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
		/* TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST PARAMETER PROPERTIES", testnav.testparameterleftnav,
				"01--TEST PARAMETER LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST PARAMETER LEFT NAVIGATION BUTTON ENABLED", testpage.testparameterheadding,"Parameter",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		/* SELECT THE EDIT TEST PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- TEST PARAMETER EDIT ICON PROPERTIES");
		ActionCommonMethod.actionS(0, 3, testpage.productionSampleTable, "edit", "Test Configuragtion Module.xlsx",
				"Test_Parameter", "TC-PAR-0052-01", 1);
		
		/* EDIT PARAMETER VALIDATION */
		validation();
		
		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}
	
	public static void validation() throws IOException, InterruptedException
	{
		
		/* Add Parameter Validation */

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0052";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");
		extent.createTest("STEP_05-- TEST PARAMETER EDIT VALIDATION");
		for (int j = firstRow; j <= lastRow; j++) 
		{
		XSSFRow row = sheet.getRow(j);
		
		String parameter = (String) row.getCell(2).getStringCellValue();
		String validationmsg = (String) row.getCell(3).getStringCellValue();
		String testcase = (String) row.getCell(4).getStringCellValue();

		Thread.sleep(2000);
		try {
			
			testpage.parameterteatarea.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
			testpage.parameterteatarea.sendKeys(String.valueOf(parameter));
			              
			testpage.savebutton.click();
			Thread.sleep(1000);

			String ActualValidation = testpage.parametervalidation.getText();

			String ExpectedValidation = validationmsg;
			testCase = extent.createTest(testcase);
			try {
				Assert.assertEquals(ActualValidation, ExpectedValidation);
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.PASS, "Pass");
			} catch (AssertionError e) {
				testCase.log(Status.INFO, "Actual Validation :- " + ActualValidation);
				testCase.log(Status.INFO, "Expected Validation :- " + ExpectedValidation);
				testCase.log(Status.FAIL, "Fail").assignCategory("Low Priority");
				testCase.log(Status.FAIL, "Fail").assignCategory("High Priority");
			}
		} catch (Exception e) {

		}
		
		}
		testpage.cancelbutton.click();
	}
	
}
