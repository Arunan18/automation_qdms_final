//***********************************************************************************
//* Description
//*------------
//*ACCEPTED VALUE DELETE CANCEL BUTTON FUNCTION -MANAGE TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 17/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis       Comments
//* ================       ====         =====        ========
//MTC-MT-061              17/05/2023  Niluxy    Orginal Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.By;
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

public class AcceptedValueDeleteCancelButtonFunction extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AddGroupKey groupkey = new AddGroupKey();
	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, groupkey);
		
		extent.createTest("TESTCASEN0:MTC-MT-061-ACCEPETED VALUE DELETE CANCEL BUTTON FUNCTION");
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
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-061-01", 1);
	
		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", ManageTestsPage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--ACCEPTED VALUE ICON ENABLED", ManageTestsPage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");
	
		/* SELECT THE DELETE VALUE */
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.testparametertablecontainer, "delete",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-061-01", 2);
        
		//CHECK THE CANCEL BUTTON		
		cancelbutton() ;
		Thread.sleep(2000);
		
		/* PAGE REFRESH */
		Thread.sleep(3000);
		driver.navigate().refresh();

		//LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
	
	// METHOD FOR CLOSE BUTTON FUNCTION
    public static void cancelbutton() {
		if (ManageTestsPage.acceptedvaluedeletecancelbutton.isDisplayed()) {

			testCase = extent.createTest("STEP 5:ACCEPTED VALUE DELETE FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.acceptedvaluedeletecancelbutton.isEnabled()) {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE DELETE FUNCTION- CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.deleteModelWindowContent.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					Thread.sleep(2000);
					ManageTestsPage.acceptedvaluedeletecancelbutton.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.deleteModelWindowContent.isDisplayed()) {
						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE DELETE FUNCTION- CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:ACCEPTED VALUE FUNCTION DELETE MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 8:ACCEPTED VALUE FUNCTION DELETE MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE  DELETE FUNCTION- CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE DELETE FUNCTION- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:ACCEPTED VALUE DELETE FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}


}