//*************************************************************************************************
//* Description
//*------------
//* Process Sample Key Test Process Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRO-SAM-0245      28/04/2023   Priyanka     Orginal Version
//*  TC-PRO-SAM-0246
//*  TC-PRO-SAM-0247
//*  TC-PRO-SAM-0248
//*  TC-PRO-SAM-0249
//*  TC-PRO-SAM-0250
//*  TC-PRO-SAM-0251
//*  TC-PRO-SAM-0252
//*  TC-PRO-SAM-0253
//*  TC-PRO-SAM-0254
//*  TC-PRO-SAM-0255
//*  TC-PRO-SAM-0256
//*  TC-PRO-SAM-0257
//*  TC-PRO-SAM-0258
//*  TC-PRO-SAM-0259
//*  TC-PRO-SAM-0260
//*  TC-PRO-SAM-0261
//*  TC-PRO-SAM-0262
//*  TC-PRO-SAM-0263
//*  TC-PRO-SAM-0264
//*  TC-PRO-SAM-0265
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleKeyTest;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class KeyTestProcessStatus extends DriverIntialization {

	@Test
	public static void ProcessStatuskeyTest() throws InterruptedException, IOException {

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

		SampleActionMethods.clicking(SampleNavigationPage.inprocessSampleXpath(), 2,
				"STEP 3 - CHECKING INCOMING SAMPLE BUTTON");

		SampleKeyTest.keyTest("Samples Module", "Process Sample", "TC-PRO-SAM-0245",
				driver.findElements(By.xpath("//tbody[@class='ant-table-tbody']/tr/td[1]")), 1, 20, 16, 18);

		Logout.LogoutFunction();

	}

}
