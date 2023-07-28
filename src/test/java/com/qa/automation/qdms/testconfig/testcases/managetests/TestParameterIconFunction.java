
//***********************************************************************************
//* Description
//*------------
//* TEST PARAMETER ICON FUNCTION -MANAGE TEST CONFIGURE
//ICON FUCNTION- 051
//CLOSE ICON FUCNTION-052
//CLOSE BUTTON FUCNTION-054
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-051             16/05/2023    Niluxy    Original Version
//MTC-MT-052
//MTC-MT-054
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParameterIconFunction extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static AddGroupKey groupkey = new AddGroupKey();

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, actions);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupkey);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHOOSE THE KEY TEST DATA FROM EXCEL
		Thread.sleep(2000);
		AddGroupKey.actionS(0, 7, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-051-01", 1);

		extent.createTest("TESTCASEN0:MTC-MT-051-TEST PARAMETER ICON FUNCTION");

		// TEST PARAMETER ICON PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP 4: TEST PARAMETER ICON PROPERTIES", ManageTestsPage.TestparameterIcon,
				"01--TEST PARAMETER ICON DISPLAYED", "02--TEST PARAMETER ICON ENABLED",
				ManageTestsPage.Editkeytestheading, "Test Parameters",
				"03--ON CLICK THE TEST PARAMETER ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:MTC-MT-054-TEST PARAMETER CLOSE ICON FUNCTION");

		// CHECK CLOSE ICON FUCNTION
		closeIcon();

		// TEST PARAMETER ICON PROPERTIES DISPLAYED & ENABLED
		SampleCommonMethods.methodoneclick("STEP 9: TEST PARAMETER ICON PROPERTIES", ManageTestsPage.TestparameterIcon,
				"01--TEST PARAMETER ICON DISPLAYED", "02--TEST PARAMETER ICON ENABLED",
				ManageTestsPage.Editkeytestheading, "Test Parameters",
				"03--ON CLICK THE TEST PARAMETER ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:MTC-MT-052-TEST PARAMETER CLOSE BUTTON FUNCTION");

		// CHECK CLOSE BUTTON FUCNTION
		closeButton();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CLOSE ICON FUNCTION
	public static void closeIcon() {

		if (ManageTestsPage.EditkeytestClose.isDisplayed()) {

			testCase = extent.createTest("STEP 5:TEST PARAMETER FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.EditkeytestClose.isEnabled()) {
				testCase = extent.createTest("STEP 6:TEST PARAMETER FUNCTION- CLOSE ICON ENABLED");
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
						testCase = extent.createTest("STEP 7:TEST PARAMETER FUNCTION- CLOSE ICON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:TEST PARAMETER FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 8:TEST PARAMETER FUNCTION- CLOSE ICON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:TEST PARAMETER FUNCTION- CLOSE ICON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:TEST PARAMETER FUNCTION- CLOSE ICON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:TEST PARAMETER FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// METHOD FOR CLOSE BUTTON FUNCTION
	public static void closeButton() {

		if (ManageTestsPage.Testparameterclosebuttonedit.isDisplayed()) {

			testCase = extent.createTest("STEP 10:TEST PARAMETER FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.Testparameterclosebuttonedit.isEnabled()) {
				testCase = extent.createTest("STEP 11:TEST PARAMETER FUNCTION- CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.EditkeytestModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.Testparameterclosebuttonedit.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.EditkeytestModelwindow.isDisplayed()) {
//						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 12:TEST PARAMETER FUNCTION- CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 13:TEST PARAMETER FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest(
									"STEP 13:TEST PARAMETER FUNCTION- CLOSE BUTTON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 12:TEST PARAMETER FUNCTION- CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 11:TEST PARAMETER FUNCTION- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 10:TEST PARAMETER FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
