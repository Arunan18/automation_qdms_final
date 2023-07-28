
//***********************************************************************************
//* Description
//*------------
//TEST EDIT CLOSE BUTTON FUNCTION
//CLOSE FUCNTION
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 15/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-045             15/05/2023     Niluxy       Original Version

//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestEditCloseButtonFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();

	@Test
	public static void editCloseFunction() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		;
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupkey);

		extent.createTest("TESTCASEN0:MTC-MT-045-TEST EDIT ICON CLOSE BUTTON FUNCTION");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHOOSE THE KEY TEST DATA FROM EXCEL
		AddGroupKey.actionS(0, 16, ManageTestsPage.managetexttablecontainer, "edit", "Test Configuragtion Module.xlsx",
				"Manage_Tests", "MTC-MT-045-01", 1);

//			/* KEY TEST ICON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP 4: TEST EDIT ICON PROPERTIES", ManageTestsPage.Editkeytestediticon,
				"01--TEST EDIT ICON DISPLAYED", "02--TEST EDIT ICON ENABLED", ManageTestsPage.Editkeytestheading,
				"Edit Test Configuration", "03--ON CLICK THE TEST EDIT ICON IT'S REDERECT TO CORRECT WINDOW");

		// CHECK CLOSE BUTTON FUCNTION
		closefunction();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	// METHOD FOR CLOSE FUNCTION
	public static void closefunction() {

		if (ManageTestsPage.EditkeytestClose.isDisplayed()) {

			testCase = extent.createTest("STEP 5:TEST EDIT FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.EditkeytestClose.isEnabled()) {
				testCase = extent.createTest("STEP 6:TEST EDIT FUNCTION- CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.EditkeytestModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.EditkeytestClose.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.EditkeytestModelwindow.isDisplayed()) {
//						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:TEST EDITFUNCTION- CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:TEST EDITFUNCTION- MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest("STEP 8:TEST EDITFUNCTION- MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:TEST EDITFUNCTION- CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:TEST EDITFUNCTION- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:TEST EDIT FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
