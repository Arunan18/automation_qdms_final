
//***********************************************************************************
//* Description
//*------------
//* Manage Test Tab Group Test - "Group Type" Search PopUp Screen Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 26/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-047            26/06/2023   Sasi     Original Version
//*
//************************************************************************************


package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupTypeSearchPopupProperties extends DriverIntialization{
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void groupTypePopUp() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Type Button & Check Group Type Button Properties
		groupTypeClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Type Button
	public static void groupTypeClickIcon() throws IOException, InterruptedException {

		try {
			Thread.sleep(1000);
			// Click on Relevant Icon
			GroupTestsPage.groupTypesSearchicon.click();

			testCase = extent.createTest("Group Type Search Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Group Type Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			groupTypePopUpProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Group Type Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Group Type Search Icon Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Group Type Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Group Type Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Group Type Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void groupTypePopUpProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Group Type PopUp Properties
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Group_Test",
				"MTC-GT-047-02", GroupTestsPage.groupTypeSearchpopup, "Group Type PopUp Screen Properties");
	}
}

