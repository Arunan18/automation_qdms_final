//***********************************************************************************
//* Description
//*------------
//* MANAGE-TESTS ROW MATERIAL SEARCH & RESET
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-018             26/04/2023   WATHI     Orginal Version
//*MTC-MT-019
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class RowMaterialSingleSearchTest extends ManageTestsMainTests{

	
	
	@Test
	public static void parametersinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);
		PageFactory.initElements(driver, tpp);
		
		
		testCase = extent.createTest("TESTCASE-MTC-MT-018/MTC-MT-019");

		LoginTest.Login();

		TestConfigNavigation.TestConfigurationCard();
		
		Thread.sleep(2000);

		//ManageTestsPage.managetestconfigure.click();
		ManageTestsMainTests.clickonManageTestConfigure();

		Thread.sleep(2000);

		// STEP 01- CHECK THE TABLE CONTENT BEFORE SEARCH
		ManageTestsMainTests.firstcolumnBefore();
		
		Thread.sleep(2000);

		// STEP 02- ROW MATERAIL FILED SINGLE SEARCH
		ManageTestsMainTests.rowmaterialsinglesearch();
		
		Thread.sleep(2000);

		// STEP 03- CLICK ON RESET BUTTON
		TestParameterPage.parameterResetbutton.click();

		Thread.sleep(2000);

		// STEP 04- CHECK THE RESET BUTTON IS INVISIBLE
		ManageTestsMainTests.rowmaterialButtondisapper();

		Thread.sleep(2000);
		
		// STEP 05- CHECK THE TABLE AFTER REST WHETER THE CONTENT IS SAME
		ManageTestsMainTests.firstcolumnAfter();

		Logout.LogoutFunction();

	
}
	
}
