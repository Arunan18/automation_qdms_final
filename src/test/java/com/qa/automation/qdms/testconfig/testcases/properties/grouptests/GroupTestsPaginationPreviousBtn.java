/***********************************************************************************
//* Description
//*------------
//* Group Tests - Group Tests Table Pagination Previous Button Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 10/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-GT-116          10/07/2023     K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupTestsPaginationPreviousBtn extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();
	@Test
	public static void grouptestsPaginationPreviousBtn() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		//Calling the method
		grouptestsPaginationPreviousBtnProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void grouptestsPaginationPreviousBtnProperties() {
		PageFactory.initElements(driver, GroupTestpg);

		//Check Group Tests Table Pagination Next Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test","MTC-GT-116-02", GroupTestsPage.grouptestspreviousbtn, "Group Tests Table Pagination Previous Button Properties");
	}
}



