
//****************************************************************************************
//		DESCRIPTION
//------------------
//					CUSTOMER BUTTON FUNCTIONALITY TEST
//							Author :-		 @SASIKALA AMBALAVANAR
//							DATE Written:-   22:03:2023	
//****************************************************************************************
//* Test Case Number     	  Date          Intis        Comments
//* ================       	  ======       ========      ========
//*  TC-CUS-0002             22:03:2023   @SASIKALA     Original Version
//*							11.07.2023    @Sasikala      Modified
//************************************************************************************

package com.qa.automation.qdms.testcases.customer;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.CustomerPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.source.SourceTest;

public class CustomerButtonFunctionality extends DriverIntialization {
	static CustomerPage customerfunpg = new CustomerPage();
	static boolean work = false;

//***************** LOGIN FUNCTION & REACH CUSTOMER ***************************
	@Test
	public void customerButtonfunction() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		// Login Functional
		LoginTest.Login();

		// Click Master Card
		wait.until(ExpectedConditions.elementToBeClickable(CustomerPage.Master));
		if (LoginTest.login) {
			SourceTest.CommonMethod(CustomerPage.Master, "Master Card");
		}

		// Click Customer Top Menu
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customertopmenu, "Customer Top Menu Card");
		}

		// Customer Site Button
		if (SourceTest.work) {
			work = false;
			SourceTest.CommonMethod(CustomerPage.Customersitebutton, "Customer Site Bar Button");
		}

		// Customer Site Button
		if (SourceTest.work) {
			work = false;
			customerSiteButtonconfirmMethod();
		}

		driver.navigate().refresh();

		// Logout Functionality
		if (LoginTest.login) {
			Logout.LogoutFunction();
		}
	}

// ************************** Customer Site Button ******************************

	public static void customerSiteButtonconfirmMethod() throws InterruptedException {
		PageFactory.initElements(driver, customerfunpg);

		try {

			String Value = CustomerPage.CustomerHeader.getText();

			TestCasePrint("CONFIRM CUSTOMER VIEW", "Customer Details", String.valueOf(Value));
		} catch (Exception e) {
			TestCasePrint("CONFIRM CUSTOMER VIEW", "", String.valueOf(e));
		}

	}

// ************************* Test Report Method *************************

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
