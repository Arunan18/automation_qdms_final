
//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Main Category Search Button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 24/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-GT-031 		 24/06/2023   Sasi     Original Version
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

public class MainCategorySearchButtonProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void mainCategorySearch() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		mainCategoryClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Test Button
	public static void mainCategoryClickIcon() throws IOException, InterruptedException {

		try {

			// Click on Relevant Icon
			GroupTestsPage.mainCategorySearchicon.click();

			testCase = extent.createTest("Main Category Search Button");
			testCase.log(Status.INFO, "Clicked on the element 'Main Category Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			mainCategorySearchButtonProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Main Category Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Main Category Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Main Category Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Main Category Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Group Name Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void mainCategorySearchButtonProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Main Category Search Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test",
				"MTC-GT-031-02", GroupTestsPage.mainCategorySearchButton, "Main Category Search Button Properties");
	}
}
