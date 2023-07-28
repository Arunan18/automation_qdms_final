//***********************************************************************************
//* Description
//*------------
//* SINGLE SEARCH FUNCTIONALITY-MANAGE TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-MT-014           26/04/2023      Niluxy       Original Version
//*MTC-MT-015
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

public class MainCategorySingleSearchFunction extends DriverIntialization {

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
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();
		
		// CLICK ON THE TEST CONFIGURATION CARD
		SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 1000, "STEP 1:CHECKING THE TESTCONFIGRATION");

		// CLICK ON THE MANAGE TEST CONFIG
		SampleActionMethods.clicking(TestConfigPage.MANGECONFIGURE, 2000, "STEP 2:CHECKING THE MANAGE TEST");

		// CLICK ON THE MANAGE TEST LEFT BUTTON
		SampleActionMethods.clicking(TestConfigPage.manageTest, 20, "STEP 3:CHECKING THE MANAGE TESTS");

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();

		// COMMEN METHOD FOR SINGLE SEARCH
		extent.createTest("STEP 4 :CHECKING SEARCH FUNCTIONALITY");
		SampleSingleSearchMethods.singleSearch(TestConfigPage.Maincategorysearchicon,
				TestConfigPage.Maincategorysearchtextbox, TestConfigPage.Maincategorysearchbutton,
				"Test configurations-Manage_Tests", "Test Configuragtion Module", "Manage_Tests", "MTC-MT-014", 1, 2,
				TestConfigPage.tableColoumnoMaincategory, "//tbody[@class='ant-table-tbody']/tr[", "]/td[3]", testdata);

		// CHECK THE RESET BUTTON FUNCTIONALITY
		Thread.sleep(2000);
		SampleActionMethods.clicking(TestConfigPage.Resetbuttonmaincat, 20, "STEP 5:CHECKING THE RESETBUTTON");

		// CHECK THE DATA COUNT IN TABLE AFTER RESET
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);
		
		//CHECK RESET FUNCTIONALITY BY BEFORE AND AFTER COUNT
		CommonMethods.TestCasePrint("STEP 6 :CHECKING RESET FUNCTION CORRECTLY", beforecount, aftercount);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

}
