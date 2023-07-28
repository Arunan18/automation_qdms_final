//*************************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Due Day(s)" Heading UI Properties
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-156            22/06/2023   Priyanka     Orginal Version
//*                       26/06/2023   Priyanka     Remove page factory & Testcase number
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfig_Managetest_Dueday_Heading_Ui_Properties extends DriverIntialization {

	static ManageTestsPage managetest = new ManageTestsPage();

	@Test
	public static void testTypeResetButtonUiProperties() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE

		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 6);

		// CHECKING DUE DAY HEADING PROPERTIES

		duedayHeadingUI();

		// LOGOUT

		Logout.LogoutFunction();

	}

	public static void duedayHeadingUI() {

		PageFactory.initElements(driver, managetest);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-156-02", ManageTestsPage.duedayheading, "Manage Test - Due Day Heading UI Properties");

	}

}
