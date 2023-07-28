
//***********************************************************************************
//* Description
//*------------
//* Manage Test Tab Group Test - "Main Category" Search PopUp Screen Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 25/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-029	          25/06/2023   Sasi     Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MainCategorySearchPopupProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void mainCategoryPopUp() throws InterruptedException, IOException {
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
			Thread.sleep(1000);
			// Click on Relevant Icon
			GroupTestsPage.mainCategorySearchicon.click();

			testCase = extent.createTest("Main Category Search Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Main Category Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			MainCategoryPopUpProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Main Category Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Delete ?  Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Main Category Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Main Category Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Main Category Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void MainCategoryPopUpProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Main Category PopUp Properties
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Group_Test",
				"MTC-GT-029-02", GroupTestsPage.mainCategorySearchpopup, "Main Category PopUp Screen Properties");
	}
}
