//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Accepted Condition -Add Condition "Save Equation" Button Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 06/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-342           06/07/2023     N.Karunya     Original Version                
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

public class Managetest_AcceptedconditionIcon_AcceptedconditionPopup_SaveEquationbuttonProps
		extends DriverIntialization {
	
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void saveEquationButton() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACCEPTED CONDITION ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 11, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-342");
		
		Thread.sleep(500);
		
		// Check Accepted Condition Popup Screen Save Equation Button Properties
		saveEquationButtonProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}
	
	public static void saveEquationButtonProps() {
		
		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-342-02", ManageTestsPage.additonalinfopopupscreensaveequationButton,
				"Manage Test - Accepted Condition Popup Screen Save Equation Button Properties");
	}
		
	}


