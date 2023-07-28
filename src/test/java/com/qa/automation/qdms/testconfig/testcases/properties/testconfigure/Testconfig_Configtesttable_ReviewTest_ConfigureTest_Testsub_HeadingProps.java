//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Review Test - Configure Test -"Test" UI Sub Heading  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 14/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0807        14/07/2023    N.Karunya   Original Version                
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

public class Testconfig_Configtesttable_ReviewTest_ConfigureTest_Testsub_HeadingProps extends DriverIntialization {

	static TestConfigPage tcp = new TestConfigPage();
	
	@Test
	public static void testHeading() throws InterruptedException, IOException {

		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0807");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE ACCEPTED CRITERIA
			TestConfigMethods.clickButton(6);
		}

		Thread.sleep(500);

		// Checking Top Bar Review Test - Configure Test -"Test" UI Sub Heading
		// Properties
		testHeadingProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void testHeadingProps() {

		PageFactory.initElements(driver, tcp);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0807-02", TestConfigPage.configuretestTestsubHeading,
				"Configure Test Table-Additional Information Pop-up-Add Field- Configure Test - Test Sub Heading UI Properties");

	}

}

