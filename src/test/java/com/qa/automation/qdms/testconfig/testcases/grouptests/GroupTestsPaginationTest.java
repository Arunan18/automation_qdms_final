//***********************************************************************************
//* Description
//*------------
//* PAGINATION FUNCTIONALITY-GROUP TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-016       28/04/2023   Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

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

public class GroupTestsPaginationTest extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();

	@Test
	public static void paginationcheck() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		Thread.sleep(2000);
		// CLICK THE TEST CONFIGURATION MODULE
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(page.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(page.GroupTest, 20, "STEP 3:CHECKING THE GROUP TEST");

		// TestConfigPage.testconfigurationcard.click();
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// CHECK THE PAGINATION FUCNTIONALITY
		Paginationmethods.pagination("Test Configuragtion Module", "Group_Tests", "MTC-GT-016",
				TestConfigPage.previousbt, TestConfigPage.nextbt, TestConfigPage.pag2nd, TestConfigPage.pag1st,
				TestConfigPage.pagdrp, TestConfigPage.bef, 4, TestConfigPage.aft, "GROUP TEST PAGINATION");

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
