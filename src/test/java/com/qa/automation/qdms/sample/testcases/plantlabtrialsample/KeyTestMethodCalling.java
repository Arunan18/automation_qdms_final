/***********************************************************************************
* Description
*------------
* KEY TEST FOR Plant-Lab Trial Sample(TC-P-LAB-SAM-0019)
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 19/04/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-P-LAB-SAM-0019   19/04/2023   RAHUL.S    Original Version
*
************************************************************************************/
package com.qa.automation.qdms.sample.testcases.plantlabtrialsample;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.PlantLabTrailSamplePage;
import com.qa.automation.qdms.sample.pages.ProductionSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;

public class KeyTestMethodCalling extends KeyTestFunctionMethods {
	static ProductionSamplePage productionsample = new ProductionSamplePage();
	static SampleCommonMethods methods = new SampleCommonMethods();
	static PlantLabTrailSamplePage plantLab = new PlantLabTrailSamplePage();

	@Test
	public static void editValidation() throws InterruptedException, IOException {
		PageFactory.initElements(driver, productionsample);
		PageFactory.initElements(driver, plantLab);
		try {
		/* LOGIN */
		LoginTest.Login();

		/* PRODUCTION SAMPLE CARD PROPERTIES DISPLAYED & ENABLED */
		methods.methodoneclick("STEP_01-- PRODUCTION SAMPLE PROPERTIES", productionsample.samplexpath,
				"I--PRODUCTION SAMPLE CARD DISPLAYED", "II--PRODUCTION SAMPLE CARD ENABLED",
				productionsample.sampletext, "SAMPLES",
				"III--ON CLICK THE SAMPLE CARD IT'S REDERECT TO CORRECT WINDOW");

		/* FINISH PRODUCT SAMPLE PROPERTIES DISPLAYED & ENABLED */
		methods.mainmethod("STEP_02-- FINISH PRODUCT SAMPLE PROPERTIES", productionsample.topnavfinishproduct,
				"I--FINISH PRODUCT TOP NAVIGATION BUTTON DISPLAYED", "II--FINISH PRODUCT TOP NAVIGATION BUTTON ENABLED",
				productionsample.plantlabwindowheadding, productionsample.productionwindowheadding,
				"III--ON CLICK THE FINISH PRODUCT TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES DISPLAYED & ENABLED */
		methods.methodoneclick("STEP_03-- PLANT LAB TRAIL SAMPLE BUTTON PROPERTIES",
				productionsample.plantLabTrailSampleLeftButton, "I-- PLANT LAB TRAIL SAMPLE BUTTON DISPLAYED",
				"II-- PLANT LAB TRAIL SAMPLE BUTTON ENABLED", productionsample.plantlabwindowheadding,
				"Plant-Lab Trial Sample", "III--ON CLICK  PLANT LAB TRAIL SAMPLE BUTTON SHOWES CORRECT WINDOW");
		//PICK DATA FROM EXCEL FOR KEY TEST
		dataPickForKeyTest();
		Thread.sleep(2000);
		try {
		//CHECKING POPUP WINDOW
		keyTestModal();
		Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
		//CHECKING POPUP WINDOW
		keyTestModalHeading();
		Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
		//CHECKING TABLE TITLE
		keyTestTableTitleContains();
		Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
		//CHECKING KEY TEST CHECK BOX
		keyTestCheckBoxClick();
		Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		//CLICKING THE SAVE BUTTON
		keyTestSaveButton();
		Thread.sleep(2000);
		//VERIFY THE TEST
		dataPickForKeyTest();
		Thread.sleep(2000);
		checkTheKeyTestCheckBox();
		Thread.sleep(2000);
		//CLICKING CANCEL BUTTON
		keyTestCancelButton();
		//LOG OUT
		Logout.LogoutFunction();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
}
