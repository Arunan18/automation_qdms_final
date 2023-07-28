
//***********************************************************************************
//* Description
//*------------
//* Manage Test "Group Test" - Sub Category Search TextBox Properties
//***********************************************************************************
//*
//* Author           : Sasikala Ambalavanar
//* Date Written     : 25/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  MTC-GT-036      	 25/06/2023      Sasi     Original Version
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

public class SubCategorySearchTextBoxProperties extends DriverIntialization {
	static GroupTestsPage GroupTestpg = new GroupTestsPage();

	@Test
	public static void SubCategoryTextBox() throws InterruptedException, IOException {
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
			GroupTestsPage.subCategorySearchicon.click();

			testCase = extent.createTest("Sub Category Search TextBox Filed");
			testCase.log(Status.INFO, "Clicked on the element 'Sub Category Search Icon'");
			testCase.log(Status.PASS, "TEST PASS ☑");

			Thread.sleep(1000);

			// Calling the method
			SubCategoryTextBoxProperties();

		} catch (NoSuchElementException e) {
			extent.createTest("Sub Category Search Icon Element Identify");
			testCase.log(Status.INFO, "Unable to Locate the element 'Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Delete ?  Element Click Interupted");
			testCase.log(Status.INFO, "Unable to Click on the element 'Sub Category Search Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		} catch (Exception e) {
			testCase = extent.createTest("Sub Category Search Icon' Checking Terminated");
			testCase.log(Status.INFO, "'Sub Category Search Icon' IS ENABLE OR VISIBLE");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

	public static void SubCategoryTextBoxProperties() {
		GroupTestsPage GroupTestpg = new GroupTestsPage();
		PageFactory.initElements(driver, GroupTestpg);

		// Check Sub Category PopUp Properties
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Group_Test", "MTC-GT-036-02",
				GroupTestsPage.subCategoryTextBox, "Sub Category TextBox Properties");
	}
}
