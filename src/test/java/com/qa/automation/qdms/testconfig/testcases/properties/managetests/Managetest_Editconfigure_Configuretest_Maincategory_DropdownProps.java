//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Configure Test-"Main Category" Drop Down  Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-358         12/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class Managetest_Editconfigure_Configuretest_Maincategory_DropdownProps extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void maincategoryDropdown() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-358");

		// Checking Manage Test- Configuration Tab- "Edit Configure"- Configure
		// Test-"Maincategory" Dropdown Properties
		maincategoryDropdownProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void maincategoryDropdownProps() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(3000);
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-358-02",
				ManageTestsPage.configuretestmaincategrydropdown,
				"Manage Test - Configuration Tab- Edit Configure Test -Maincategory Dropdown Properties","3");

	}

}

