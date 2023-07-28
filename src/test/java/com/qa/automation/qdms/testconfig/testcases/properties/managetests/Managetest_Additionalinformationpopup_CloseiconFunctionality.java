//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -"Close" icon Functionality 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 04/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-313	         04/07/2023    N.Karunya   Original Version                
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

public class Managetest_Additionalinformationpopup_CloseiconFunctionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void additionalinformationPopupscreenCloseicon() throws InterruptedException, IOException {

		// Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-313");

		// Check Additional Information Close Icon Functionality
		if (NavigateManageTestFromLogin.clicked) {

			closeiconFunctionality();
		}

		// Refresh
		driver.navigate().refresh();

		// Logout
		Logout.LogoutFunction();

	}
	
	// Functionality of Additional Information Popup Screen Close Icon

	public static void closeiconFunctionality() {
		
		PageFactory.initElements(driver, mtp);

		try {

			ManageTestsPage.additonalinfopopupscreencloseIcon.click();

			testCase = extent.createTest("Checking The Additional Information Close Icon Click");
			testCase.log(Status.INFO, "Additional Information Close Icon is Clicked");
			testCase.log(Status.PASS, "TEST PASS");


		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Additional Information Close Icon Click");
			testCase.log(Status.INFO, "Unable to Locate Additional Information Close Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Additional Information Close Icon Click");
			testCase.log(Status.INFO, "Additional Information Close Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Additional Information Close Icon Click");
			testCase.log(Status.INFO, "Additional Information Close Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
