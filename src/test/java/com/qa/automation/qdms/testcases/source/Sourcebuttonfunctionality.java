
//****************************************************************************************
//		DESCRIPTION
//------------------
//					SOURCE BUTTON FUNCTIONALITY TEST
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   21:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-SRC-0002             21:03:2023   @SASIKALA     Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testcases.source;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.pages.master.SourcePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;

public class Sourcebuttonfunctionality extends DriverIntialization {
	static SourcePage Sourcepg = new SourcePage();
	static boolean work = false;

// ***********************LOGIN FUNCTION & REACH SOURCE*************************

	@Test
	public static void SourcePathMethod() throws InterruptedException {
		PageFactory.initElements(driver, Sourcepg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Login Test
		LoginTest.Login();

		wait.until(ExpectedConditions.elementToBeClickable(SourcePage.Master));

		// Master Card Click
		SourceTest.CommonMethod(SourcePage.Master, "Master Card");

		if (SourceTest.work) {
			work = false;
			// Material Top Master Card Click
			SourceTest.CommonMethod(SourcePage.Materialtopbar, "Material Top Bar");
		}
		
		if (SourceTest.work) {
			work = false;
		// Click Source Module
		SourceTest.CommonMethod(SourcePage.sourcesitebar, "Source Side Button");
		}
		
		if (SourceTest.work) {
			work = false;
		// Check Source Side Button
		SourceSideConfirmMethod();
		}
		
		driver.navigate().refresh();

		// Logout Function
		MultiSearchMethods.Logout();
	}

// *************************************************************************************

	public static void SourceSideConfirmMethod() throws InterruptedException {
		SourcePage Sourcepg = new SourcePage();
		PageFactory.initElements(driver, Sourcepg);

		try {

			String Value = SourcePage.Sourceheader.getText();

			TestCasePrint("CONFIRM SOURCE VIEW", "Source", String.valueOf(Value));
			testCase.log(Status.INFO, "Actual Displayed:- Source Button Displayed Confirmation");
			testCase.log(Status.PASS, " Correct");

		} catch (Exception e) {
			TestCasePrint("CONFIRM SOURCE VIEW", "", String.valueOf(e));
			testCase.log(Status.INFO, "Expected Displayed:- Unable To Confirm Source Button");
			testCase.log(Status.PASS, " Wrong");
		}

	}
//***************************************************************************************

	public static void TestCasePrint(String TestCaseName, String expectedValue, String actualValue) {
		boolean position = true;
		ExtentTest testCase = extent.createTest(TestCaseName);
		try {
			AssertJUnit.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			position = false;
		}
		if (position) {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "Expectedvalue :- " + expectedValue);
			testCase.log(Status.INFO, "Correct value");
			testCase.log(Status.PASS, actualValue);
		} else {
			testCase.log(Status.INFO, "Actualvalue :- " + actualValue);
			testCase.log(Status.INFO, "ExpectedValue :- " + expectedValue);
			testCase.log(Status.INFO, "wrong value");
			testCase.log(Status.FAIL, actualValue);
		}
	}

}
