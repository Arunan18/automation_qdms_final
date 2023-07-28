/***********************************************************************************
//* Description
//*------------
//* Test Configure - "Accepted Condition" - ) Icon Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 14/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0740       14/07/2023      K.Saranga     Original Version
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

public class AddConditionIconProperties extends DriverIntialization {
	static TestConfigPage testconfigurebutton = new TestConfigPage();
	@Test
	public void addConditionIcon() throws InterruptedException, IOException {

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Test_Configure", "TC-TCN-0740");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(6);

		//Calling the method
		addConditionIconPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void addConditionIconPropertiess() {
		PageFactory.initElements(driver, testconfigurebutton);

		//Check Accepted Condition Icon Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0740-02", TestConfigPage.acceptedconditionicon, "Accepted Condition Icon Properties");
	}
}

