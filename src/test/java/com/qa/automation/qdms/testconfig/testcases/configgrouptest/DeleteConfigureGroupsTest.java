//***********************************************************************************
//* Description
//*------------
//* CONFIG GROUP TESTS- DELETE CONFIG GROUP 
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-CGT-0002              08/05/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.managetests.ManageTestsMainTests;

public class DeleteConfigureGroupsTest extends ConfigGroupTestMainTests {

	@Test
	public static void deleteconfiggrouptests() throws InterruptedException, IOException {
		
		
		testCase = extent.createTest("TESTCASE-TC-CGT-0002");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);
		
		ConfigGroupTestMainTests.clickonconfigGroupTets();
		
		// STEP 01- ADD CONFIGURE GROUP TEST
		ConfigGroupTestMainTests.addconfigmaterialmain_specialtype_delete();
		
		// STEP 02- READ THE EXCEL
		ConfigGroupTestMainTests.Excel2();
		
		// STEP 03- SELECT A DATA TO DELETE
		ConfigGroupTestMainTests.selectgroupname();
		
		// STEP 04- CLICK ON DELTE ICON 
		ConfigGroupTestMainTests.clickdeletegroupname();
		
		Thread.sleep(2000);
		
		// STEP 05- CLICK ON DELETE CONFIRMATION OK BUTTON
		configGroupTestsPage.deleteconfirmationOKbutton.click();
		
		// STEP 06- CLICK ON THE PAGE 1
		configGroupTestsPage.pageone.click();
		
		Thread.sleep(2000);
		
		// STEP 07- CHECK WEATHER THE DELETED DATA IS AVAILABEL IN THE TABLE OR NOT
		ConfigGroupTestMainTests.selectgroupnameafterdelete();
		
		Logout.LogoutFunction();
		
		
	}
}