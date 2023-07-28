//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE-CONFIGURE GROUP TEST BUTTON
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 18/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-CGT-0015             18/05/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;

public class ConfigGroupTestButtonFunctionTest extends ConfigGroupTestMainTests{
	

	@Test
	public static void configGroupTestbutton() throws InterruptedException, IOException {

		

		testCase = extent.createTest("TESTCASE-TC-CGT-0015");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);
		
		//STEP 01- CHECK THE CONFIG GROUP TEST BUTTON FUNCTIONALITY
		
		ConfigGroupTestMainTests.clickonconfigGroupTets();
		
		Logout.LogoutFunction();

	}
}