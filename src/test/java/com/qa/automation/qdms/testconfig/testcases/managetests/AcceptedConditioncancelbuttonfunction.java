//***********************************************************************************
//* Description
//*------------
//*  Accepted Condition cancel button function
//***********************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     :18/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-094			 18/05/2023    MATHUSAN     Original Version
//* 
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class AcceptedConditioncancelbuttonfunction extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static SampleCommonMethods SCM = new SampleCommonMethods();
	static ManageTestsPage MTP = new ManageTestsPage();
	static ActionCommonMethod ACM = new ActionCommonMethod();
	 static AddGroupKey AGK =new AddGroupKey();
		
	@Test

	public static void TestAddvalueDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, ACM);

		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, SCM);
		PageFactory.initElements(driver, MTP);

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

		// Click the Select Accepted Condition
		SelectAcceptedCondition();

		// Click the Cancel Button
		Cancelbuttonfunction();

		// Click Refresh Button
		driver.navigate().refresh();

		// Click Logout Button
		Logout.LogoutFunction();

	}

	// Click the Manage Configure Scorall Page

	public static void managetestconfigurationscorallpage() {
		try {
			TestConfigPage.managetestcongigurescrollpage.click();
			testCase = extent.createTest("CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.PASS, "TEST PASS");
			
		}  catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		catch (ElementClickInterceptedException E) {
			testCase = extent.createTest("NOT CLICK MANAGE TEST CONFIGURE SCROLL PAGE");
			testCase.log(Status.FAIL, "TEST FAIL");
		}
		try {
			boolean pass = false;
			Thread.sleep(1000);

			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						ManageTestsPage.acceptedconditionheading.click();
						testCase = extent.createTest("ACCEPTED CONDITON HEADING FOUND");
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
			testCase = extent.createTest("ACCEPTED CONDITON HEADING NOT MOVE");
		    testCase.log(Status.FAIL, "TEST FAIL");
		}

	}

	// Click the Select Accepted Condition

	public static void SelectAcceptedCondition() throws InterruptedException {

		PageFactory.initElements(driver, AGK);

		// SELECT THE ACCEPTED VALUE EDIT TEST PROPERTIES DISPLAYED & ENABLED
		extent.createTest("STEP_04-- ACCEPTED CONDITION  BUTTON PROPERTIES");
		AddGroupKey.actionS(0, 11, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-094-01", 1);

	}

	static boolean CancelbuttonClick = false;
	static Boolean acceptedcondition = false;

	// Click the Cancel Button

	public static void Cancelbuttonfunction() throws InterruptedException {

		Thread.sleep(2000);

		try {
			Boolean IsVisible1 = ManageTestsPage.acceptedconditioncancelbutton.isDisplayed();
			PropertiesCommonMethods.TestReportsq("1.Cancel Button Visible", "true", IsVisible1, "definition");
			if (IsVisible1 == true) {

				Boolean IsEnabled1 = ManageTestsPage.acceptedconditioncancelbutton.isDisplayed();
				PropertiesCommonMethods.TestReportsq("1.Cancel Button Visible", "true", IsEnabled1, "definition");

				if (IsEnabled1 == true) {

					ManageTestsPage.acceptedconditioncancelbutton.click();

					testCase = extent.createTest("CLICK THE CANCEL BUTTON");
					testCase.log(Status.PASS, "TEST PASS");
					CancelbuttonClick = true;
				}

			} 
		} catch (NoSuchElementException E) {
			testCase = extent.createTest("NOT CLICK THE CANCEL BUTTON");
			testCase.log(Status.FAIL, "TEST FAIL");
			}catch (ElementClickInterceptedException E) {
				testCase = extent.createTest("NOT CLICK THE CANCEL BUTTON");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		if (CancelbuttonClick == true) {

			Thread.sleep(2000);
			Boolean acceptedcondition = true;
			
			try {
				acceptedcondition = ManageTestsPage.acceptedconditionmodal.isDisplayed();
				testCase = extent.createTest("ACCEPTED CONDITION MODAL VISIBLE");
				testCase.log(Status.PASS, "Test Pass");
				
			}catch (NoSuchElementException E) {
				testCase = extent.createTest("ACCEPTED CONDITION MODAL NOT VISIBLE");
				testCase.log(Status.FAIL, "Test FAIL");
				
			}
			

			if (acceptedcondition == true) {
				testCase = extent.createTest("ACCEPTED CONDITION IS VISIBLE");
				testCase.log(Status.PASS, "Test Pass");

			} else {

				testCase = extent.createTest("ACCEPTED CONDITION IS NOT VISIBLE");
				testCase.log(Status.PASS, "Test FAIL");
			}
		}

	}

}