//*************************************************************************************************
//* Description
//*------------
//* Process Sample Process Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PRO-SAM-0176      01/05/2023   Priyanka     Orginal Version
//*  TC-PRO-SAM-0177
//*  TC-PRO-SAM-0178
//*  TC-PRO-SAM-0179
//*  TC-PRO-SAM-0180
//*  TC-PRO-SAM-0181
//*  TC-PRO-SAM-0182
//*  TC-PRO-SAM-0183
//*  TC-PRO-SAM-0184
//*  TC-PRO-SAM-0185
//*  TC-PRO-SAM-0186
//*  TC-PRO-SAM-0187
//*  TC-PRO-SAM-0188
//*  TC-PRO-SAM-0189
//*  TC-PRO-SAM-0190
//*  TC-PRO-SAM-0191
//*  TC-PRO-SAM-0192
//*  TC-PRO-SAM-0193
//*  TC-PRO-SAM-0194
//*  TC-PRO-SAM-0195
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.inprocesssample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.InprocessSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class ProcessStatusProcessSample extends DriverIntialization {

	static InprocessSamplePage inprocesssample = new InprocessSamplePage();

	@Test

	public static void IncomingSampleNewStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, inprocesssample);

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
				"STEP 3 - CHECKING INPROCESS SAMPLE BUTTON");

		SampleStatus.sampleStatus("Samples Module", "Process Sample", "TC-PRO-SAM-0176",
				InprocessSamplePage.StatusColumn, 1, 16, 18, InprocessSamplePage.InproBeforeSearch,
				InprocessSamplePage.InproAfterSearch);

		Logout.LogoutFunction();

	}

}
