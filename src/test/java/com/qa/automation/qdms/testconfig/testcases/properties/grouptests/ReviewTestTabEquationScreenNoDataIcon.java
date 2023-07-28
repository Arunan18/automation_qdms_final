/***********************************************************************************
//* Description
//*------------
//* Test - Test Configure - Configure Test - Review Test Tab - "Equation Screen" No Data Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 12/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-126         12/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfigMethods;

public class ReviewTestTabEquationScreenNoDataIcon extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	@Test
	public static void equationScreenNoDataIcon() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties","Group_Test", "MTC-GT-126");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(6);

		//Calling the method
		equationScreenNoDataIconProperties();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void equationScreenNoDataIconProperties() {	
		PageFactory.initElements(driver, GroupTestpg);

		//Check GroupTests Pagination Drop down Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-126-02", GroupTestsPage.equationnodataicon, "Review Test Tab Equation Screen No Data Properties");
	}
}


