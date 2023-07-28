//*************************************************************************************************
//* Description
//*------------
//* Teat Trial Fields Functionality
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 16/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-INC-SAM-0301        16/05/2023   Priyanka     Orginal Version
//*  TC-INC-SAM-0303
//*  TC-INC-SAM-0305
//*  TC-INC-SAM-0306
//*  TC-INC-SAM-0308
//*  TC-INC-SAM-0310
//*  TC-INC-SAM-0312
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.pages.SampleNavigationPage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class TestTrialInputValueFunctionality extends DriverIntialization {

	@Test

	public static void InputValueTestTrialFunction() throws InterruptedException, IOException {

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
		// STORING EXCEL DATA INTO ARRAY
		// **********************************************************************************

		IncSamTestTrialInputValue.TestTrialInputValueIncSam();

		// **********************************************************************************
		// CLICKING TEST TRIAL & RESULT ICON AND CLICKING TEST
		// **********************************************************************************

		IncSamTestTrialInputValue.ClickTestResultTest();

		// **********************************************************************************
		// INPUT TEST TRIAL DATE FIELD
		// **********************************************************************************

		IncSamTestTrialInputValue.InputDate();

		// **********************************************************************************
		// INPUT TEST TRIAL NO OF TRIAL FIELD
		// **********************************************************************************

		IncSamTestTrialInputValue.InputNoofTrial();

		IncSamTestTrialInputValue.Status();

		// **********************************************************************************
		// CLICKING SUBMIT BUTTON
		// **********************************************************************************

		IncSamTestTrialInputValue.SubmitButton();

		// **********************************************************************************
		// TRIAL SUCCESS MESSAGE
		// **********************************************************************************

		IncSamTestTrialInputValue.SuccessMessage();

		// **********************************************************************************
		// CLICKING PROCEDURE ICON
		// **********************************************************************************

		IncSamTestTrialInputValue.ProcedureIcon();

		IncSamTestTrialInputValue.AddTrialData();

		Logout.LogoutFunction();

	}

}
