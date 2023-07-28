//***********************************************************************************
//* Description
//*------------
//* AddConfigGroupTest_SubCategorySpecialType
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-CGT-0019    19/05/2023  Niluxy       Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class AddConfigGroupTest_SubCategorySpecialType extends DriverIntialization {
	static TestConfigPage addPage = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();

	@Test
	public static void addgroupconfigure() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);
		extent.createTest("TC-CGT-0019-AddConfigGroupTest_SubCategorySpecialType");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// NAVIGATE TO TEST CONFIGURATION
		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", addPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED", addPage.testconfigurationtext,
				"TEST CONFIGURATION", "ON CLICK THE TEST CONFIGURATION CARD REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO TEST MODULE
		TestConfigNavigation.mainmethod("STEP 2 :TEST TOP NAVIGATION PROPERTIES", addPage.testtopnav,
				"TEST TOP NAVIGATION BUTTON DISPLAYED", "TEST TOP NAVIGATION BUTTON ENABLED", addPage.testleftnav,
				addPage.testparameterleftnav, addPage.testconfigleftnav, addPage.configgrouptestleftnav,
				"ON CLICK THE TEST TOP NAVIGATION REDERECT TO CORRECT WINDOW");

		// NAVIGATE TO CONFIG GROUP TEST SUB MODULE
		SampleCommonMethods.methodoneclick("STEP 3: CONFIG GROUP TEST  PROPERTIES", configPage.configgrouptestsleftnav,
				"CONFIG GROUP TEST CARD DISPLAYED", "CONFIG GROUP TEST CARD ENABLED",
				configPage.configgrouptesttableHeading, "Config Group Test",
				"ON CLICK THE CONFIG GROUP TEST CARD  REDERECT TO CORRECT WINDOW");

		// ADD SUB CATEGORY FIELD AND SELECT THE SPECIAL TYPE DATA FROM EXCEL
		extent.createTest("STEP 4:ADD THE CONFIG GROUP TEST");
		AddConfigGroupTest.addConfigGroupTest("Test Configuragtion Module", "Config_Group_Test", "TC-CGT-0019");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}
}
