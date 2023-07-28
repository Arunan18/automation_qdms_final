//***********************************************************************************
//* Description
//*------------
//* Check Multi Search Functionality
//* Check RESET ALL Button Functionality
//***********************************************************************************
//*
//* Author           : Mathusan
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0060			 01/05/2023   Mathusan     Original Version
//* TC-PAR-0063          01/05/2023   Mathusan     Original Version
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
import com.qa.automation.qdms.testconfig.testcases.managetests.MultySearch;

public class CheckMultiSearchFunctionality extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TCP = new TestConfigPage();
	static MultySearch MS = new MultySearch();

	@Test
	public static void MultiSearchFunctionality() throws InterruptedException, IOException {

		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TCP);
		PageFactory.initElements(driver, MS);

		// Click LOGIN Button
		LoginTest.Login();

		// Click Test Configuration
		TestConfigPage.testconfigurationcard.click();

		// Click Test Button
		TestConfigPage.testtopnav.click();

		// Click Test Parameter Button
		TestConfigPage.testparameterleftnav.click();

		// Check Multi Search Functionality & Reset All Button Functionality

		MultySearch.multiSearch("Test Configuragtion Module.xlsx", "Test_Parameter", "TC-PAR-0060-01",
				TestParameterPage.MultiSearchFunction, 1);

		// Click the Refresh
		driver.navigate().refresh();

		// Click the Logout
		Logout.LogoutFunction();
	}

}
