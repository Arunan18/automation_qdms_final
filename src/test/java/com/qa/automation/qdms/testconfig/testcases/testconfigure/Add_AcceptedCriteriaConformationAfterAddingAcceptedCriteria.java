//***********************************************************************************
//* Description
//*------------
//*Add parameter in test config -under the test parameter tab
//***********************************************************************************
//*Add Accepted Criteria Conformation After Adding Accepted Criteria
//* Author           : Saranka Somessaran
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0381        	01/06/2023     Saranka     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class Add_AcceptedCriteriaConformationAfterAddingAcceptedCriteria extends DriverIntialization {
	static TestConfigPage catDueDay = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static SampleActionMethods action = new SampleActionMethods();
	static String expectedResult = null;

	@Test
	public void addAcceptedCriteriaConfirmFun() throws InterruptedException, IOException {
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, catDueDay);
		PageFactory.initElements(driver, action);

//_______________________________		
// LOGIN TO THE SYSTEM
//_______________________________		

		LoginTest.Login();

//_______________________________        
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", catDueDay.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				catDueDay.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

//_______________________________       
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        

		
		SampleActionMethods.clicking(TestConfigPage.TestConfigBtnClick, 2, " STEP: 2 TEST CONFIGURE BUTTON ");

//_______________________________        
//STEP 3 :ADD  THE CONFIGURETEST  
// _______________________________
		
        testCase = extent.createTest("STEP:3 ADD  THE CONFIGURETEST TC-TCN-0381-first ");
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0381-first");
		Thread.sleep(2000);

//__________________________________________________________       
//STEP 4 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
// __________________________________________________________
		
		testCase = extent.createTest("STEP 4 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE TC-TCN-0381-Second");
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0381-Second");
		Thread.sleep(3000);

//________________________________________        
//STEP 5 :ADD THE PARAMETER
//_______________________________________        

		testCase = extent.createTest("STEP 5 :ADD THE PARAMETER TC-TCN-0381-Second ");
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0381-Second");
		Thread.sleep(2000);

//_______________________________________
//STEP 6  :ADD THE EQUATIONS
//_______________________________________         

		testCase = extent.createTest("STEP 6 :ADD THE EQUATIONS TC-TCN-0381-Third");
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0381-Third");
		Thread.sleep(3000);

//_______________________________________
//CLICK ON NEXT BUTTON
//_______________________________________

		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

//_____________________________________       
//STEP 7  : ADD THE ACCEPTCRETERIA
//______________________________________ 

		testCase = extent.createTest("STEP 7 : ADD THE ACCEPTCRETERIA TC-TCN-0381-fourth");
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0381-fourth");
		Thread.sleep(3000);

//________________________________________
// EXCEL METHOD
//________________________________________	

		String excelPath = System.getProperty("user.dir")
				+ "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx";
		String excelSheetName = "Test_Configure";
		String testCaseId = "TC-TCN-0381";

		int firstRow = CommonMethods.getFirstRowNum(excelPath, excelSheetName, testCaseId);
		int lastRow = CommonMethods.getLastRowNum(excelPath, excelSheetName, testCaseId);

		FileInputStream file = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(excelSheetName);

		XSSFRow row = sheet.getRow(firstRow);
		expectedResult = (String) row.getCell(1).getStringCellValue();

//__________________________________________
// AFTER SAVE CHECK 	
//__________________________________________
		Thread.sleep(2000);
		WebElement saveData = driver.findElement(By.xpath("//td[normalize-space()='" + expectedResult + "']"));
		SampleCommonMethods.firstrowdata("STEP 8: DATA ADDED IN FIRST ROW", saveData, expectedResult);

// _______________________________
// LOGOUT TO THE SYSTEM
// _______________________________

		Logout.LogoutFunction();

	}

}
