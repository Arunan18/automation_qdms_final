//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action - Edit Pop up Screen "Close" Button  Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-400           11/07/2023     N.Karunya     Original Version                
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

public class Managetest_Action_Edit_Popup_Close_ButtonFunctionality extends DriverIntialization {
	
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void editPopupCloseButtonFunction() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-400");

		// Checking Action Edit Popup Close Button Functionality
		editPopupCloseButtonFunctionality();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	
	public static void editPopupCloseButtonFunctionality() throws InterruptedException {
		
		PageFactory.initElements(driver, mtp);
		Thread.sleep(2000);

		try {
			if (ManageTestsPage.actionEditpopupcloseButton.isDisplayed()) {
				testCase = extent.createTest("Action Edit Popup Close Button is Displayed");
				testCase.log(Status.INFO, "Action Edit Popup Close Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.actionEditpopupcloseButton.isEnabled()) {
					testCase = extent.createTest("Action Edit Popup Close Button is Enabled");
					testCase.log(Status.INFO, "Action Edit Popup Close Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Action Edit Popup Close Button is not Enabled");
					testCase.log(Status.INFO, "Action Edit Popup Close Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Action Edit Popup Close Button is not Displayed");
				testCase.log(Status.INFO, "Action Edit Popup Close Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Action Edit Popup Close Button");
			testCase.log(Status.INFO, "Action Edit Popup Close Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Action Edit Popup Close Button");
			testCase.log(Status.INFO,"Unable to check the functionality of  Action Edit Popup Close Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
		
	}


