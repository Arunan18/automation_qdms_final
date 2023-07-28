//***********************************************************************************
//* Description
//*------------
//*Cancel Button - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date    Intis        Comments
//* ================       ====    =====        ========
//* TC-Test-0025       28/04/2023   Saranka     Original Version
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

public class CheckAddTestCancelButtonFunctionality extends DriverIntialization {
	static TestConfigPage cancelBtnFunctionality = new TestConfigPage();
	
	
//==================================== M E T H O D  ======================================
	
	@Test
	public void mathod() throws InterruptedException, IOException {
		
		
//________________________________________________
//  LOGIN
//________________________________________________
		
		LoginTest.Login();
		
//________________________________________________
// NAVIGATE TO TEST
//_________________________________________________		
		
		CheckAddTestCancelButtonFunctionality.navigateToTest();

//___________________________________________________
//    STEP:1 TEST ADD BUTTON VISIBLE AND ENABLE
//    STEP:2 SEND DATA		
//	  STEP:3 CHECK CANCEL BUTTON VISIBLE AND ENABLE
//____________________________________________________		
		
		CheckAddTestCancelButtonFunctionality.clickCancelBtn();
		
//______________________________________________________
//   STEP:4 AFTER CLICK CANCEL BUTTON VALIDATE FUNCTIONALITY
//_______________________________________________________		
		
		CheckAddTestCancelButtonFunctionality.afterValidateCancelButtonFunctionality();
		
//_________________________________________________________
//  LOGOUT
//__________________________________________________________	
		
		MultiSearchMethods.Logout();
		
	}
	
	
	
//====================================== T E S T C A S E =================================	
	

//_____________________________________________________
// NAVIGATE TO TEST
//_____________________________________________________

	public static void navigateToTest() {
		PageFactory.initElements(driver, cancelBtnFunctionality);

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
// STEP:1 CLICK ADD BUTTON, STEP:2 SEND DATA,& STEP:3 CLICK CANCEL BUTTON
//______________________________________________________________________________
	public static void clickCancelBtn() throws InterruptedException {
		PageFactory.initElements(driver, cancelBtnFunctionality);

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
//____________________________________________________________________
// AFTER VALIDATE CANCEL BUTTON FUNCTIONALITY
//____________________________________________________________________	
	
	public static void afterValidateCancelButtonFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, cancelBtnFunctionality);
		
		 //STEP:3 CLICK CANCEL BUTTON
		
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.CancelBtn, 2, "STEP:2 CANCEL BUTTON");
	
		testCase = extent.createTest("STEP:4 VALIDATE CANCEL BUTTON FUNCTIONALITY");
		try {
			
			Thread.sleep(2000);
		    // VERIFY IF ADD TEST CONFIGURATION FORM IS DISPLAYED
		    Assert.assertFalse(TestConfigPage.AddTestConfigForm.isDisplayed(),
		            "Add Test Configuration form is not closed");
		    testCase.log(Status.PASS, "Add Test Configuration form is closed");

		    // VERIFY IF TEST SIDE BUTTON IS DISPLAYED
		    Assert.assertTrue(TestConfigPage.addButton.isDisplayed(),
		            "Test side button is not displayed");
		    testCase.log(Status.PASS, "Test side button is displayed");

		    // VERIFY IF THE CORRECT FORM IS DISPLAYED AFTER CANCELING ADD TEST CONFIGURATION
		    Assert.assertTrue(TestConfigPage.TestText.getText().equals("Test"),
		            "Add Test Configuration form is not closed and redirected to the correct form");
		    testCase.log(Status.PASS, "Correct form is displayed after canceling Add Test Configuration");
		} catch (AssertionError e) {
		    testCase.log(Status.FAIL, e.getMessage());
		    
		}

	}

}
