//***********************************************************************************
//* Description
//*------------
//* MULTI SEARCH FUNCTIONALITY-GROUP TEST
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* MTC-GT-017      28/04/2023   Niluxy       Orginal Version
//*MTC-GT-018
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.grouptests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleMultisearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.GroupTestsPage;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;


public class MultiSearchfuntion extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage page = new TestConfigPage();
	static GroupTestsPage grouptest = new GroupTestsPage();
	static SampleMultisearchMethods multish =new SampleMultisearchMethods();
	static boolean testdata = true;

	@Test
	public static void paginationcheck() throws InterruptedException, IOException {
		PageFactory.initElements(driver, page);
		PageFactory.initElements(driver, action);
		PageFactory.initElements(driver, multish );
		PageFactory.initElements(driver,grouptest);

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

		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int beforecount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);

		// REFERESH THE PAGE
		driver.navigate().refresh();
		
////		GROUP NAME FIELD
		SampleMultisearchMethods.multiSearchNew(TestConfigPage.Groupnameicon, TestConfigPage.SearchGroupNameTextBox,
				TestConfigPage.SearchButtonGroupName, "Group Name", "Test Configuragtion Module", "Group_Tests",
				"MTC-GT-017", 1, 2, TestConfigPage.tableColoumnogroupname, "//tbody[@class='ant-table-tbody']/tr[",
				"]/td[1]", testdata);

		
////		MAIN CATEGORY FIELD

		SampleMultisearchMethods.multiSearchNew(TestConfigPage.maincategorygroupicon, TestConfigPage.maincategorygroupsearchbox,
				TestConfigPage.maincategorygroupsearchbutton, "Maincategory", "Test Configuragtion Module", "Group_Tests",
				"MTC-GT-017", 3, 4, grouptest.tableColoumnoMaincategory, "//tbody[@class='ant-table-tbody']/tr[",
				"]/td[2]", testdata);

	
////	   SUB CATEGORY FIELD
		Thread.sleep(2000);
		SampleMultisearchMethods.multiSearchNew(TestConfigPage.subcategorygroupicon, TestConfigPage.subcategorygroupsearchbox,
				TestConfigPage.subcategorygroupsearchbutton, "Sub category", "Test Configuragtion Module", "Group_Tests",
				"MTC-GT-017", 5, 6, TestConfigPage.tableColoumnosubcategorygroup, "//tbody[@class='ant-table-tbody']/tr[","]/td[3]", testdata);

		Thread.sleep(3000);
//////		RAW MATERIAL FIELD
		SampleMultisearchMethods.multiSearchNew(TestConfigPage.rawmaterialgroupicon, TestConfigPage.rawmaterialgroupsearchbox,
				TestConfigPage.rawmaterialgroupsearchbutton, "Raw material", "Test Configuragtion Module", "Group_Tests",
				"MTC-GT-017", 7, 8, TestConfigPage.tableColoumnosrawmaterialgroup, "//tbody[@class='ant-table-tbody']/tr[","]/td[4]", testdata);

		Thread.sleep(3000);
//////		GROUP TYPE FIELD
		SampleMultisearchMethods.multiSearchNew(TestConfigPage.grouptypegroupicon, TestConfigPage.grouptypegroupsearchbox,
				TestConfigPage.grouptypegroupsearchbutton, "Group Type", "Test Configuragtion Module", "Group_Tests",
				"MTC-GT-017", 9, 10, TestConfigPage.tableColoumnosgrouptypegroup, "//tbody[@class='ant-table-tbody']/tr[",
				"]/td[5]", testdata);
//
//		// CLICK ON THE MANAGE TEST CONFIG
		action.clicking(page.ResetAllBtn, 200, "STEP 3:CHECKING THE RESET ALL BUTTON");
//
//		// CHECK THE DATA COUNT IN TABLE BEFORE SEARCH
		int aftercount = PropertiesCommonMethods.CountOfData2(TestConfigPage.tableContainer);
//
		CommonMethods.TestCasePrint("STEP 05-TABLE IS RESET CORRECTLY", beforecount, aftercount);
//		
//		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
