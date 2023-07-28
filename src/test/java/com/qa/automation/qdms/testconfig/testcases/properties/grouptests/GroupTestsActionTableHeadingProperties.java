/***********************************************************************************
//* Description
//*------------
//* Manage Test "Action" - Table Heading Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 05/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-064        05/07/2023      K.Saranga     Original Version
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

public class GroupTestsActionTableHeadingProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	static String code = null;
	@Test
	public static void actionTableHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		actionTableHeadingProperties();

		Thread.sleep(2000);

		// LOGOUT
		Logout.LogoutFunction();
	}
	public static void actionTableHeadingProperties() {
		PageFactory.initElements(driver, GroupTestpg);

		//Check Tests Table Heading UI Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-064-02", GroupTestsPage.actiontableheading, "Action Table Heading UI Properties");
	}
}




