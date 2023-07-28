//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Additional Information -"Previous" button Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 13/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0802        13/07/2023    N.Karunya   Original Version                
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

public class Testconfig_Configtesttable_Addinfo_Add__PreviousBtn_Props extends DriverIntialization {

	static TestConfigPage tcp = new TestConfigPage();
	
	@Test
	public static void previousButton() throws InterruptedException, IOException {
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0802");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE ACCEPTED CRITERIA
			TestConfigMethods.clickButton(5);
		}

		Thread.sleep(500);

		// Checking Additional Information Pop-up-Add Field- "Previous" button
		// Properties
		previousButtonProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void previousButtonProps() {

		PageFactory.initElements(driver, tcp);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0802-02", TestConfigPage.additionalinfoaddpreviousbutton,
				"Configure Test Table-Additional Information Pop-up-Add Field- Previous Button UI Properties");

	}

}
