//***********************************************************************************
//* Description
//*------------
//* PAGINATION FUNCTIONALITY-TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intial        Comments
//* ================       ====         =====        ========
//* TC-Test-0015       26/04/2023   Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestPagination extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();

	@Test
	public static void paginationcheck() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		
		extent.createTest("TC-Test-0015-Check Test Pagination");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);
		// CLICK THE TEST CONFIGURATION MODULE
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000, "STEP 1:CHECK THE TESTCONFIGRATION");

		// CLICK THE TEST HEADER MODULE
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 1000, "STEP 2:CHECK THE TEST MODULE");
		// CLICK THE TEST MODULE
		SampleActionMethods.clicking(TestConfigPage.testleftnav, 1000, "STEP 3:CHECK THE TEST SUB MODULE");

		// DOWN THE PAGE
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// CHECK THE PAGINATION FUCNTIONALITY
		Thread.sleep(1000);
		Paginationmethods.pagination("Test Configuragtion Module", "Test", "TC-Test-0015", TestConfigPage.previousbt,
				TestConfigPage.nextbt, TestConfigPage.pag2nd, TestConfigPage.pag1st, TestConfigPage.pagdrp,
				TestConfigPage.bef, 4, TestConfigPage.aft, "STEP 4:CHECK THE TEST PAGE-");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
