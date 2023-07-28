//***************************************************************************************
//* Description
//*------------
//*Test Configure - Configure Test Table-  Top Bar "Add Key Test" - "Select For Key Test" - Heading  Check box Properties
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
//* TC-TCN-0717       14/07/2023    THAKSHILA    Modified Version                   
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TopBarAddKeyTestSelectForKeyTestHeadingCheckboxProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();

	@Test
	public static void addKeyTestProperties() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0717");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			AddkeytestUIHeadingProperties.addKeyTest();
		}

		// ADD KEY TEST SUBCATEGORY ICON PROPERTIES
		addkeySubCategoryCheckBoxProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ADD KEY TEST SUB CATEGORY ICON PROPERTIES
	public static void addkeySubCategoryCheckBoxProperties() {

		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0717-02",
				TestConfigPage.selectForKeyTestHeadCheckBox, "Select For Key Test - Heading  Check box Properties");

	}

}
