//***************************************************************************************
//* Description
//*------------
//*  Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value - Action - Delete Pop up Screen- "?" icon Properties 
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 21/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0700			21/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedvalueActionDeleteIconProperties extends DriverIntialization {
	static TestConfigPage testconfigpg = new TestConfigPage();

	@Test
	public static void action() throws InterruptedException, IOException {

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0700");

		// ACCEPTED CRITERIA
		acceptedCriteria();
 
		// SELECT THE DELETE CONFIGURE DISPLAYED & ENABLED
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.managetexttablecontainer, "delete",
				"Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0700-01", 3);

		// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN - "?" ICON PROPERTIES CHECK
		questioniconproperties();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED CRITERIA PATH
	public static void acceptedCriteria() {
		PageFactory.initElements(driver, testconfigpg);

		// Test Configure Button Click
		try {
			Thread.sleep(1000);
			TestConfigPage.testconfigureleftnavigation.click();

			// Accepted Criteria Button Click
			try {
				TestConfigPage.Acceptedcriteria.click();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Check the Test Configure Left button");
				testCase.log(Status.INFO, "Test Configure Left button is not Found");
				testCase.log(Status.FAIL, "Test Configure Left button is not Found");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Check the Test Configure Left button Click");
				testCase.log(Status.INFO, "Test Configure Left button is not Clicked");
				testCase.log(Status.FAIL, "Test Configure Left button is not Clicked");
			} catch (Exception e) {
				testCase = extent.createTest("Check the Test Configure Left button");
				testCase.log(Status.INFO, "Test Configure Left button Error");
				testCase.log(Status.FAIL, "Test Configure Left button Error");
			}
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Check the Accepted Criteria button");
			testCase.log(Status.INFO, "Accepted Criteria button is not Found");
			testCase.log(Status.FAIL, "Accepted Criteria button is not Found");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Check the Accepted Criteria button Click");
			testCase.log(Status.INFO, "Accepted Criteria button is not Clicked");
			testCase.log(Status.FAIL, "Accepted Criteria button is not Clicked");
		} catch (Exception e) {
			testCase = extent.createTest("Check the Accepted Criteria");
			testCase.log(Status.INFO, "Accepted Criteria button Error");
			testCase.log(Status.FAIL, "Accepted Criteria button Error");
		}
	}

	// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN - "?" ICON PROPERTIES CHECK
	public static void questioniconproperties() {
		PageFactory.initElements(driver, testconfigpg);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0700-02",
				TestConfigPage.questionicon, "Accepted Value - Action - Delete Pop up Screen - '?' icon Properties");

	}

}
