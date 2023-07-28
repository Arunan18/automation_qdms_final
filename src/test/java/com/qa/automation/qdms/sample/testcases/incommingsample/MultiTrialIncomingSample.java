//*************************************************************************************************
//* Description
//*------------
//* Incoming Sample Multi Trial Test
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 10/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0297       10/05/2023   Priyanka     Orginal Version
//
//**************************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.TestStatus;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class MultiTrialIncomingSample extends DriverIntialization {

	@Test

	public static void IncomingSampleMultiTrial() throws InterruptedException, IOException {

		LoginTest.Login();

		// **********************************************************************************
		// STEP-01 CHECKNIG SAMPLE MODULE IS DISPLAYED && STEP-01 CHECKNIG SAMPLE MODULE
		// BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.sampleXpath(), 2, "STEP 1 - CHECKING SAMPLE MODULE");

		// **********************************************************************************
		// STEP-02 CHECKNIG FINISH PRODUCT MENU IS DISPLAYED && STEP-02 CHECKNIG FINISH
		// PRODUCT MENU IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.rawMaterialMainXpath(), 2,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG INCOMING SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// INCOMING SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.incommingSampleXpath(), 2,
				"STEP 3 - CHECKING INCOMING SAMPLE BUTTON");

		// **********************************************************************************
		// STEP-04 SEARCHING SAMPLE CODE
		// **********************************************************************************

		TestStatus.clickTestAndResults("Samples Module", "Incoming Sample", "TC-INC-SAM-0298-data",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 18);

		// **********************************************************************************
		// STEP-05 CLICK TEST AND ENTER TRIAL VALUES
		// **********************************************************************************

		TestStatus.inputTestDataForRawMaterial("TC-INC-SAM-0298-Input");

		// **********************************************************************************
		// STEP-06 COMPARE TRIAL EXPECTED VALUES
		// **********************************************************************************

		TestStatus.testExpected("TC-INC-SAM-0298-Expected");
		
		
		Logout.LogoutFunction();

	}

}
