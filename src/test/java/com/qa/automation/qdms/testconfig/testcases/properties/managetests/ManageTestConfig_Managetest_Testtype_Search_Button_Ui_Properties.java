//*************************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Test Type" Search Button  UI Properties
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
//* MTC-MT-154             22/06/2023   Priyanka     Orginal Version
//*                        26/06/2023   Priyanka     Testcase Number
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

public class ManageTestConfig_Managetest_Testtype_Search_Button_Ui_Properties extends DriverIntialization {

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testTypeSearchButtonProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, managetest);

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 5);

		// CLICKING SEARCH ICON BUTTON

		try {

			ManageTestsPage.testtypeicon.click();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Test Type Search Button ");
			testCase.log(Status.INFO, "Unable to Locate the element 'Button'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Test Type Search Button ");
			testCase.log(Status.INFO, "Unable to Click on the element 'Button'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Checking Test Type Search Button ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		
		//CHECKING TEST TYPE SEARCH BUTTON PROPERTIES

		testTypeSearchButtonUI();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void testTypeSearchButtonUI() {

		PageFactory.initElements(driver, managetest);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-154-02", ManageTestsPage.searchbtn, "Manage Test - Test Type Search Button Properties");

	}

}
