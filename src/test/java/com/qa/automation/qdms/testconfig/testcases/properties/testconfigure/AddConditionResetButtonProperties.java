/***********************************************************************************
//* Description
//*------------
//* Test Configure - "Accepted Condition" - Reset Button Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 14/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0756      14/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AddConditionResetButtonProperties extends DriverIntialization {
	static TestConfigPage testconfigurebutton = new TestConfigPage();
	@Test
	public void addConditionResetButton() throws InterruptedException, IOException {

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Test_Configure", "TC-TCN-0756");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(6);

		//Calling the method
		addConditionResetButtonPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void addConditionResetButtonPropertiess() {
		PageFactory.initElements(driver, testconfigurebutton);

		//Check Accepted Condition Previous Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0756-02", TestConfigPage.addconditionresetbtn, "Accepted Condition Reset Button Properties");
	}
}

