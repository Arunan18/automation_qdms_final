//***********************************************************************************
//* Description
//*------------
//* Add Parameter button function Under the test parameter
//***********************************************************************************
//*
//* Author           : Mathusan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0046 		 28/04/2023    MATHUSAN     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AddParameterbuttonfunctionUnderthetestparameter extends DriverIntialization {

	static TestConfigPage TCP = new TestConfigPage();
	static AddConfigureTest ACT = new AddConfigureTest();
	static TestParameterPage TPP = new TestParameterPage();
	static SampleCommonMethods method = new SampleCommonMethods();

	@Test
	public static void Parameteraddbuttonfunction() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, ACT);
		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, method);

		// Click LOGIN Button
		LoginTest.Login();

		// Click Test Configuration
		TestConfigPage.testconfigurationcard.click();

		// Click Test Button
		TestConfigPage.testtopnav.click();

		// Click Test Configuration
		TestConfigPage.testconfigleftnav.click();

		// Click 1st Configuration Test
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0046");
		Thread.sleep(3000);

		// Add Parameter button function Under the test parameter

		SampleCommonMethods.methodoneclick("STEP_01-- ADDPARAMETER BUTTON FUNCTION UNDER THE TEST PARAMETER",
				TestParameterPage.AddParameterbuttonunctionUnderthetestparameter, "01--ADDPARAMETER BUTTON DISPLAYED",
				"02--ADDPARAMETER BUTTON ENABLED", TestParameterPage.AddParameterButtonfunctionwindowheading,
				"Add Parameter", "03--ADDPARAMETER BUTTON WINDOW VISIBLE");

		// Click the Refresh
		driver.navigate().refresh();

		// Click the Logout
		Logout.LogoutFunction();

	}

}
