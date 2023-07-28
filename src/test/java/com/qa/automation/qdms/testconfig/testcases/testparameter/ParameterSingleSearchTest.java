//***********************************************************************************
//* Description
//*------------
//* TEST PAPAMETER-PARAMETER SINGLE SEARCH & RESET
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-PAR-0012             25/04/2023   WATHI     Orginal Version
//*TC-PAR-0013
//*TC-PAR-0015
//*TC-PAR-0017
//*TC-PAR-0022
//*TC-PAR-0065 -dup
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.pages.master.UserPage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class ParameterSingleSearchTest extends TestParameterMainTests {

	@Test
	public static void parametersinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, tp);

		testCase = extent.createTest("TESTCASE-TC-PAR-0012/TC-PAR-0013/TC-PAR-0015/TC-PAR-0017/TC-PAR-0022");

		LoginTest.Login();

		TestConfigNavigation.TestConfigurationCard();

		TestParameterMainTests.clickonTestParameter();

		Thread.sleep(2000);

		// STEP 01- CHECK THE TABLE CONTENT BEFORE SEARCH
		TestParameterMainTests.firstcolumnBefore();

		// STEP 02- PARAMETER FILED SINGLE SEARCH
		TestParameterMainTests.parameterfieldsinglesearch();

		// STEP 03- CLICK ON RESET BUTTON
		TestParameterPage.parameterResetbutton.click();
 
		Thread.sleep(2000);

		// STEP 04- CHECK THE RESET BUTTON IS INVISIBLE
		TestParameterMainTests.resetButtondisapper();

		// STEP 05- CHECK THE TABLE AFTER REST WHETER THE CONTENT IS SAME
		TestParameterMainTests.firstcolumnAfter();

		Logout.LogoutFunction();

	}
}