//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure" Heading UI Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 06/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-353         06/07/2023    N.Karunya   Original Version                
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

public class Managetest_EditconfigureHeadingProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void editconfigureHeading() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 14);

		// Check Edit Configure Heading UI Properties
		editconfigureHeadingProperties();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void editconfigureHeadingProperties() {

		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-353-02", ManageTestsPage.editConfigurecolumnHeading,
				"Manage Test - Edit Configure Heading UI Properties");

	}

}
