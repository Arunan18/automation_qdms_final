
//***********************************************************************************
//* Description
//*------------
//* Manage Test Configuration Tab - Pagination DropDown Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 22/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-MT-409          22/06/2023   Sasi     Original Version
//*
//************************************************************************************



package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class PaginationDropdownProperties extends DriverIntialization {
	static ManageTestsPage Managepg = new ManageTestsPage();
	static String code = null;

	@Test
	public static void Popupicon() throws InterruptedException, IOException {
		PageFactory.initElements(driver, Managepg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 1);
		Thread.sleep(1000);
		// Check Test Cancel Button Properties
		ManageTestPaginationDropDownButtonProperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void ManageTestPaginationDropDownButtonProperties() {
		ManageTestsPage Managepg = new ManageTestsPage();
		PageFactory.initElements(driver, Managepg);

//Check Manage Test Pagination DropDown Button Properties
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-409-02",
				ManageTestsPage.paginationdropdownMT, "Manage Test Pagination DropDown Button Properties","1");
	}
}


