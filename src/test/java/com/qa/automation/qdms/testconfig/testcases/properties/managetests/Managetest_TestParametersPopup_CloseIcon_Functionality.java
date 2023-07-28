//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- "Close" iconFunctionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 17/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-187         17/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_TestParametersPopup_CloseIcon_Functionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void testParametersPopupCloseIcon() throws InterruptedException, IOException {

		// MANAGE TEST - TEST PARAMETERS ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 7, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-187");

		Thread.sleep(1000);

		// Check Test Parameters Popup Screen Close Icon Functionality
		testParametersPopupCloseIconFunctionality();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void testParametersPopupCloseIconFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);

		try {
			if (ManageTestsPage.testparameterspopupcloseIcon.isDisplayed()) {
				testCase = extent.createTest("Test Parameters Popup Close Icon is Displayed");
				testCase.log(Status.INFO, "Test Parameters Popup Close Icon is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.testparameterspopupcloseIcon.isEnabled()) {
					testCase = extent.createTest("Test Parameters Popup Close Icon is Enabled");
					testCase.log(Status.INFO, "Test Parameters Popup Close Icon is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Test Parameters Popup Close Icon is not Enabled");
					testCase.log(Status.INFO, "Test Parameters Popup Close Icon is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Test Parameters Popup Close Icon is not Displayed");
				testCase.log(Status.INFO, "Test Parameters Popup Close Icon is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Test Parameters Popup Close Icon");
			testCase.log(Status.INFO, "Test Parameters Popup Close Icon is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Test Parameters Popup Close Icon");
			testCase.log(Status.INFO, "Unable to check the functionality of Test Parameters Popup Close Icon");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
