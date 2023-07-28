//***********************************************************************************
//* Description
//*------------
//* Delete Cancel Button - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date    Intis        Comments
//* ================       ====    =====        ========
//* TC-Test-0039       28/04/2023   Saranka     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class CheckDeleteTestCancelButtonFunctionality  extends DriverIntialization{
static TestConfigPage DeleteCancelButton = new TestConfigPage();
//==================================== M E T H O D  ======================================

	@Test
	public void mathod() throws InterruptedException, IOException {
		
		
//________________________________________________
//LOGIN
//________________________________________________
		
		LoginTest.Login();
		
//________________________________________________
//NAVIGATE TO TEST
//_________________________________________________		
		
		CheckDeleteTestCancelButtonFunctionality.navigateToTest();

//___________________________________________________
//  STEP:1 TEST DELETE BUTTON VISIBLE AND ENABLE
 		
//	STEP:2 CHECK CANCEL BUTTON VISIBLE AND ENABLE
//____________________________________________________		
		
		CheckDeleteTestCancelButtonFunctionality.clickCancelBtn();
		
//_________________________________________________________
//LOGOUT
//__________________________________________________________	
		
		MultiSearchMethods.Logout();
		
	}
	

//====================================== T E S T C A S E =================================	


//_____________________________________________________
//NAVIGATE TO TEST
//_____________________________________________________

	public static void navigateToTest() {
		PageFactory.initElements(driver, DeleteCancelButton);

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
//STEP:1 CLICK ADD BUTTON, STEP:2 SEND DATA,& STEP:3 CLICK CANCEL BUTTON
//______________________________________________________________________________
	public static void clickCancelBtn() throws InterruptedException {
		PageFactory.initElements(driver, DeleteCancelButton);

		 //STEP:1 CLICK DELETE BUTTON
		
		String enteredData = driver.findElement(By.xpath("//td[normalize-space()='test']")).getText();
		
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.TestDeleteButton, 2, "STEP:1 DELLETE BUTTON");
		
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.DeleteCanCelButtonTest, 2, "STEP:2 CANCEL BUTTON");
	
		testCase = extent.createTest("STEP:2 VALIDATE CANCEL BUTTON FUNCTIONALITY");
		
		String dataAfterCancel = driver.findElement(By.xpath("//td[normalize-space()='test']")).getText();
        testCase =extent.createTest("STEP:3 AFTER VALIDATE ");
		// Compare the values of the input field before and after clicking cancel button
		if(enteredData.equals(dataAfterCancel)){
		    System.out.println("Data not saved after clicking cancel button. Cancel button functionality working.");
		}else{
		    System.out.println("Data saved after clicking cancel button. Cancel button functionality not working.");
		}

	}
	}
