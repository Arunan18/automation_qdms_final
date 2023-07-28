//***********************************************************************************
//* Description
//*------------
//* MANAGE-TESTS SUB CATEGORY SEARCH & RESET
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-016             26/04/2023   WATHI     Orginal Version
//*MTC-MT-017
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.testcases.testparameter.TestParameterMainTests;

public class SubCategorySingleSearchTest extends ManageTestsMainTests {

	@Test
	public static void parametersinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);
		PageFactory.initElements(driver, tpp);

		testCase = extent.createTest("TESTCASE-MTC-MT-016/MTC-MT-017");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		// ManageTestsPage.managetestconfigure.click();
		ManageTestsMainTests.clickonManageTestConfigure();

		Thread.sleep(2000);

		// STEP 01- CHECK THE TABLE CONTENT BEFORE SEARCH
		ManageTestsMainTests.firstcolumnBefore();

		// STEP 02- SUB CATEGORY FILED SINGLE SEARCH
		ManageTestsMainTests.subcategorysinglesearch();

		// STEP 03- CLICK ON RESET BUTTON
		TestParameterPage.parameterResetbutton.click();

		Thread.sleep(2000);

		// STEP 04- CHECK THE RESET BUTTON IS INVISIBLE
		ManageTestsMainTests.subcategoryButtondisapper();

		// STEP 05- CHECK THE TABLE AFTER REST WHETER THE CONTENT IS SAME
		ManageTestsMainTests.firstcolumnAfter();

		Logout.LogoutFunction();

	}
}