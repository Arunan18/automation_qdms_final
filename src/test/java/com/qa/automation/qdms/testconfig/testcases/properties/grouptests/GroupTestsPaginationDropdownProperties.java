/***********************************************************************************
//* Description
//*------------
//* Manage Tests Configure - Group Tests -Drop down Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 12/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-117          12/07/2023   K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupTestsPaginationDropdownProperties extends DriverIntialization  {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	@Test
	public static void groupTestsDropdown() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		groupTestsDropdownProperties();

		// REFRESH
		driver.navigate().refresh();

		Thread.sleep(1000);

		// LOGOU
		Logout.LogoutFunction();
	}
	public static void groupTestsDropdownProperties() {	
		PageFactory.initElements(driver, GroupTestpg);

		//Check GroupTests Pagination Drop down Properties
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-117-02", GroupTestsPage.grouptestsdropdown, "GroupTests Pagination Dropdown Properties","1");
	}		
}


