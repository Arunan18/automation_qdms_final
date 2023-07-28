//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Configure Test-"Active"  Check Box Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 07/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-364          07/07/2023    N.Karunya   Original Version                
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

public class Managetest_Editconfigure_Configuretest_ActiveCheckboxProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void activeCheckbox() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-364");

		Thread.sleep(500);

		// Checking Active Checkbox UI Properties
		activeCheckboxProperties();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void activeCheckboxProperties() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-364-02",
				ManageTestsPage.activeChecktbox, "Manage Test - Accepted Condition- Active Checkbox  UI Properties");

	}

}


