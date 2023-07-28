//***********************************************************************************
//* Description
//*------------
//* SINGLE SEARCH FUNCTIONALITY-MANAGE TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-020           27/04/2023    Niluxy       Original Version
//*MTC-MT-021
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.sample.testcases.plantlabtrialsample.PlantFieldSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestTypeSingleSearchFunction extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static SampleSingleSearchMethods search = new SampleSingleSearchMethods();
	static PlantFieldSearchMethods count = new PlantFieldSearchMethods();
	static boolean testdata = true;

	@Test
	public static void search() throws IOException, InterruptedException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, count);
		PageFactory.initElements(driver, search);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 20, "STEP 1:CHECKING THE TESTCONFIGRATION");
		// CLICK ON THE MANAGE TEST CONFIG

		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST CONFIG");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();

		// COMMEN METHOD FOR SINGLE SEARCH
		extent.createTest("STEP 4:CHECKING SEARCH FUNCTION");
		Thread.sleep(3000);
		SampleSingleSearchMethods.singleSearch(TestConfigPage.testtypesearchicon, TestConfigPage.testtypesearchTextbox,
				TestConfigPage.testtypesearchButton, "Test configurations-Manage_Tests", "Test Configuragtion Module",
				"Manage_Tests", "MTC-MT-020", 1, 2, TestConfigPage.tableColoumnoTestType,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[6]", testdata);

		// CHECK THE RESET BUTTON FUNCTIONALITY
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.Resetbutton, 3000, "STEP 5:CHECKING THE RESETBUTTON");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		Thread.sleep(1000);
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// CHECK THE RESET FUNCTION BY BEFORE AND AFTER COUNT
		CommonMethods.TestCasePrint("STEP 6-CHECK RESET FUNCTION CORRECTLY", beforecount, aftercount);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
