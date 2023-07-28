//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Updated Date" Heading UI Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 06/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-352         06/07/2023    N.Karunya   Original Version                
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

public class Managetest_UpdatedDateHeadingProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void updatedDateHeading() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 13);

		// Check Updated Date Heading UI Properties
		updatedDateHeadingProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void updatedDateHeadingProperties() {

		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-352-02", ManageTestsPage.updateddatecolumnHeading,
				"Manage Test - Updated Date Heading UI Properties");

	}

}
