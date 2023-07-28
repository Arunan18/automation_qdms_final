
//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Sub Category Reset Button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 25/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-GT-038          25/06/2023   Sasi     Original Version
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

public class SubCategoryResetButtonProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void GroupNameTextBox() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		SubCategoryClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Sub Category Button
	public static void SubCategoryClickIcon() throws IOException, InterruptedException {

		try {

			// Click on Relevant Icon
			GroupTestsPage.subCategorySearchicon.click();

			testCase = extent.createTest("Sub Category Reset Button");
			testCase.log(Status.INFO, "Clicked on the element 'Sub Category Reset Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			SubCategoryResetButtonProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Sub Category Reset Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Sub Category Reset Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Sub Category Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Sub Category Reset Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Sub Category Reset Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Sub Category Reset Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void SubCategoryResetButtonProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Sub Category Reset Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test",
				"MTC-GT-038-02", GroupTestsPage.subCategoryResetButton, "Sub Category Reset Button Properties");
	}
}
