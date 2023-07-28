/***********************************************************************************
//* Description
//*------------
//* Test Configure - "Accepted Condition" - Action Sub Heading Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 14/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0742       14/07/2023      K.Saranga     Original Version
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

public class AddConditionConditionActionHeading extends DriverIntialization {
	static TestConfigPage testconfigurebutton = new TestConfigPage();
	@Test
	public void conditionActionHeading() throws InterruptedException, IOException {

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Test_Configure", "TC-TCN-0742");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(6);

		//Calling the method
		conditionActionHeadingPropertiess();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void conditionActionHeadingPropertiess() {
		PageFactory.initElements(driver, testconfigurebutton);

		//Check Condition Action Heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0742-02", TestConfigPage.conditionactionheading, "Accepted Condition - Action Sub Heading Properties");
	}
}


