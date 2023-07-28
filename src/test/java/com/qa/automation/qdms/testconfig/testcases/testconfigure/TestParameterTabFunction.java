//***********************************************************************************
//* Description
//*------------
//*TEST PARAMETER TAB FUNCTION -TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 11/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//*TC-TCN-0008    11/05/2023  Niluxy    Original Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParameterTabFunction extends DriverIntialization {


	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();
	static AddGroupKey groupkey = new AddGroupKey();
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, mangetest);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, groupkey);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES",
				testnav.ManageCofigureMenuBar, "01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
				"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED", testnav.GroupTest, testnav.managetest,
				"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
				"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
				"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,
				"Manage Tests Configure", "03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
		TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]", "(//span[@aria-label='check'])[1]");

		/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
		extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");
		/* SELECT THE VALUE */

		AddGroupKey.actionS(0, 14, mangetest.managetexttablecontainer, "Description",
				"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0008-01", 1);
	
		//CLICK ON THE CONFIGURE TEST BUTTON
		driver.findElement(By.xpath("(//div[@class='ant-steps-item-icon'])[2]")).click();

		/* CHECK THE TAB ARE SELECTED CORRECTLY */
		boolean value1 = TestConfigNavigation.function("STEP_05--CONFIGURE TEST", testnav.configuretest,
				"rgba(255, 255, 255, 1)", "01--CONFIGURE TEST ICON", "02--CONFIGURE TEST ICON");
		boolean value2 = TestConfigNavigation.function("STEP_06--TEST PARAMETER", testnav.TestParameter,
				"rgba(36, 150, 255, 1)", "01--TEST PARAMETER ICON", "02--TEST PARAMETER ICON");
		boolean value3 = TestConfigNavigation.function("STEP_07--CONFIGURE EQUATION", testnav.Configureequation,
				"rgba(255, 255, 255, 1)", "01--CONFIGURE EQUATION", "02--CONFIGURE EQUATION");
		boolean value4 = TestConfigNavigation.function("STEP_08--ACCEPETED CRITERIA", testnav.Acceptedcriteria,
				"rgba(255, 255, 255, 1)", "01--ACCEPETED CRITERIA", "02--ACCEPETED CRITERIA");
		boolean value5 = TestConfigNavigation.function("STEP_09--ADD KEY TEST", testnav.Addkeytest,
				"rgba(255, 255, 255, 1)", "01--ADD KEY TEST", "02--ADD KEY TEST");
		boolean value6 = TestConfigNavigation.function("STEP_10--ACCEPTED CONDITION", testnav.Acceptedcondition,
				"rgba(255, 255, 255, 1)", "01--ACCEPTED CONDITION", "02--ACCEPTED CONDITION");
		boolean value7 = TestConfigNavigation.function("STEP_11--ADDITIONAL INFORMATION", testnav.Additionalinformation,
				"rgba(255, 255, 255, 1)", "01--ADDITIONAL INFORMATION", "02--ADDITIONAL INFORMATION");
		boolean value8 = TestConfigNavigation.function("STEP_12--REVIEW TEST", testnav.Reviewtest,
				"rgba(255, 255, 255, 1)", "01--REVIEW TEST", "02--REVIEW TEST");

		testCase = extent.createTest("STEP_13-- TAB SELECTED IN A CORRECT STEP OR NOT");
		if ((value1 && value2 && value3 && value4 && value5 && value6 && value7 && value8) == true) {
			testCase.log(Status.PASS, "TAB SELECTED IN CORRECT STEP");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase.log(Status.FAIL, "TAB NOT SELECTED IN CORRECT STEP");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		
		// CHECK EXPECTED WINDOW DISPLY OR NOT
		TestConfigNavigation.expectedwindow("STEP_14-- TEST PARAMETER TAB BUTTON HAS BEEN TESTED",
				testnav.testParametertableHeading, "01--EXPECTED WINDOW HEADING DISPLAYED", "Test parameter");

		// LOGOUT TO THE SYSTEM
		logout.LogoutFunction();
	}

}