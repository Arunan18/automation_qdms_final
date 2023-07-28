
//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Group Type Search Dropdown Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 26/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-048      	 26/06/2023      Sasi     Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupTypeSearchDropdownProperties extends DriverIntialization{
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void mainCategoryTextBox() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		groupTypeClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Test Button
	public static void groupTypeClickIcon() throws IOException, InterruptedException {
		
		try {

			// Click on Relevant Icon
			GroupTestsPage.groupTypesSearchicon.click();

			testCase = extent.createTest("Group Type Search Icon");
			testCase.log(Status.INFO, "Clicked on the element 'Group Type Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			groupTypedropdownProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Group Type Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Delete ?  Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Group Type Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Group Type Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Group Type Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void groupTypedropdownProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Group Type PopUp Properties
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-048-02",
				GroupTestsPage.groupTypedropdown, "Group Type DropDown Properties","1");
	}
}

