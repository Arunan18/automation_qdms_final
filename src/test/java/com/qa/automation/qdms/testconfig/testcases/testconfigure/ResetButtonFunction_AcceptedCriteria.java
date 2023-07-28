//***********************************************************************************
//* Description
//*------------
//* Reset Button function under Accepted criteria
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 15/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0188    15/05/2023  Niluxy       Orginal Version
//*
//******************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.ButtonFunction;
import com.qa.automation.qdms.testconfig.commonmethods.ResetButtonFunction;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ResetButtonFunction_AcceptedCriteria extends DriverIntialization {
	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ManageTestsPage mangetest = new ManageTestsPage();
	static TestConfigNavigation testconfig = new TestConfigNavigation();
	static SampleActionMethods action = new SampleActionMethods();

	@Test
	public static void resetbuttoncheck() throws InterruptedException, IOException {
		
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testconfig);
		PageFactory.initElements(driver, mangetest);
	
		/* LOGIN */
	LoginTest.Login();
	
	/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
		
	/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.mainmethod("STEP_02-- MANAGE TEST CONFIGURE TOP NAVIGATION PROPERTIES", testnav.ManageCofigureMenuBar,
			"01--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON DISPLAYED",
			"02--MANAGE TEST CONFIGER TOP NAVIGATION BUTTON ENABLED",testnav.GroupTest,
			testnav.managetest,"03--ON CLICK THE MANAGE TEST CONFIGURE TOP NAVIGATION SHOWES CORRECT WINDOW"); 

	/* CONFIFGURE TEST PROPERTIES DISPLAYED & ENABLED */
	SampleCommonMethods.methodoneclick("STEP_03-- MANAGE TEST PROPERTIES", testnav.managetest,
			"01--CONFIGURE TEST LEFT NAVIGATION BUTTON DISPLAYED",
			"02--CONFIGURE TEST LEFT NAVIGATION BUTTON ENABLED", mangetest.managetestconfigure,"Manage Tests Configure",
			"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");
	
	
	/* PAGE SCROLL UNTIL EDIT CONFIGURE COLUMN */
	TestConfigNavigation.pagescroler("//tbody/tr[2]/td[3]","(//span[@aria-label='check'])[1]");
	
	/* SELECT THE EDIT CONFIGURE DISPLAYED & ENABLED */
	extent.createTest("STEP_04-- EDIT CONFIGURE  BUTTON PROPERTIES");
	
	/* SELECT THE VALUE */
	AddGroupKey.actionS(0, 14, mangetest.managetexttablecontainer, "Description",
			"Test Configuragtion Module.xlsx", "Test_Configure", "TC-TCN-0188-01", 2);
	
	// CLICK ACCEPTED CRITERIA
	action.clicking(TestConfigPage.acceptedcriteriatab, 2000, "STEP 3:CHECKING THE ACCEPTED CRETIRA STEP ");
	// CLICK ACCEPTED CRITERIA
//				action.clicking(TestConfigPage.acceptedcretnextbutton, 2000, "STEP 3:CHECKING THE ACCEPTED CRETIRA NEXT BUTTON ");
	
	//DOWN THE PAGE
	Thread.sleep(1000);
	Actions actions = new Actions(driver);
	actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	
	
	Thread.sleep(2000);
	//ButtonFunction.buttonfunction("Test Configuragtion Module", "Test_Configure", "TC-TCN-0186", "CHECK ACCEPT CRETERIA TAB ", "ACCEPT CRETERIA TAB DISPLAYED", "ACCEPTED CRETERIA TAB ENABLED", TestConfigPage.Addkeytest, "Add Key Test", "ON CLICK THE TEST ACCEPT CRETERIA TAB REDERECT TO CORRECT WINDOW");

	//CHECK RESET BUTTON FUNCTION
	ResetButtonFunction.ResetButtonFunctions();
	
	//LOGOUT TO THE SYSTEM
	logout.LogoutFunction();

	}

	
	
}
