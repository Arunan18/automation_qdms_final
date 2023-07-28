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
//*MTC-MT-022             27/04/2023   Niluxy       Original Version
//*MTC-MT-023
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

public class DueDaySingleSearchFunction extends DriverIntialization {

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
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 20, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();

		// COMMEN METHOD FOR SINGLE SEARCH
		extent.createTest("STEP 4:CHECKING SEARCH FUNCTIONALITY");
		SampleSingleSearchMethods.singleSearch(TestConfigPage.DueDaysearchicon, TestConfigPage.DueDaysearchTextbox,
				TestConfigPage.DueDaysearchButton, "Test configurations-Manage_Tests", "Test Configuragtion Module",
				"Manage_Tests", "MTC-MT-022", 1, 2, TestConfigPage.tableColoumnoDueDay,
				"//tbody[@class='ant-table-tbody']/tr[", "]/td[7]", testdata);

		// CHECK THE RESET BUTTON FUNCTIONALITY
		SampleActionMethods.clicking(TestConfigPage.Resetbutton, 3000, "STEP 5 : CHECKING THE RESETBUTTON");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);
		
		//CHECK THE RESET FUNCTIONALITY BY BEFORE AND AFTER COUNT
		CommonMethods.TestCasePrint("STEP 6-CHECKING RESET FUNCTION CORRECTLY", beforecount, aftercount);
		
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
