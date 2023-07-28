
//***********************************************************************************
//* Description
//*------------
//* Manage Test Configuration Tab - Pagination Previous button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-MT-408          22/06/2023   Sasi     Original Version
//*
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

public class PaginationPreviousButtonProperties extends DriverIntialization {
	static ManageTestsPage Managepg = new ManageTestsPage();
	static String code = null;

	@Test
	public static void Popupicon() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Managepg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);

		// Check Test Cancel Button Properties
		ManageTestNextButtonProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void ManageTestNextButtonProperties() {
		ManageTestsPage Managepg = new ManageTestsPage();
		PageFactory.initElements(driver, Managepg);

//Check Manage Test Next Arrow Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-408-02",
				ManageTestsPage.previousButtonMT, "Manage Test Next Button Properties");
	}
}
