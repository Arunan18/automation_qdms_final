/***********************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab - Due Day  - TextBox UI Properties
//***********************************************************************************
//*
//* Author           : Saranga Kanthathasan
//* Date Written     : 17/07/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-158         17/07/2023      K.Saranga     Original Version
//*
//************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ManageTestConfigurationDueDayTextBox extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();
	@Test

	public static void testTypeDropDownProperties ()
			throws InterruptedException, IOException {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

		// Navigate Test Config
		TestConfigNavigation.TestConfigurationCard();

		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(configGroupTestsPage.mainManagetestConfigureNavication));
			ActionCommonMethod.visbleEnable2(configGroupTestsPage.mainManagetestConfigureNavication,
					"Manage Tests Configure Navication", 1);
			configGroupTestsPage.mainManagetestConfigureNavication.click();

			//CALLING THE METHOD
			configurationDueDayTextBox ();

		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		}

		// Click the Refresh
		Thread.sleep(1000);
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();
	}
	public static void configurationDueDayTextBox () throws InterruptedException {
		PageFactory.initElements(driver, mtp);

		Thread.sleep(2000);

		try {
			ManageTestsPage.dueDaySearchIcon.click();

			testCase = extent.createTest("Checking Due Day Search Icon");
			testCase.log(Status.INFO, "Due Day Search Icon is Clicked ");
			testCase.log(Status.PASS, "TEST PASS");

			//Calling the method
			configurationDueDayTextBoxProperties ();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Due Day Search Icon");
			testCase.log(Status.INFO, "Unable to Locate Due Day Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Due Day Search Icon");
			testCase.log(Status.INFO, "Due Day Search Icon is not Clicked");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking Due Day Search Icon");
			testCase.log(Status.INFO, "Due Day Search Icon Click is not Occured");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
	}
	public static void configurationDueDayTextBoxProperties () throws InterruptedException {
		PageFactory.initElements(driver, mtp);

		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Manage_Tests","MTC-MT-158-02",ManageTestsPage.dueDayTextBox,"testConfigure Due Day TextBox  Properties");
	}
}





