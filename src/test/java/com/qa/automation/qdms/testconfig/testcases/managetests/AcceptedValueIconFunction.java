
//***********************************************************************************
//* Description
//*------------
//* ACCEPTED VALUE ICON FUNCTION -MANAGE TEST CONFIGURE
//ICON FUCNTION- MTC-MT-057
//CLOSE BUTTON FUNCTION-MTC-MT-058
//CLOSE ICON FUNCTION-MTC-MT-059
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-057              16/05/2023  Niluxy    Orginal Version
//MTC-MT-058
//MTC-MT-059
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
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AcceptedValueIconFunction extends DriverIntialization {
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
		action.clicking(TestConfigPage.testconfigurationcard, 2000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		action.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		extent.createTest("TESTCASEN0:MTC-MT-057-ACCEPETED VALUE ICON FUNCTION");

		// SCROLLING THE PAGE
		Thread.sleep(2000);
		scroll();

		// CHOOSE THE ACCEPTED VALUE DATA FROM EXCEL
		Thread.sleep(3000);
		AddGroupKey.actionS(0, 8, manage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-057-01", 1);

		extent.createTest("TESTCASEN0:MTC-MT-058-ACCEPETED VALUE CLOSE BUTTON FUNCTION");
		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", manage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--ACCEPTED VALUE ICON ENABLED", manage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");
		
		// CHECK CLOSE BUTTON FUCNTION
		Thread.sleep(2000);
		closeButton();
		
		extent.createTest("TESTCASEN0:MTC-MT-059-ACCEPETED VALUE CLOSE ICON FUNCTION");
		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(2000);
		SampleCommonMethods.methodoneclick("STEP 9: ACCEPTED VALUE ICON PROPERTIES", manage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--ACCEPTED VALUE ICON ENABLED", manage.acceptedvalueEditHeading,
				"Accepted Value", "03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");

		// CHECK CLOSE ICON FUCNTION
		Thread.sleep(2000);
		closeIcon();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// METHOD FOR CLOSE ICON FUNCTION
	public static void closeIcon() {

		if (ManageTestsPage.EditkeytestClose.isDisplayed()) {

			testCase = extent.createTest("STEP 10:ACCEPTED VALUE FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.EditkeytestClose.isEnabled()) {
				testCase = extent.createTest("STEP 11:ACCEPTED VALUE FUNCTION- CLOSE ICON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.EditkeytestClose.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 12:ACCEPTED VALUE  FUNCTION- CLOSE ICON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 13:ACCEPTED VALUE  FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 13:ACCEPTED VALUE  FUNCTION- CLOSE ICON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 12:ACCEPTED VALUE FUNCTION- CLOSE ICON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 11:ACCEPTED VALUE  FUNCTION- CLOSE ICON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 10:ACCEPTED VALUE  FUNCTION- CLOSE ICON DISPLY");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// METHOD FOR CLOSE BUTTON FUNCTION
	public static void closeButton() {

		if (ManageTestsPage.acceptedvalueEditclose.isDisplayed()) {

			testCase = extent.createTest("STEP 5:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON DISPLY");
			testCase.log(Status.PASS, "TEST PASS");
			if (ManageTestsPage.acceptedvalueEditclose.isEnabled()) {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON ENABLED");
				testCase.log(Status.PASS, "TEST PASS");

				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed();
					boolean addmodelwindow = true;
					System.out.println(addmodelwindow);
					ManageTestsPage.acceptedvalueEditclose.click();
					Thread.sleep(2000);
					if (!driver.findElement(By.xpath("//div[@class='ant-modal-content']")).isDisplayed()) {
						addmodelwindow = false;
					}

					boolean clicked = true;

					if (clicked) {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON CLICKED");
						testCase.log(Status.PASS, "TEST PASS");
						System.out.println("MATERIAL" + addmodelwindow);
						if (addmodelwindow == false) {
							System.out.println(addmodelwindow);
							testCase = extent.createTest("STEP 8:ACCEPTED VALUE  FUNCTION MODEL WINDOW CLOSED");
							testCase.log(Status.PASS, "TEST PASS");
						} else {
							testCase = extent
									.createTest("STEP 8:ACCEPTED VALUE FUNCTION- CLOSE ICON MODEL WINDOW NOT CLOSED");
							testCase.log(Status.FAIL, "TEST FAIL");
						}
					} else {
						testCase = extent.createTest("STEP 7:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON NOT CLICKED");
						testCase.log(Status.FAIL, "TEST FAIL");
					}

				} catch (Exception e) {

				}

			} else {
				testCase = extent.createTest("STEP 6:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON IS ENABLED");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest("STEP 5:ACCEPTED VALUE  FUNCTION- CLOSE BUTTON DISPLY");
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
						driver.findElement(By.xpath("//th[normalize-space()='Accepted Value']")).click();
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
