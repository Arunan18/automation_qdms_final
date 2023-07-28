//*************************************************************************************************
//* Description
//*------------
//* Incoming Sample Add Validation Functionality 
//* 
//*************************************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 17/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-INC-SAM-0012        17/04/2023   Priyanka     Orginal Version
//*  
//*
//************************************************************************************

package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddIncomingSampleValidation extends DriverIntialization {

	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test
	public static void Validation() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);

		LoginTest.Login();

		SampleNavigateTest.sampleNavigation();

		SampleNavigateTest.rawMaterialSampleMainNavigation();

		SampleNavigateTest.incommingSampleNavigation();

		

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(2000);

		// **********************************************************************************
		// STEP-01 CHECKING SUPPLIER CATEGORY FIELD VALIDATION
		// **********************************************************************************

		ActionCommonMethod.addValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0012-01",
				IncomingSamplePage.addincomingsample, IncomingSamplePage.suppliercattextbox,
				IncomingSamplePage.suppliercattextboxValidation, IncomingSamplePage.savebutton);

		// **********************************************************************************
		// STEP-02 CHECKING PLANT FIELD VALIDATION
		// **********************************************************************************

		ActionCommonMethod.addValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0012-03",
				IncomingSamplePage.addincomingsample, IncomingSamplePage.planttextbox,
				IncomingSamplePage.planttextboxValidation, IncomingSamplePage.savebutton);

		// **********************************************************************************
		// STEP-03 CHECKING SUPPLIER FIELD VALIDATION
		// **********************************************************************************

		ActionCommonMethod.addValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0012-05",
				IncomingSamplePage.addincomingsample, IncomingSamplePage.suppliertextbox,
				IncomingSamplePage.suppliertextboxValidation, IncomingSamplePage.savebutton);

		// **********************************************************************************
		// STEP-04 CHECKING RAWMATERIAL FIELD VALIDATION
		// **********************************************************************************

		ActionCommonMethod.addValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0012-07",
				IncomingSamplePage.addincomingsample, IncomingSamplePage.rawmaterialtextbox,
				IncomingSamplePage.rawmaterialtextboxValidation, IncomingSamplePage.savebutton);

		// **********************************************************************************
		// STEP-05 CHECKING SAMPLE CODE FIELD VALIDATION
		// **********************************************************************************

		extent.createTest("STEP-05 CHECKING SAMPLE CODE FIELD VALIDATION");

		ActionCommonMethod.addValidation("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0012-09",
				IncomingSamplePage.addincomingsample, IncomingSamplePage.samplecodetextbox,
				IncomingSamplePage.samplecodetextboxValidation, IncomingSamplePage.savebutton);

		driver.navigate().refresh();

		Logout.LogoutFunction();

	}

}
