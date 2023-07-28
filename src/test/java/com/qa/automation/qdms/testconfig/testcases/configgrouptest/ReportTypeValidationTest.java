//***********************************************************************************
//* Description
//*------------
//* CONFIG GROUP TEST-REPORT TYPE VALIDATION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 22/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-CGT-0013            22/05/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;

public class ReportTypeValidationTest extends ConfigGroupTestMainTests {

	@Test

	public static void reporttypevalidation() throws InterruptedException, IOException {

		testCase = extent.createTest("TESTCASE-TC-CGT-0013");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		ConfigGroupTestMainTests.clickonconfigGroupTets();

		// STEP 01- SELECT REPORT TYPE BEFORE VALIDATION TEST
		ConfigGroupTestMainTests.untilselectreporttype("Test Configuragtion Module", "Config_Group_Test",
				"TC-CGT-0013");

		// STEP 02- CHECK THE VALIDATION
		ConfigGroupTestMainTests.validationtest();

		Logout.LogoutFunction();

	}

}
