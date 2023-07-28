//***************************************************************************************
//* Description
//*------------
//* Test Configure - Configure Test Table-  Top Bar Accepted criteria  - Accepted Value - Action - Delete Pop up Screen- "Cancel" button Functionality
//***************************************************************************************
//*
//* Author           : S.Gobithan
//* Date Written     : 23/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0703			23/06/2023    S.Gobithan   Original Version  
//*                    
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;
import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedvalueActionDeleteCancelButtonFunctionality extends DriverIntialization {

	@Test
	public static void action() throws InterruptedException, IOException {
		AcceptedvalueActionDeleteIconProperties iconproperty = new AcceptedvalueActionDeleteIconProperties();
		PageFactory.initElements(driver, iconproperty);

		// MANAGE TEST PAGE PATH FROM LOGIN
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0703");

		if (NavigateManageTestFromLogin.clicked) {
			// ACCEPTED CRITERIA
			AcceptedvalueActionDeleteIconProperties.acceptedCriteria();
		}
		// SELECT THE DELETE CONFIGURE DISPLAYED & ENABLED
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.managetexttablecontainer, "delete",
				"Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0703-01", 3);

		// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "CANCEL" BUTTON FUNCTIONALITY
		cancelButtonFunctionality();

		// LOGOUT
		Logout.LogoutFunction();
	}

	// ACCEPTED VALUE - ACTION - DELETE POP UP SCREEN- "CANCEL" BUTTON FUNCTIONALITY
	public static void cancelButtonFunctionality() {
		TestConfigPage testconfigpg = new TestConfigPage();
		PageFactory.initElements(driver, testconfigpg);

		try {
			// CANCEL BUTTON DISPLAY
			if (TestConfigPage.popupcancelbtn.isDisplayed()) {
				testCase = extent
						.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button is Displayed");
				testCase.log(Status.PASS, "TEST PASS ");
				testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button is Displayed");
			} else {
				testCase = extent
						.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button is Not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
				testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button is Not Displayed");
			}

			// CANCEL BUTTON ENABLE
			if (TestConfigPage.popupcancelbtn.isEnabled()) {
				testCase = extent
						.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button is Enabled");
				testCase.log(Status.PASS, "TEST PASS");
				testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button is Enabled");
			} else {
				testCase = extent
						.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button is Not Enabled");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
				testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button is Not Enabled");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button is not Found");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
			testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button is not Found");
		} catch (Exception e) {
			testCase = extent.createTest("Accepted Value - Action - Delete Pop up Screen- Cancel button Error");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
			testCase.log(Status.INFO, "Accepted Value Action Delete Pop up Screen Cancel button Error");
		}

	}

}
