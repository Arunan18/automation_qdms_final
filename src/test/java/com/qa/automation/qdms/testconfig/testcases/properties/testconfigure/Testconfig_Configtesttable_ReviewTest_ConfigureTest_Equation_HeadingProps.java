//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Review Test - "Equation" - UI Top Heading  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 14/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0811        14/07/2023    N.Karunya   Original Version                
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

public class Testconfig_Configtesttable_ReviewTest_ConfigureTest_Equation_HeadingProps extends DriverIntialization {

	static TestConfigPage tcp = new TestConfigPage();
	
	@Test
	public static void equationHeading() throws InterruptedException, IOException {

		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0811");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE ACCEPTED CRITERIA
			TestConfigMethods.clickButton(6);
		}

		Thread.sleep(500);

		// Checking Top Bar Review Test - Configure Test -"Equation" UI Heading
		// Properties
		equationHeadingProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void equationHeadingProps() {

		PageFactory.initElements(driver, tcp);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0811-02", TestConfigPage.configuretestEquationHeading,
				"Configure Test Table-Additional Information Pop-up-Add Field- Configure Test - Equation Heading UI Properties");

	}

}
