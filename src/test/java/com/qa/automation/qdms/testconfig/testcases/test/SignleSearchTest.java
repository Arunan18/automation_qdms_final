
//***********************************************************************************
//* Description
//*------------
//* SINGLE SEARCH FUNCTIONALITY-TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-Test-0008     25/04/2023   Niluxy       Orginal Version
//*TC-Test-0010
//TC-Test-0011
//TC-Test-0012
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class SignleSearchTest extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static SampleSingleSearchMethods search = new SampleSingleSearchMethods();
	static boolean testdata = true;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, search);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		action.clicking(page.testconfigurationcard, 20, "STEP 1:CHECK THE TESTCONFIGRATION");

		// CLICK THE TEST HEADER MODULE
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 1000, "STEP 2:CHECK THE TEST MODULE");
		// CLICK THE TEST MODULE
		SampleActionMethods.clicking(TestConfigPage.testleftnav, 1000, "STEP 3:CHECK THE TEST SUB MODULE");

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();

		// COMMEN METHOD FOR SINGLE SEARCH
		extent.createTest("STEP 4:CHECK SINGLE SEARCH FOR TEST FIELD FUNCTION");
		SampleSingleSearchMethods.singleSearch(TestConfigPage.SearchTestIcon, TestConfigPage.SearchTestTextBox,
				TestConfigPage.SearchTestSearchbutton, "Test configurations-TestFieldSearch",
				"Test Configuragtion Module", "Test", "TC-Test-0008", 1, 2, TestConfigPage.tableColoumno,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[1]", testdata);

		// CHECK THE RESET BUTTON FUNCTIONALITY
		SampleActionMethods.clicking(TestConfigPage.Resetbutton, 3000, "STEP 05:CHECK THE RESETBUTTON");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);
		CommonMethods.TestCasePrint("STEP 06:CHECK RESET FUNCTION CORRECTLY", beforecount, aftercount);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}