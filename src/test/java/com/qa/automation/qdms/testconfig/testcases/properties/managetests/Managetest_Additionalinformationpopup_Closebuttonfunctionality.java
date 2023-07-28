//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -"Close" Button Functionality 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 04/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-315           04/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_Additionalinformationpopup_Closebuttonfunctionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void additionalinformationPopupscreenclosebutton() throws InterruptedException, IOException {

		// Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-315");

		// Check Additional Information Close Button Functionality
		if (NavigateManageTestFromLogin.clicked) {

			closebuttonFunctionality();
		}

		// Refresh
		driver.navigate().refresh();

		// Logout
		Logout.LogoutFunction();

	}

	public static void closebuttonFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);
		
		try {
			if (ManageTestsPage.additonalinfopopupscreencloseButton.isDisplayed()) {
				testCase = extent.createTest("Additional Information Popup Screen Cancel Button is Displayed");
				testCase.log(Status.INFO, "Additional Information Popup Screen Cancel Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.additonalinfopopupscreencloseButton.isEnabled()) {
					testCase = extent.createTest("Additional Information Popup Screen Cancel Button is Enabled");
					testCase.log(Status.INFO, "Additional Information Popup Screen Cancel Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Additional Information Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.INFO, "Additional Information Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Additional Information Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.INFO, "Additional Information Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Additional Information Popup Screen Cancel Button");
			testCase.log(Status.INFO, "Additional Information Popup Screen Cancel Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Additional Information Popup Screen Cancel Button");
			testCase.log(Status.INFO, "Unable to check the functionality of Additional Information Popup Screen Cancel Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}
}
