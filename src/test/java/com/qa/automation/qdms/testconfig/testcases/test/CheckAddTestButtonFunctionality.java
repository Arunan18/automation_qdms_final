//***********************************************************************************
//* Description
//*------------
//* Check Add Test Button Functionality
//***********************************************************************************
//*
//* Author           : Mathusan
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-Test-0017		28/04/2023     MATHUSAN     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class CheckAddTestButtonFunctionality extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods method = new SampleCommonMethods();

	@Test

	public static void AddTestButtonFunctionality() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, method);

		// Click LOGIN Button
		LoginTest.Login();

		// Click Test Configuration
		TestConfigPage.testconfigurationcard.click();

		// Click Test Button
		TestConfigPage.testtopnav.click();

		// Click Left Navigation Test Button
		TestConfigPage.testleftnav.click();

		// Check "Add Test" Button Functionality
		AddTestButtonfunct();
		
		//Click the Refresh 
		driver.navigate().refresh();
		
		//Click the Logout
		Logout.LogoutFunction();

	}

	// Check "Add Test" Button Functionality
	public static void AddTestButtonfunct() {

		PageFactory.initElements(driver, method);
		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);

		SampleCommonMethods.methodoneclick("STEP_01-- TEST ADD TEST BUTTON EXPECTED WINDOWS PROPERTIES",
				TestParameterPage.AddTestButton, "01--ADD TEST BUTTON DISPLAYED", "02--ADD TEST BUTTON ENABLED",
				TestParameterPage.AddTestButtonWindowHeading, "Add Test", "03--ADD TEST BUTTON WINDOW VISIBLE");
	}

}
