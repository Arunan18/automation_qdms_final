//***********************************************************************************
//* Description
//*------------
//* TEST PARAMETER CANCEL BUTTON
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0046			 26/04/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class TestParameterCancelButton extends DriverIntialization {
	static SampleCommonMethods methods = new SampleCommonMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static TestParameterPage testpage = new TestParameterPage();
	static Logout logout = new Logout();
	
	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, methods);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, testpage);
		
		/* LOGIN */
		LoginTest.Login();
		
		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES", testnav.testconfigurationcard,
					"01--TEST CONFIGURATION CARD DISPLAYED",
					"02--TEST CONFIGURATION CARD ENABLED", testnav.testconfigurationtext,"TEST CONFIGURATION",
					"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
			
		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", testnav.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED",
				"02--TEST TOP NAVIGATION BUTTON ENABLED", testnav.testleftnav,
				testnav.testparameterleftnav,testnav.testconfigleftnav,testnav.configgrouptestleftnav,
				"03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW"); 
		
		/* TEST PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST PARAMETER PROPERTIES", testnav.testparameterleftnav,
				"01--TEST PARAMETER LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST PARAMETER LEFT NAVIGATION BUTTON ENABLED", testpage.testparameterheadding,"Parameter",
				"03--ON CLICK THE TEST PARAMETER LEFT NAVIGATION SHOWES CORRECT WINDOW");
		
		/* CLICK ON ADD PARAMETER BUTTON*/
		SampleCommonMethods.singleclick("STEP_04-- ADD PARAMETERS PROPERTIES", testpage.addparameter,"01--ADD PARAMETERS BUTTON DISPLAYED","02--ADD PARAMETERS BUTTON ENABLED");
		
		/* CLICK ON CANCEL BUTTON*/
		SampleCommonMethods.methodoneclick("STEP_04-- ADD PARAMETERS CANCEL BUTTON PROPERTIES", testpage.cancelbutton,"01--ADD PARAMETERS CANCEL BUTTON DISPLAYED","02--ADD PARAMETERS CANCEL BUTTON ENABLED",testpage.testparameterheadding,"Parameter","03-- ON CLICK THE CANCEL BUTTON TEST PARAMETER WINDOW DISPLAYED");
		
		/* LOGOUT FROM TEST PARAMETER */
		logout.LogoutFunction();
	}
}
