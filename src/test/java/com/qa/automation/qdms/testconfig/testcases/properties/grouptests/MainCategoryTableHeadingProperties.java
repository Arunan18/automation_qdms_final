
//***********************************************************************************
//* Description
//*------------
//* Manage Test Tab Group Test - "Main Category" Table Heading UI Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 25/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-027	          25/06/2023   Sasi     Original Version
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

public class MainCategoryTableHeadingProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void MainCategoryHeading() throws InterruptedException, IOException {
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

			testCase = extent.createTest("Main Category Heading Click");
			testCase.log(Status.INFO, "Clicked on the element 'Heading'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			mainCategoryHeadingProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Main Category Heading Click Identify");
			testCase.log(Status.INFO, "Unable to Locate the element Main Category Heading Click'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Main Category Heading Click Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Main Category Heading Click'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Main Category Heading Click' Checking Terminated");
			testCase.log(Status.INFO, "'Main Category Heading Click' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void mainCategoryHeadingProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Main Category Button Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-027-02",
				GroupTestsPage.mainCategoryHeading, "Main Category Table Heading UI Properties");
	}
}
