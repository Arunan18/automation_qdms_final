//***********************************************************************************
//* Description
//*------------
//* DELETE PARAMETER
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0057			 25/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testparameter;

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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class DeleteParameter extends DriverIntialization  {

	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestParameterPage testpage = new TestParameterPage();
	static ActionCommonMethod actioncomman = new ActionCommonMethod();
	static Logout logout = new Logout();
	
	static String value = "";
	static String message = "";
	static int datacount = 0;
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testpage);
		PageFactory.initElements(driver, actioncomman);
		
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
		
		/* DELETE SELECTED PRODUCTION SAMPLE PROPERTIES DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- TEST PARAMETER DELETE ICON PROPERTIES");
		ActionCommonMethod.actionS(0, 3, testpage.productionSampleTable, "delete", "Test Configuragtion Module.xlsx",
				"Test_Parameter", "TC-PAR-0057-01", 1);
		
		testpage.okbtn.click();
		
		/*Excel Sheet Value Passing*/	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0057";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");
			 
			XSSFRow row = sheet.getRow(firstRow);
			
				value = (String) row.getCell(1).getStringCellValue();
				message = (String) row.getCell(2).getStringCellValue();
				datacount = (int) row.getCell(3).getNumericCellValue();
		
	   /* DATA DELETED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_5-- DATA DELETED SUCCESSFULLY",testpage.successMsg, message);
			
	   /*TABLE DATA COUNT READUSED OR NOT */
		SampleCommonMethods.notequal("STEP_6-- DATA COUNT IN THE DATA TABLE", testpage.tablecount, String.valueOf(datacount));
		
		 
	   /*LOGOUT FROM FINISH PRODUCT TEST PARAMETER*/
	    logout.LogoutFunction();
	}
	
}
