//***********************************************************************************
//* Description
//*------------
//* SINGLE SEARCH FUNCTIONALITY-TEST CONFIGURE
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 1/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0074            1/05/2023    Niluxy       Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.commonmethods.ScrollRight;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParameterSearchFunctionality extends DriverIntialization {
	static TestConfigPage page = new TestConfigPage();
	static SampleActionMethods action = new SampleActionMethods();
	static boolean testdata = true;

	@Test
	public static void testparameter() throws InterruptedException, IOException {

		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// CLICK TEST CONFIGURATION
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000,
				"STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST CONFIG");
		Thread.sleep(2000);

		// Actions actions = new Actions(driver);
		// actions.sendKeys(Keys.PAGE_UP).build().perform();

		// CLICK MANAGE TEST LEFT BUTTON
		action.clicking(TestConfigPage.manageTest, 2000, "STEP 3:CHECKING THE MANAGE TEST CONFIG MODULE ");

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}


		// CLICK EDITKEYICON IN MANAGE TEST
		action.clicking(TestConfigPage.Editkeyiconinmanagetest, 20, "STEP 4:CHECKING THE EDIT KEY ICON ");
		Thread.sleep(2000);
		// CLICK TEST CONFIGURE LEFT BUTTON 
		action.clicking(TestConfigPage.testconfigleftnav, 200, "STEP 5:CHECKING THE TEST CONFIGURE");

		// CHECK THE TEST PARAMETER RADIO BUTTON
		Thread.sleep(2000);
		action.clicking(TestConfigPage.TestparameterRadiobuttonTCicon, 200,
				"STEP 5:CHECKING THE RADIO BUTTON TEST PARAMETER");

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		Thread.sleep(2000);
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();

		// COMMEN METHOD FOR SINGLE SEARCH
		Thread.sleep(2000);
		SampleSingleSearchMethods.singleSearch(TestConfigPage.TestparametersearchTCicon,
				TestConfigPage.TestparameterTCisearchbox, TestConfigPage.TestparameterTCisearchbutton,
				"Testparameter in Testconfigsearch", "Test Configuragtion Module", "Test_Configure", "TC-TCN-0074", 1,
				2, TestConfigPage.tableColoumnosTestparameterTCi, "//tbody[@class='ant-table-tbody']/tr[", "]/td[1]",
				testdata);

		// CHECK THE RESET BUTTON FUNCTIONALITY
		Thread.sleep(3000);
		SampleActionMethods.clicking(TestConfigPage.Resetbutton, 1000, "STEP 8:CHECK THE RESETBUTTON");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET

		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		CommonMethods.TestCasePrint("STEP 09-CHECK RESET FUNCTION CORRECTLY", beforecount, aftercount);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
