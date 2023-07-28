//***********************************************************************************
//* Description
//*------------
//* Manage Test Accepted value Edit Function
//***********************************************************************************
//*
//* Author           : Mathusan 
//* Date Written     :17/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-065			 17/05/2023    Mathusan     Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AcceptedValueEditButtonFunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
     static AddGroupKey AGK =new AddGroupKey();
	@Test

	public static void TestAddvalueEditFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

		PageFactory.initElements(driver, ACM);

		// Click LOGIN Button
		LoginTest.Login();

		// PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		// MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGER TOP NAVIGATION PROPERTIES",
				TestConfigPage.MANGECONFIGURE, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", TestConfigPage.GroupTest,
				TestConfigPage.managetest, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		// MANAGE TESTS PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TESTS PROPERTIES", TestConfigPage.managetest,
				"01--MANAGE TEST LEFT NAVIGATION BUTTON DISPLAYED", "02--MANAGE TEST LEFT NAVIGATION BUTTON ENABLED",
				ManageTestsPage.managetestheading, "Manage Test Configuration",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// Click the Manage Configure Scorall Page
		managetestconfigurationscorallpage();

		// Click the Select Accepted Value
		SelectAcceptedValue();

		// Click the Refresh
		Thread.sleep(1000);
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() {
		try {
			TestConfigPage.managetestcongigurescrollpage.click();
			testCase = extent.createTest("CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.PASS, "TEST PASS");

		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		} catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						ManageTestsPage.acceptedvalueheading1.click();
						testCase = extent.createTest("ACCEPTED VALUE HEADING FOUND");
						testCase.log(Status.PASS, "TEST PASS");
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
			testCase = extent.createTest("ACCEPTED VALUE HEADING NOT MOVE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// Click the Select Accepted Value

	public static void SelectAcceptedValue() throws InterruptedException {

		PageFactory.initElements(driver, ACM);
		PageFactory.initElements(driver, AGK);

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED VALUE  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 8, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-065-01", 1);

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_05-- ACCEPTED VALUE  EDIT  BUTTON FUNCTION");
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.acceptedvaluetablecontainer2, "edit",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-065-01", 2);

	}

}
