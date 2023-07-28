//***********************************************************************************
//* Description
//*------------
//* ADD PARAMETER
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0043			 25/04/2023   Gobithan     Orginal Version
//* 
//*****************************************************************************
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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AddParameter extends DriverIntialization{
	
	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestParameterPage testpage = new TestParameterPage();
	
	
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testpage);
		
		/* LOGIN */
		LoginTest.Login();
		Thread.sleep(2000);
		TestConfigNavigation.TestConfigurationCard();
		Thread.sleep(2000);
		testpage.testparameterbtn.click();
		Thread.sleep(2000);
		
		
		
//		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
//		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
//					"01--TEST CONFIGURATION CARD DISPLAYED",
//					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
//					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
//			
//		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
//		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
//				"01--TEST TOP NAVIGATION BUTTON DISPLAYED",
//				"02--TEST TOP NAVIGATION BUTTON ENABLED", testnav.testleftnav,
//				testnav.testparameterleftnav,testnav.testconfigleftnav,testnav.configgrouptestleftnav,
//				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW"); 
//		
//		/* TEST PROPERTIES DISPLAYED & ENABLED */
//		SampleCommonMethods.methodoneclick("STEP_03-- TEST PARAMETER PROPERTIES", testnav.testparameterleftnav,
//				"01--TEST PARAMETER LEFT NAVIGATION BUTTON DISPLAYED",
//				"02--TEST PARAMETER LEFT NAVIGATION BUTTON ENABLED", testpage.testparameterheadding,"Parameter",
//				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		/* CLICK ON ADD PARAMETER BUTTON*/
		SampleCommonMethods.singleclick("STEP_04-- ADD PARAMETERS PROPERTIES", testpage.addparameter,"01--ADD PARAMETERS BUTTON DISPLAYED","02--ADD PARAMETERS BUTTON ENABLED");
		
		/* ADD DATA IN TEST PARAMETER */
		addmethod();
//      REFRESH
      driver.navigate().refresh();
      Thread.sleep(1000);
		
		Logout.LogoutFunction();
	}
	
	static String parameter = "";
	static String parametertype = "";
	static String parameterdatatype = "";
	static String expectedmessage = "";
	
	public static void addmethod() throws InterruptedException, IOException
	{
		PageFactory.initElements(driver, methods);
		
/*Excel Sheet Value Passing*/	
		
		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Parameter";
		String testCaseId = "TC-PAR-0043";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);
		
		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Parameter");
			 
			XSSFRow row = sheet.getRow(firstRow);
			
				parameter = (String) row.getCell(1).getStringCellValue();
				parametertype = (String) row.getCell(2).getStringCellValue();
				parameterdatatype = (String) row.getCell(3).getStringCellValue();
				expectedmessage = (String) row.getCell(4).getStringCellValue();
		
		/* ADD PARAMETER */  
		SampleCommonMethods.sendvalue("STEP_5-- PARAMETER FIELD PROPERTYS", testpage.parameterteatarea,"01-- PARAMETER FIELD FIELD DISPLAYED", "02-- PARAMETER FIELD ENABLED" , parameter);

		/* PARAMETER TYPE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethoddropdown("STEP_6-- PARAMETER TYPE FIELD PROPERTYS", testpage.parametertype,"01-- PARAMETER TYPE FIELD DISPLAYED", "02-- PARAMETER TYPE FIELD ENABLED" , "//div[contains(text(),'"+parametertype+"')]" , "03-- DATA SUCCESSFULLY SELECTED");

		/* PARAMETER DATA TYPE FIELD DISPLAYED & ENABLED & SELECTED */  
		SampleCommonMethods.fieldmethoddropdown("STEP_7-- PARAMETER DATA TYPE FIELD PROPERTYS", testpage.parameterdatatype,"01-- PARAMETER DATA TYPE FIELD DISPLAYED", "02-- PARAMETER DATA TYPE FIELD ENABLED" , "//div[@title='"+parameterdatatype+"']", "03-- DATA SUCCESSFULLY SELECTED");
		
		/* SAVE BUTTON DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.singleclick("STEP_8-- SAVE BUTTON PROPERTIES", testpage.savebutton,"01-- SAVE BUTTON DISPLAYED", "02-- SAVE BUTTON ENABLED");

	    /* DATA ADDED SUCCESS MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP_9-- DATA ADDED SUCCESSFULLY",testpage.successMsg, expectedmessage);
//      REFRESH
      driver.navigate().refresh();
      Thread.sleep(1000);
		
	    /* CHECK FIRST DATA OF THE TABLE */
		SampleCommonMethods.firstrowdata("STEP_10-- DATA ADDED IN FIRST ROW", testpage.firstdata, parameter);
	   
		
	}
	
}
