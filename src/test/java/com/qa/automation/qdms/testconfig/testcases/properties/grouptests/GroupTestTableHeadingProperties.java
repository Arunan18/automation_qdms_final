
//***********************************************************************************
//* Description
//*------------
//* Manage Test - "Group Test" Table Heading UI Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-GT-020          23/06/2023   Sasi     Original Version
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

public class GroupTestTableHeadingProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void GroupTestHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		GroupTestClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Test Button
	public static void GroupTestClickIcon() throws IOException, InterruptedException {
		try {

			// Click on Relevant Icon
			GroupTestsPage.groupTestSiteBtn.click();

			testCase = extent.createTest("Group Test Heading Click Click");
			testCase.log(Status.INFO, "Clicked on the element 'Group Test Heading'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			GroupTestHeadingProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Group Test Heading Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Group Test Heading'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Group Test Heading Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Group Test Heading'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Group Test Heading' Checking Terminated");
			testCase.log(Status.INFO, "'Group Test Heading' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void GroupTestHeadingProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Group Test Button Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-020-02",
				GroupTestsPage.groupTestTableHeading, "Group Test Table Heading UI Properties");
	}
}
