//***************************************************************************************
//* Description
//*------------
//*Test Configure - Configure Test Table-  Top Bar "Add Key Test" Tab - "Previous"  Button Properties
//***************************************************************************************
//*
//* Author           : THAKSHILA
//* Date Written     : 14/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Name        Comments
//* ================       ====         =====        ========
//*  
//*TC-TCN-0727        14/07/2023    THAKSHILA    Modified Version                   
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

public class TestConfiConfTestTabTopBarAddKeyTesTabPrevButProps extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();

	@Test
	public static void addKeyTestProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0727");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			AddkeytestUIHeadingProperties.addKeyTest();
		}

		// ADD KEY TEST SUBCATEGORY ICON PROPERTIES
		addkeySubCategoryclickPlusIcon();

		// LOGOUT
		Logout.LogoutFunction();
	}

// ADD KEY TEST SUB CATEGORY ICON PROPERTIES
	public static void addkeySubCategoryclickPlusIcon() throws IOException {

		PageFactory.initElements(driver, testconfigpg);

		try {

			TestConfigPage.materualRadioButton.click();

			// Get Properties
			addkeySubCategoryButtonProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the Mateial Radio Button");
			testCase.log(Status.INFO, "Unable to Locate the Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Mateial Radio Button");
			testCase.log(Status.INFO, "Unable to Click on Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check Mateial Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	// ADD KEY TEST SUB CATEGORY PROPERTIES
	public static void addkeySubCategoryButtonProperties() {

		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0727-02", TestConfigPage.selectForKeyMaterPrevButton,
				"Test Configure - Configure Test Table-  Top Bar Add Key Test Tab -  Previous  Button Properties");

	}

}
