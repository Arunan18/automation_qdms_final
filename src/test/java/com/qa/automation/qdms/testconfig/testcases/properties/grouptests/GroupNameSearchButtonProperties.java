

//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Group Name Search Button Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 24/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*   MTC-GT-025 		 24/06/2023     Sasi     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.properties.grouptests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class GroupNameSearchButtonProperties extends DriverIntialization{
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void GroupNameTextBox() throws InterruptedException, IOException {
		PageFactory.initElements(driver, GroupTestpg);

		// Login System & Reach Manage Test
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Group Tests", 1);

		// Click Manage Test Group Test Button & Check Group Test Button Properties
		GroupTestClickIcon();

		// Driver Refresh
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// Click Manage Test Group Test Button
	public static void GroupTestClickIcon() throws IOException, InterruptedException {
		
		try {

			// Click on Relevant Icon
			GroupTestsPage.groupNameSearchicon.click();

			testCase = extent.createTest("Group Name Search Button");
			testCase.log(Status.INFO, "Clicked on the element 'Group Name Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			GroupNameSearchButtonProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Group Name Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Group Name Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Group Name Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Group Name Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Group Name Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void GroupNameSearchButtonProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Group Name Search Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-025-02",
				GroupTestsPage.groupNameSearchButton, "Group Name Search Button Properties");
	}
}

