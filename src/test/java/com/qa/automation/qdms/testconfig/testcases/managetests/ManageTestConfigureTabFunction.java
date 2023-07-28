//***********************************************************************************
//* Description
//*------------
//* MANAGE TEST CONFIGURE TAB FUNCTION
//***********************************************************************************
//*
//* Author           : K.NILUXY 
//* Date Written     :17/05/2023 
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-008			 17/05/2023    K.NILUXY      Original Version
//* 
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class ManageTestConfigureTabFunction extends DriverIntialization{

	static TestParameterPage parameter = new TestParameterPage();
	static TestConfigPage testconfig = new TestConfigPage();
	static SampleCommonMethods samcommon = new SampleCommonMethods();
	static ManageTestsPage managepage = new ManageTestsPage();
	static ActionCommonMethod actioncommon = new ActionCommonMethod();
	
	@Test
	public static void TestEquationDeleteFuntion() throws InterruptedException, IOException {

		PageFactory.initElements(driver, parameter);
		PageFactory.initElements(driver, testconfig);
		PageFactory.initElements(driver, samcommon);
		PageFactory.initElements(driver, managepage);
		PageFactory.initElements(driver, actioncommon);

		extent.createTest("TESTCASENO:MTC-MT-008-MANAGE TEST CONFIGURE TAB FUNCTION");
		//LOGIN TO THE SYSTEM
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

		//LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}