//***********************************************************************************
//* Description
//*------------
//*Close button - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date    Intis        Comments
//* ================       ====    =====        ========
//* TC-Test-0027         28/04/2023   Saranka     Original Version
//*
//************************************************************************************


package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class CheckAddTestCloseButtonFunctionality  extends DriverIntialization{
	 static TestConfigPage checkTestCloseButton = new TestConfigPage();

//============================================  M E T H O D ========================================
	 
	 @Test
	 public void methodCalling() throws InterruptedException, IOException {
	 
//_____________________________________________
// LOGIN 
//_____________________________________________
		 
		 LoginTest.Login();
		 
//_______________________________________________
//  NAVIAGTE TO TEST
//_______________________________________________
		 
		 CheckAddTestCloseButtonFunctionality.navigateToTest();
		 
//_________________________________________________
//		 STEP:1 CLICK ADD BUTTON
//		 STEP:2 SEND DATA
//__________________________________________________
		 
		 CheckAddTestCloseButtonFunctionality.clickCloseButton();
		 
//____________________________________________________
//     STEP:3 CLICK CLOSE  BUTTON     
//		 
//___________________________________________________		 
		 
		 CheckAddTestCloseButtonFunctionality.afterValidateClosButtonFunctionality();
		 
//_____________________________________________________
//  LOGOUT
//_____________________________________________________
		 
		 MultiSearchMethods.Logout();
		 
	 }	 
	
//===================================  T E S T C A S E S ========================================
	 
//__________________________________________________________
//  NAVIGATE TO TEST
//__________________________________________________________	 
	 
	 public static void navigateToTest() {
		PageFactory.initElements(driver, checkTestCloseButton);

		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO TEST SIDE BUTTON
		SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", TestConfigPage.TestNavigation,
				"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", TestConfigPage.ParameterText,
				"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");

	}

//_____________________________________________________________________________
// STEP:1 CLICK ADD BUTTON, STEP:2 SEND DATA,
//______________________________________________________________________________
	public static void clickCloseButton() throws InterruptedException {
		PageFactory.initElements(driver, checkTestCloseButton);

		// STEP:1 CLICK ADD BUTTON
		SampleActionMethods.clicking(TestConfigPage.addButton, 2, " STEP:1 TEST ADD BUTTON");

		//STEP:2 SEND DATA
		testCase = extent.createTest(" STEP:2 SEND DATA");
		try {
			Thread.sleep(2000);
			TestConfigPage.PlaceHolderTestName.sendKeys(" Check Cancel Btn Functionality");
			testCase.log(Status.PASS, "DATA SEND");
		} catch (AssertionError e) {
			// TODO: handle exception
			testCase.log(Status.FAIL, "DATA  NOT SEND");
			
		}
	}
	
	

//______________________________________________________________________
//  STEP:3 CLICK CLOSE  BUTTON ,VALIDATE AFTER VALIDATE CLOSE BUTTON
//_______________________________________________________________________
public static void afterValidateClosButtonFunctionality() throws InterruptedException {
	PageFactory.initElements(driver, checkTestCloseButton);
	
	//CLICK  CLOSE BUTOON
	SampleActionMethods.clicking(TestConfigPage.CloseButton, 2,"STEP :3 CLOSE BUTTON");
	
	
	
	// VALIDATE CLOSE BUTTON FUNCTIONALITY
	testCase = extent.createTest("STEP:4 VALIDATE CLOSE BUTTON FUNCTIONALITY");
	
	try {
		
		// Verify that the modal is closed
		Thread.sleep(2000);
		Assert.assertFalse(TestConfigPage.AddTestConfigForm.isDisplayed());
		
		// Log test as pass and generate report
		testCase.log(Status.PASS, "Close button functionality is working correctly");
		
	} catch (AssertionError e) {
		// Log test as fail and generate report
		testCase.log(Status.FAIL, "Close button functionality is not working correctly");
		extent.flush(); // Generate report
	}

}

}