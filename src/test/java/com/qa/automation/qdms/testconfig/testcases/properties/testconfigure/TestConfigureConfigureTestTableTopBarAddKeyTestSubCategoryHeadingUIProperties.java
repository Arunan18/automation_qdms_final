//***************************************************************************************
//* Description
//*------------
//* Test Configure - Test Configure - Configure Test Table-  Top Bar "Add Key Test" - "Sub Category" - Heading UI Properties
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
//* TC-TCN-0712         14/07/2023    THAKSHILA    Modified Version                   
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

public class TestConfigureConfigureTestTableTopBarAddKeyTestSubCategoryHeadingUIProperties extends DriverIntialization {

	@Test
	public static void addKeyTestProperties() throws InterruptedException, IOException {
	
		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0713");

		if (NavigateManageTestFromLogin.clicked) {
			// ADD KEY TEST
			AddkeytestUIHeadingProperties.addKeyTest();
		}

		// ADD KEY TEST SUBCATEGORYP ROPERTIES
		addkeySubCategoryHeadingProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ADD KEY TEST SUB CATEGORY  PROPERTIES
	public static void addkeySubCategoryHeadingProperties() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0713-02", TestConfigPage.addKeyTestSubCatHead, "Sub Category Heading UI Properties");

	}

}
