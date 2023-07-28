//*************************************************************************************************
//* Description
//*------------
//* Plant Lab Trial Sample Key Test Fail Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-P-LAB-SAM-0210     28/04/2023   Priyanka     Orginal Version
//*  TC-P-LAB-SAM-0211
//*  TC-P-LAB-SAM-0212
//*  TC-P-LAB-SAM-0213
//*  TC-P-LAB-SAM-0214
//*  TC-P-LAB-SAM-0215
//*  TC-P-LAB-SAM-0216
//*  TC-P-LAB-SAM-0217
//*  TC-P-LAB-SAM-0218
//*  TC-P-LAB-SAM-0219
//*  TC-P-LAB-SAM-0220
//*  TC-P-LAB-SAM-0221
//*  TC-P-LAB-SAM-0222
//*  TC-P-LAB-SAM-0223
//*  TC-P-LAB-SAM-0224
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class KeyTestFailStatus extends DriverIntialization {

	@Test
	public static void FailStatusKeyTest() throws InterruptedException, IOException {

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

		SampleActionMethods.clicking(SampleNavigationPage.finishProductMainXpath(), 2,
				"STEP 2 - CHECKING RAW MATERIAL MENU");

		// **********************************************************************************
		// STEP-03 CHECKNIG INCOMING SAMPLE BUTTON IS DISPLAYED && STEP-03 CHECKNIG
		// INCOMING SAMPLE BUTTON IS ENABLED
		// **********************************************************************************

		SampleActionMethods.clicking(SampleNavigationPage.labTrialSampleXpath(), 2,
				"STEP 3 - CHECKING INCOMING SAMPLE BUTTON");

		SampleKeyTest.keyTest("Samples Module", "Plant Lab Trial Sample", "TC-P-LAB-SAM-0210",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[4]")), 4, 14, 10, 8);

		Logout.LogoutFunction();

	}

}
