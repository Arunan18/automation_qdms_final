//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar "Add Key Test"  UI Heading  Properties
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0711			23/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AddkeytestUIHeadingProperties extends DriverIntialization {

	@Test
	public static void addkeytestUIProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0711");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			addKeyTest();
		}

		// ADD KEY TEST UI HEADING PROPERTIES
		addkeyUIHeadingProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ADD KEY TEST UI HEADING PROPERTIES
	public static void addkeyUIHeadingProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0711-02", TestConfigPage.Addkeytest, "Add key test UI heading properties");

	}

	// ADD KEY TEST PATH
	public static void addKeyTest() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);

		// Test Configure Button Click
		try {
			Thread.sleep(1000);
			TestConfigPage.testconfigureleftnavigation.click();

			// AddKey Test Button Click
			try {
				TestConfigPage.addkeytest.click();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Check the Test Configure Left button");
				testCase.log(Status.INFO, "Test Configure Left button is not Found");
				testCase.log(Status.FAIL, "Test Configure Left button is not Found");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Check the Test Configure Left button Click");
				testCase.log(Status.INFO, "Test Configure Left button is not Clicked");
				testCase.log(Status.FAIL, "Test Configure Left button is not Clicked");
			} catch (Exception e) {
				testCase = extent.createTest("Check the Test Configure Left button");
				testCase.log(Status.INFO, "Test Configure Left button Error");
				testCase.log(Status.FAIL, "Test Configure Left button Error");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Check the Add key test button");
			testCase.log(Status.INFO, "Add key test button is not Found");
			testCase.log(Status.FAIL, "Add key test button is not Found");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Check the Add key test button Click");
			testCase.log(Status.INFO, "Add key test button is not Clicked");
			testCase.log(Status.FAIL, "Add key test button is not Clicked");
		} catch (Exception e) {
			testCase = extent.createTest("Check the Add key test");
			testCase.log(Status.INFO, "Add key test button Error");
			testCase.log(Status.FAIL, "Add key test button Error");
		}
	}
}
