//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Action - Edit Pop up Screen "Procedure" UI Heading  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 11/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-394         11/07/2023    N.Karunya   Original Version                
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

public class Managetest_Action_Edit_Popup_Procedure_HeadingProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void procedureHeading() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE ACTION EDIT ICON

		NavigateManageTestFromLogin.clickIcon("Manage Tests", 16, "edit", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-394");

		// Checking Action Edit Popup Procedure Heading UI Properties
		procedureHeadingProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void procedureHeadingProps() {

		PageFactory.initElements(driver, mtp);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-394-02", ManageTestsPage.procedureHeading,
				"Manage Test - Action - Edit Popup - Procedure Heading UI Properties");

	}

}
