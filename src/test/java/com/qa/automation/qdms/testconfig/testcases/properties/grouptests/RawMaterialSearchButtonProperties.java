
//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Raw Material Search Button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 27/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-GT-043 		 27/06/2023   Sasi     Original Version
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

public class RawMaterialSearchButtonProperties extends DriverIntialization{
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void GroupNameTextBox() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		subCategoryClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Test Button
	public static void subCategoryClickIcon() throws IOException, InterruptedException {

		try {

			// Click on Relevant Icon
			GroupTestsPage.rawMaterialSearchicon.click();

			testCase = extent.createTest("Raw Material Search Button");
			testCase.log(Status.INFO, "Clicked on the element 'Raw Material Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			rawMaterialSearchButtonProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Raw Material Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Raw Material Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Raw Material Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Raw Material Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Raw Material Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void rawMaterialSearchButtonProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Raw Material Search Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test",
				"MTC-GT-043-02", GroupTestsPage.rawMaterialSearchButton, "Raw Material Search Button Properties");
	}
}


