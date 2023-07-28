//*************************************************************************************************
//* Description
//*------------
//* Incoming Sample Key Test Pass Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0271       28/04/2023   Priyanka     Orginal Version
//*  TC-INC-SAM-0272
//*  TC-INC-SAM-0273
//*  TC-INC-SAM-0274
//*  TC-INC-SAM-0275
//*  TC-INC-SAM-0276
//*  TC-INC-SAM-0277
//*  TC-INC-SAM-0278
//*  TC-INC-SAM-0279
//*************************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class KeyTestPassStatusIncSample extends DriverIntialization {

	@Test
	public static void KeyTestPassStatus() throws InterruptedException, IOException {

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

		SampleKeyTest.keyTest("Samples Module", "Incoming Sample", "TC-INC-SAM-0271",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 22, 16, 18);
		
		
		Logout.LogoutFunction();

	}

}
