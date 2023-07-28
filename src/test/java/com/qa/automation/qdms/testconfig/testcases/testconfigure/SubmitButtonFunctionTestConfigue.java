
//***********************************************************************************
//* Description
//*------------
//* submit button functon-testconfigure -test configue
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 8/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0039   8/05/2023  Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class SubmitButtonFunctionTestConfigue extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static Logout logout = new Logout();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);

		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				testnav.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				testnav.testleftnav, testnav.testparameterleftnav, testnav.testconfigleftnav,
				testnav.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", testnav.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", testnav.testconfigurationheading, "Configure Test",
				"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// CLICK ON THE SUBMIT BUTTON
		Thread.sleep(2000);
		action.clicking(testnav.SubmitButton, 20, "STEP 3:CHECKING THE SUBMIT ICON");

		/* CHECK THE FORM ARE SELECTED CORRECTLY */
		boolean value1 = TestConfigNavigation.function("STEP_05--CONFIGURE TEST", testnav.configuretest,
				"rgba(255, 255, 255, 1)", "01--CONFIGURE TEST ICON", "02--CONFIGURE TEST ICON");
		boolean value2 = TestConfigNavigation.function("STEP_06--TEST PARAMETER", testnav.TestParameter,
				"rgba(132, 196, 255, 1)", "01--TEST PARAMETER ICON", "02--TEST PARAMETER ICON");
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

		testCase = extent.createTest("STEP_13-- FORM SELECTED IN A CORRECT STEP OR NOT");
		if ((value1 && value2 && value3 && value4 && value5 && value6 && value7 && value8) == true) {
			testCase.log(Status.PASS, "FORM SELECTED IN CORRECT STEP");
			testCase.log(Status.PASS, "TEST PASS");
		} else {
			testCase.log(Status.FAIL, "FORM NOT SELECTED IN CORRECT STEP");
			testCase.log(Status.FAIL, "TEST FAIL");
		}

		/* Expected Window Displayed or Not */
		TestConfigNavigation.expectedwindow("STEP_14--THE EXPECTED WINDOW HEADING PROPERTYS", testnav.TestParameter,
				"01--EXPECTED WINDOW HEADING DISPLAYED", "Test parameter");

		Logout.LogoutFunction();
	}
}