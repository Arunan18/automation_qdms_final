//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Accepted Condition" Heading UI Properties 
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 04/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-317           04/07/2023    N.Karunya   Original Version                
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

public class Managetest_AcceptedconditionHeadingProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void acceptedconditionHeading() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 11);
		
		// Check Accepted Condition Heading UI Properties
		acceptedconditionHeadingProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void acceptedconditionHeadingProperties() {
		
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-317-02", ManageTestsPage.acceptedconditioncolumnHeading,
				"Manage Test - Accepted Condition Heading UI Properties");
		
	}
	
	
}
