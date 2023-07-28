//***********************************************************************************
//* Description
//*------------
//*ACCEPTED VALUE DELETE FUNCTION BEFORE DEPEND-MANAGE TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 17/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//MTC-MT-063              17/05/2023    Niluxy          Original Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AccepetedValueDeleteFunctionBeforeDepend extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static ManageTestsPage manage = new ManageTestsPage();
	static AcceptedValueIconFunction acceptedvalue = new AcceptedValueIconFunction();
	static AddGroupKey groupkey = new AddGroupKey();

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, manage);
		PageFactory.initElements(driver, acceptedvalue);
		PageFactory.initElements(driver, groupkey);

		extent.createTest("MTC-MT-063:ACCEPTED VALUE DELETE FUNCTION BEFORE DEPEND-MANAGE TEST CONFIGURE");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

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
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-063-01", 1);

		/* ACCEPTED VALUE ICON PROPERTIES DISPLAYED & ENABLED */
		Thread.sleep(1000);
		SampleCommonMethods.methodoneclick("STEP 4: ACCEPTED VALUE ICON PROPERTIES", ManageTestsPage.acceptedvalueIcon,
				"01--ACCEPTED VALUE ICON DISPLAYED", "02--ACCEPTED VALUE ICON ENABLED",
				ManageTestsPage.acceptedvalueEditHeading, "Accepted Value",
				"03--ON CLICK THE ACCEPTED VALUE ICONIT'S REDERECT TO CORRECT WINDOW");

		/* SELECT THE DELETE VALUE */
		ActionCommonMethod.actionS(0, 4, ManageTestsPage.testparametertablecontainer, "delete",
				"Test Configuragtion Module.xlsx", "Manage_Tests", "MTC-MT-063-01", 2);

		/* CLICK ON DELETE CONFIRMATION BUTTON */
		SampleCommonMethods.singleclick("STEP 5:DELETE CONFIRM BUTTON PROPERTYS", ManageTestsPage.confirmokbtn,
				"01--DELETE CONFIRM BUTTON DISPLAYED", "02--DELETE CONFIRM BUTTON ENABLED");

		/* GET THE DELETE MESSAGE FROM EXCEL SHEET */
		String successmessage = TestConfigNavigation.excel("Test Configuragtion Module", "Manage_Tests", "MTC-MT-063",
				3);

		/* DELETE MESSAGE */
		SampleCommonMethods.dataaddedsuccessmsg("STEP 6:DELETE CONFERMATION MESSAGE BEFORE DEPEND",
				ManageTestsPage.successMsg, successmessage);

		/* PAGE REFRESH */
		driver.navigate().refresh();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}