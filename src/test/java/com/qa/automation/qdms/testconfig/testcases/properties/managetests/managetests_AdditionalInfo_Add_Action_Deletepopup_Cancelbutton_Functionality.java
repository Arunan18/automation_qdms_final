//***************************************************************************************
//* Description
//*------------
//* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- Action- Delete Pop up Screen  "Cancel" button Functionality
//***************************************************************************************
//*
//* Author           : N.Karunya
//* Date Written     : 12/07/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-312         12/07/2023    N.Karunya   Original Version                
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class managetests_AdditionalInfo_Add_Action_Deletepopup_Cancelbutton_Functionality extends DriverIntialization {

	static ManageTestsPage mtp = new ManageTestsPage();
	
	@Test
	public static void deletepopupCancelbutton() throws InterruptedException, IOException {

//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickandClickIcon("Manage Tests", 10, "Description",
				"Test Configuration Properties", "Manage_Tests", "MTC-MT-312", 2);

//		Check Additional Information Pop-up-Add Field- Action -Delete Popup "Cancel" button Functionality Properties
		if (NavigateManageTestFromLogin.clicked) {
			Thread.sleep(500);
			deletepopupCancelbuttonFunctionality();
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();

	}

	public static void deletepopupCancelbuttonFunctionality() throws InterruptedException {

		PageFactory.initElements(driver, mtp);
		Thread.sleep(1000);

		try {
			if (ManageTestsPage.additionalinfoPopupDeletePopupcancelBtn.isDisplayed()) {
				testCase = extent.createTest("Additional Information Add Field Delete Popup Screen Cancel Button is Displayed");
				testCase.log(Status.INFO, "Additional Information Add Field Delete Popup Screen Cancel Button is Displayed ");
				testCase.log(Status.PASS, "TEST PASS");

				if (ManageTestsPage.additionalinfoPopupDeletePopupcancelBtn.isEnabled()) {
					testCase = extent.createTest("Additional Information Add Field Delete Popup Screen Cancel Button is Enabled");
					testCase.log(Status.INFO, "Additional Information Add Field Delete Popup Screen Cancel Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");

				} else {
					testCase = extent.createTest("Additional Information Add Field Delete Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.INFO, "Additional Information Add Field Delete Popup Screen Cancel Button is not Enabled");
					testCase.log(Status.FAIL, "TEST FAIL");
				}
			} else {
				testCase = extent.createTest("Additional Information Add Field Delete Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.INFO, "Additional Information Add Field Delete Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The Additional Information Add Field Delete Popup Screen Cancel Button");
			testCase.log(Status.INFO, "Additional Information Add Field Delete Popup Screen Cancel Button is not available");
			testCase.log(Status.FAIL, "TEST FAIL");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Additional Information Add Field Delete Popup Screen Cancel Button");
			testCase.log(Status.INFO,"Unable to check the functionality of Additional Information Add Field Delete Popup Screen Cancel Button");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
