
//***********************************************************************************
//* Description
//*------------
//* ACCEPTED VALUE EDIT CLOSE AND CANCEL BUTTON  FUNCTION -MANAGE TEST CONFIGURE
//EDIT CLOSE ICON FUCNTION- MTC-MT-066
//EDIT CANCEL BUTTON -MTC-MTC-MT-067
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-066              16/05/2023  Niluxy    Orginal Version
//MTC-MT-067
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.By;
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

public class AcceptedValueEditCloseandCancelButtonFunction extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupkey);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// SCROLLING THE PAGE
		Thread.sleep(2000);
		AcceptedValueIconFunction.scroll();

		// CHOOSE THE ACCEPTED VALUE DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-066-01", 1);

		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", ManageTestsPage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--EQUATION ICON ENABLED", ManageTestsPage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:TC-MT-066-ACCEPETED VALUE EDIT CLOSE ICON FUNCTION");
		
		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 5: ACCEPTED VALUE EDIT ICON PROPERTIES", ManageTestsPage.acceptedvalueEditIcon,
				"01--ACCEPTED VALUE EDIT ICON DISPLAYED", "02--ACCEPTED VALUE EDIT ICON ENABLED",
				ManageTestsPage.acceptedvalueinsideEditHeading, "Edit Accepted Value",
				"03--ON CLICK THE ACCEPTED VALUE EDIT ICON IT'S REDERECT TO CORRECT WINDOW");

		// CHECK CLOSE ICON FUCNTION
		Thread.sleep(3000);
		closeIcon();

		extent.createTest("TESTCASEN0:TC-MT-067-ACCEPETED VALUE EDIT CANCEL BUTTON FUNCTION");
		
		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(2000);
		SampleCommonMethods.methodoneclick("STEP 5: ACCEPTED VALUE EDIT ICON PROPERTIES", ManageTestsPage.acceptedvalueEditIcon,
				"01--ACCEPTED VALUE EDIT ICON DISPLAYED", "02--ACCEPTED VALUE EDIT ICON ENABLED",
				ManageTestsPage.acceptedvalueinsideEditHeading, "Edit Accepted Value",
				"03--ON CLICK THE ACCEPTED VALUE EDIT ICON IT'S REDERECT TO CORRECT WINDOW");
        Thread.sleep(1000);
		// CHECK CANCEL BUTTON FUCNTION
		cancelButton();
		
		// CLICK ON THE CLOSE ICON
		Thread.sleep(1000);
		SampleActionMethods.clicking(ManageTestsPage.EditkeytestClose, 20, "STEP 14:CHECKING THE CLOSE ICON");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CLOSE ICON FUNCTION
	public static void closeIcon() {

		if (ManageTestsPage.acceptedvalueinsideEditcloseicon.isDisplayed()) {

			testCase = extent.createTest("STEP 5:ACCEPTED VALUE  EDIT FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.acceptedvalueinsideEditcloseicon.isEnabled()) {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE EDIT FUNCTION- CLOSE ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.editModelWindowContent.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					Thread.sleep(2000);
					ManageTestsPage.acceptedvalueinsideEditcloseicon.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.editModelWindowContent.isDisplayed()) {
						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE EDIT  FUNCTION- CLOSE ICON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:ACCEPTED VALUE EDIT FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest(
									"STEP 8:ACCEPTED VALUE EDIT  FUNCTION- CLOSE ICON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE EDIT FUNCTION- CLOSE ICON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE EDIT FUNCTION- CLOSE ICON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:ACCEPTED VALUE EDIT  FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// METHOD FOR CANCEL BUTTON FUNCTION
	public static void cancelButton() {

		if (ManageTestsPage.acceptedvalueinsideEditcancelbutton.isDisplayed()) {

			testCase = extent.createTest("STEP 10:ACCEPTED VALUE EDIT FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.acceptedvalueinsideEditcancelbutton.isEnabled()) {
				testCase = extent.createTest("STEP 11:ACCEPTED VALUE EDIT FUNCTION- CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.editModelWindowContent.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					Thread.sleep(2000);
					ManageTestsPage.acceptedvalueinsideEditcancelbutton.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.editModelWindowContent.isDisplayed()) {
						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 12:ACCEPTED VALUE EDIT FUNCTION- CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 13:ACCEPTED VALUE EDIT FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent.createTest(
									"STEP 13:ACCEPTED VALUE EDIT  FUNCTION CANCEL BUTTON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent
								.createTest("STEP 12:ACCEPTED VALUE EDIT  FUNCTION- CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 11:ACCEPTED VALUE EDIT FUNCTION- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 10:ACCEPTED VALUE EDIT  FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

}
