//*************************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Due Day(s)" Search Button  UI Properties
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-159             22/06/2023   Priyanka     Orginal Version
//*                        26/06/2023   Priyanka     Remove page factory & Testcase number
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfig_Managetest_Dueday_Search_Button_Ui_Properties extends DriverIntialization {

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testTypeSearchButtonProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, managetest);

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 6);

		// CLICKING SEARCH ICON BUTTON

		try {

			ManageTestsPage.testtypeicon.click();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Due Day Search Button ");
			testCase.log(Status.INFO, "Unable to Locate the element 'Button'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Due Day Search Button ");
			testCase.log(Status.INFO, "Unable to Click on the element 'Button'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Checking Due Day Search Button ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		// CHECKING DUE DAY SEARCH BUTTON PROPERTIES

		duedaySearchButtonUI();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void duedaySearchButtonUI() {

		PageFactory.initElements(driver, managetest);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-159-02", ManageTestsPage.searchbtn, "Manage Test - Due Day Search Button Properties");

	}

}
