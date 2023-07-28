//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action - Edit Pop up Screen "Cancel" Button  Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-397          11/07/2023    N.Karunya   Original Version                
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

public class Managetest_Action_Edit_Popup_Cancel_ButtonFunctionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void CancelButtonFunction() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-397");

		// Checking Action Edit Popup Cancel Button Functionality
		CancelButtonFunctionality();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	
	public static void CancelButtonFunctionality() throws InterruptedException {

			PageFactory.initElements(driver, mtp);
			Thread.sleep(2000);

			try {
				if (ManageTestsPage.actionEditpopupCancelButton.isDisplayed()) {
					testCase = extent.createTest("Action Edit Popup Cancel Button is Displayed");
					testCase.log(Status.INFO, "Action Edit Popup Cancel Button is Displayed ");
					testCase.log(Status.PASS, "TEST PASS");

					if (ManageTestsPage.actionEditpopupCancelButton.isEnabled()) {
						testCase = extent.createTest("Action Edit Popup Cancel Button is Enabled");
						testCase.log(Status.INFO, "Action Edit Popup Cancel Button is Enabled");
						testCase.log(Status.PASS, "TEST PASS");

					} else {
						testCase = extent.createTest("Action Edit Popup Cancel Button is not Enabled");
						testCase.log(Status.INFO, "Action Edit Popup Cancel Button is not Enabled");
						testCase.log(Status.FAIL, "TEST FAIL");
					}
				} else {
					testCase = extent.createTest("Action Edit Popup Cancel Button is not Displayed");
					testCase.log(Status.INFO, "Action Edit Popup Cancel Button is not Displayed");
					testCase.log(Status.FAIL, "TEST FAIL");
				}

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking The Action Edit Popup Cancel Button");
				testCase.log(Status.INFO, "Action Edit Popup Cancel Button is not available");
				testCase.log(Status.FAIL, "TEST FAIL");

			} catch (Exception e) {
				testCase = extent.createTest("Checking The Action Edit Popup Cancel Button");
				testCase.log(Status.INFO,"Unable to check the functionality of  Action Edit Popup Cancel Button");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		}

	
	}


