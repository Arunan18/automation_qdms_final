
//***********************************************************************************
//* Description
//*------------
//* Manage Test Tab Group Test - "Sub Category" Search icon Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 25/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-034          25/06/2023   Sasi     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class SubCategorySearchIconProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void SubCategoryHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		subCategoryHeadingProperties();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void subCategoryHeadingProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Group Test Button Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-034-02",
				GroupTestsPage.subCategorySearchicon, "Sub Category Seach Icon Properties");
	}
}
