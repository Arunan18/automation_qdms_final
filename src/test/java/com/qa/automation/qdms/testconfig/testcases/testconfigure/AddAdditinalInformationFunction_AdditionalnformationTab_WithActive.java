
//***********************************************************************************
//* Description
//*------------
//AddAdditinalInformationFunction_AdditionalnformationTab_WithActive
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 06/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0384            06/06/2023    Niluxy       Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddAdditinalInformationFunction_AdditionalnformationTab_WithActive extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	static String caption = null;
	static String expectedmessage = null;

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);
		extent.createTest("TC-TCN-0384:AddAdditinalInformationFunction_AdditionalnformationTab_WithActive");
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

//STEP1 :ADD  THE CONFIGURETEST	
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-first");
		Thread.sleep(2000);
//STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-second");
		Thread.sleep(3000);
//STEP3 :ADD THE PARAMETER		
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-second");
		Thread.sleep(3000);
//STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-third");
		Thread.sleep(3000);
//MOVE TO NEXT PAGE
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP5 : ADD THE ACCEPTCRETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-fourth");
		Thread.sleep(3000);
//MOVE TO DOWN 
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//MOVE TO NEXT PAGE 
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP6 :ADD TEST KEYS 
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-fifth");
//MOVE TO NEXT PAGE	
		Thread.sleep(3000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();
//STEP7 :ADD ADITIONAL INFORMATION
		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0384-seventh");
//DOWN THE PAGE		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// SELECT THE MESSAGE AND DATA COUNT FROM EXCEL
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Test_Configure");
		int rowcount = sheet.getLastRowNum();

		int firstrow = CommonMethods.getFirstRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0384-eighth");
		int lastrow = CommonMethods.getLastRowNum(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Excel\\Test Configuragtion Module.xlsx",
				"Test_Configure", "TC-TCN-0384-eighth");

		for (int i = firstrow; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			caption = (String) row.getCell(1).getStringCellValue();
			expectedmessage = (String) row.getCell(2).getStringCellValue();

		}

		/* CHECK DATA ADDED SUCCESS MESSAGE HAS BEEN SHOWN */
		Thread.sleep(500);
		SampleCommonMethods.dataaddedsuccessmsg("DATA UPDATED SUCCESSFULLY", TestConfigPage.successMsg,
				expectedmessage);


		/* CHECK THE LAST ADDED DATA COMES IN FIRST ROW OF THE TABLE */
		Thread.sleep(1000);
		SampleCommonMethods.firstrowdata("DATA ADDED IN FIRST ROW", TestConfigPage.additionalinfofirstrowdata, caption);

		// LOGOUT TO THE SYSTEM
		Thread.sleep(1000);
		Logout.LogoutFunction();
	}
}