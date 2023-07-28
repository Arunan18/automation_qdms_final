//***********************************************************************************
//* Description
//*------------
//* CONFIG GROUP TEST-ADD CONFIG GROUP TEST-ALL CAREGORIES-REPORT TYPE
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 19/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-CGT-0017             19/05/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.configgrouptest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;

public class AddConfigGroupTest_Material_ReportType extends ConfigGroupTestMainTests{

	@Test

	public static void addConfig_material_reporttype() throws InterruptedException, IOException {

		testCase = extent.createTest("TESTCASE-TC-CGT-0017");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);
		
		ConfigGroupTestMainTests.clickonconfigGroupTets();
		
		// STEP 01- ADD CONFIGURE MAIN TEST
		ConfigGroupTestMainTests.addconfigmaterialmain_reporttype();
		
		
		Logout.LogoutFunction();
		
		
		
		
		
	}
	
	
}
