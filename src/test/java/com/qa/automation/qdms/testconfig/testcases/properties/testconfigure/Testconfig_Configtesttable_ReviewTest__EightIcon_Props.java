//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar "Review Test"  icon "8"  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 14/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0804        14/07/2023    N.Karunya   Original Version                
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

public class Testconfig_Configtesttable_ReviewTest__EightIcon_Props extends DriverIntialization {
	
	static TestConfigPage tcp = new TestConfigPage();

	@Test
	public static void eightIcon() throws InterruptedException, IOException {
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0804");

		Thread.sleep(500);

		// Checking Top Bar Review Test -"Review Test" - icon "8" Properties
		eightIconProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	
	public static void eightIconProps() {
		
		PageFactory.initElements(driver, tcp);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0804-02", TestConfigPage.iconEight,
				"Configure Test Table- Review Test - icon \"8\"  UI Properties");

	}

}
