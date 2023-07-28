//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- "Edit Configure"- Configure Test-"Report Format" Drop Down Properties
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-MT-363         12/07/2023    N.Karunya   Original Version                
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

public class Managetest_Editconfigure_Configuretest_ReportFormat_DropdownProps extends DriverIntialization {
	
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test
	public static void reportFormatDropdown() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE EDIT CONFIGURE ICON
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-363");

		// Checking Manage Test- Configuration Tab- "Edit Configure"- Configure
		// Test-"ReportFormat" Dropdown Properties
		reportFormatDropdownProps();

		// REFRESH
		driver.navigate().refresh();
		Thread.sleep(1000);

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void reportFormatDropdownProps() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(3000);
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-363-02",
				ManageTestsPage.configuretestReportFormatdropdown,
				"Manage Test - Configuration Tab- Edit Configure Test -Maincategory Dropdown Properties", "3");

	}
}
