//*************************************************************************************************
//* Description
//*------------
//* Incoming Sample Edit Validation Functionality 
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 19/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-INC-SAM-0014        19/04/2023   Priyanka     Orginal Version
//*  
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class EditIncomingSampleValidation extends DriverIntialization {

	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test
	public static void EditIncomingSampleValid() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);

		LoginTest.Login();

		SampleNavigateTest.sampleNavigation();

		SampleNavigateTest.rawMaterialSampleMainNavigation();

		SampleNavigateTest.incommingSampleNavigation();

		// **********************************************************************************
		// STEP-01 SEARCHNIG & CLICKING EDIT ICON
		// **********************************************************************************
		extent.createTest("STEP-01 SEARCHING & CLICKING EDIT ICON");

		ActionCommonMethod.actionS(0, 22, IncomingSamplePage.IncSamTableContainer, "edit", "Samples Module.xlsx",
				"Incoming Sample", "TC-INC-SAM-0014-01", 2);

		// **********************************************************************************
		// STEP-02 CHECKING SAMPLE CODE FIELD VALIDATION
		// **********************************************************************************

		extent.createTest("STEP-02 CHECKING SAMPLE CODE FIELD VALIDATION");

		ActionCommonMethod.editValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0014-01",0, 22,
				IncomingSamplePage.IncSamTableContainer,IncomingSamplePage.samplecodetextbox, IncomingSamplePage.samplecodetextboxValidation,
				IncomingSamplePage.incsameditbutton);

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
