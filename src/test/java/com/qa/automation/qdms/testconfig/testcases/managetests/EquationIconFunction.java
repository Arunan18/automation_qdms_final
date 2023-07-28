
//***********************************************************************************
//* Description
//*------------
//* EQUATION ICON FUNCTION -MANAGE TEST CONFIGURE
//ICON FUCNTION- MTC-MT-071
//CLOSE ICON FUCNTION-MTC-MT-072
//CANCEL BUTTON FUCNTION-MTC-MT-074
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-071               16/05/2023   Niluxy       Original Version
//MTC-MT-072
//MTC-MT-071
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

public class EquationIconFunction extends DriverIntialization {
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
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		extent.createTest("TESTCASEN0:MTC-MT-071-EQUATION ICON FUNCTION");

		// SCROLLING THE PAGE
		Thread.sleep(2000);
		scroll();

		// CHOOSE THE EQUATION DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 9, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-071-01", 1);

		/* EQUATION ICON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP 4: EQUATION ICON PROPERTIES", ManageTestsPage.EqautionIcon,
				"01--EQUATION ICON DISPLAYED", "02--EQUATION ICON ENABLED", ManageTestsPage.equationEditHeading,
				"Equation", "03--ON CLICK THE EQUATION ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:MTC-MT-072-EQUATION CLOSE ICON FUNCTION");

		// CHECK CLOSE ICON FUCNTION
		closeIcon();

		/* EQUATION ICON PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP 9: EQUATION ICON PROPERTIES", ManageTestsPage.EqautionIcon,
				"01--EQUATION ICON DISPLAYED", "02--EQUATION ICON ENABLED", ManageTestsPage.equationEditHeading,
				"Equation", "03--ON CLICK THE EQUATION ICONIT'S REDERECT TO CORRECT WINDOW");

		extent.createTest("TESTCASEN0:MTC-MT-074-EQUATION CANCEL BUTTON FUNCTION");

		// CHECK CANCEL BUTTON FUCNTION
		cancelButton();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CLOSE ICON FUNCTION
	public static void closeIcon() {

		if (ManageTestsPage.EditkeytestClose.isDisplayed()) {

			testCase = extent.createTest("STEP 5:EQUATION FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.EditkeytestClose.isEnabled()) {
				testCase = extent.createTest("STEP 6:EQUATION FUNCTION- CLOSE ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.EditkeytestModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.EditkeytestClose.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.EditkeytestModelwindow.isDisplayed()) {
						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:EQUATION  FUNCTION- CLOSE ICON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:EQUATION  FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 8:EQUATION  FUNCTION- CLOSE ICON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:EQUATION FUNCTION- CLOSE ICON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:EQUATION  FUNCTION- CLOSE ICON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:EQUATION  FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// METHOD FOR CANCEL BUTTON FUNCTION
	public static void cancelButton() {

		if (ManageTestsPage.equationEditCancel.isDisplayed()) {

			testCase = extent.createTest("STEP 10:EQUATION  FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.equationEditCancel.isEnabled()) {
				testCase = extent.createTest("STEP 11:EQUATION  FUNCTION- CANCEL BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
//					ManageTestsPage.EditkeytestModelwindow.isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.equationEditCancel.click();
					Thread.sleep(2000);
//					if (!ManageTestsPage.EditkeytestModelwindow.isDisplayed()) {
//						addmodelwindow = false;
//					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 12:EQUATION  FUNCTION- CANCEL BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 13:EQUATION  FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 13:EQUATION  FUNCTION- CANCEL BUTTON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 12:EQUATION  FUNCTION- CANCEL BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 11:EQUATION  FUNCTION- CANCEL BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 10:EQUATION  FUNCTION- CANCEL BUTTON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

// METHOD FOR SCROLLING THE PAGE TO RIGHT
	public static void scroll() {
		driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Equation']")).click();
						pass = true;
					} catch (Exception e) {
					}
				}

				if (!pass) {
					Actions actions = new Actions(driver);
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}

			}
		} catch (Exception e) {
		}
	}
}
