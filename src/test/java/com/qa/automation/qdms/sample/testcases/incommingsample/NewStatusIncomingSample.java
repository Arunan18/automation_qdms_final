//*************************************************************************************************
//* Description
//*------------
//* Incoming Sample NEW Status
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 28/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0170      28/04/2023   Priyanka     Orginal Version
//*  TC-INC-SAM-0171
//*  TC-INC-SAM-0172
//*  TC-INC-SAM-0173
//*  TC-INC-SAM-0174
//*  TC-INC-SAM-0175
//*  TC-INC-SAM-0176
//*  TC-INC-SAM-0177
//*************************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleStatus;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class NewStatusIncomingSample extends DriverIntialization {

	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test

	public static void IncomingSampleNewStatus() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);

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

		SampleStatus.sampleStatus("Samples Module", "Incoming Sample", "TC-INC-SAM-0170",
				IncomingSamplePage.StatusColumn, 1, 16, 18, IncomingSamplePage.InComKeyBefore,
				IncomingSamplePage.InComKeyAfter);

		Logout.LogoutFunction();

	}

}
