/***********************************************************************************
* Description
*------------
* ADD INCOMING SAMPLE FUNCTIONALITY(TC-INC-SAM-0011)

***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 28/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-MIX-DES-0009   28/04/2023   RAHUL.S    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.incommingsample;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleNavigateTest;
import com.qa.automation.qdms.sample.commonmethods.SelectDate;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class AddIncomingSampleFunction extends IncomingSampleMethods {
	static IncomingSamplePage incomingsample = new IncomingSamplePage();

	@Test
	public static void addIncomingSample() throws InterruptedException, IOException {

		PageFactory.initElements(driver, incomingsample);
		// LOGIN
		LoginTest.Login();
		// SAMPLE NAVIGATION
		SampleNavigateTest.sampleNavigation();
		// RAW MATERIAL
		SampleNavigateTest.rawMaterialSampleMainNavigation();
		// INCOMING SAMPLE NAVIGATION
		SampleNavigateTest.incommingSampleNavigation();
		// CLICK INCOMING SAMPLE ADD BUTTON
		incomingSampleAddButton();
		// FOR ADDING DATA
		addIncomingSampleexcel();
		supplierCategory();
		/* PLANT FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_04-- PLANT FIELD PROPERTIES ", IncomingSamplePage.planttextbox,
				"I--  PLANT FIELD DISPLAYED", "II--  PLANT FIELD ENABLED", plant,
				"III--PLANT DATA SUCCESSFULLY SELECTED");
		/* SUPPLIER FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_05-- SUPPLIER FIELD PROPERTIES ",
				IncomingSamplePage.suppliertextbox, "I--  SUPPLIER FIELD DISPLAYED", "II--  SUPPLIER FIELD ENABLED",
				supplier, "III--SUPPLIER DATA SUCCESSFULLY SELECTED");
		/* RAW MATERIAL FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_06-- SUPPLIER FIELD PROPERTIES ",
				IncomingSamplePage.rawmaterialtextbox, "I--  RAW MATERIAL FIELD DISPLAYED",
				"II--  RAW MATERIAL FIELD ENABLED", rawMaterial, "III--RAW MATERIAL DATA SUCCESSFULLY SELECTED");
		// SENDING VEHICLE NUMBER
		vehicleNO();
		// SENDING SAMPLE CODE
		sampleCode();
		/* SOURCE FIELD DISPLAYED & ENABLED & SELECTED */
		SampleCommonMethods.fieldmethodselect("STEP_11-- SOURCE FIELD PROPERTIES ", IncomingSamplePage.AddSourceTextBox,
				"I--  SOURCE FIELD DISPLAYED", "II--  SOURCE FIELD ENABLED", source,
				"III--SOURCE DATA SUCCESSFULLY SELECTED");

		// SAMPLING DATE VALUE
		try {
			SelectDate.dateSelectT("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0011-01", 8,
					IncomingSamplePage.samplingDate);
			testCase = extent.createTest("STEP-12--SAMPLING DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} catch (Exception e) {
			testCase = extent.createTest("STEP-12--SAMPLING DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

		// ARRIVAL DATE VALUE
		try {
			Thread.sleep(2000);
			SelectDate.dateSelect("Samples Module.xlsx", "Incoming Sample", "TC-INC-SAM-0011-01", 9,
					IncomingSamplePage.arrivalDate);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).perform();
			testCase = extent.createTest("STEP-13--ARRIVAL DATE TEXTBOX IS DISPLAYED AND SELECTED");
			testCase.log(Status.PASS, "TEST PASS ☑");
		} catch (Exception e) {
			testCase = extent.createTest("STEP-13--ARRIVAL DATE TEXTBOX IS NOT DISPLAYED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
		// SENDING SAMPLE TIME
		sampleTime();
		// SENDING BL/LC NO
		blLcNo();
		// SENDING GRN
		grn();
		// SENDING QUANDITY AND BRAND
		quandityAndBrand();
		Thread.sleep(2000);
		// CLICK THE SAVE BUTTON
		addSaveButton();
		Thread.sleep(2000);
		//STATUS CHECKING
		statusConfirmation();
		Thread.sleep(2000);
		//CONFIRM THE ADD FUNCTION
		addConfirmation();
		Thread.sleep(2000);
		//CLICK THE CANCEL BUTTON
		addCancelButton();
		//LOGOUT
		Logout.LogoutFunction();

	}

}
