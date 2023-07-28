//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE- EDIT ACCEPTED CRITERIA UPDATE BUTTON FUNCTION 
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 09/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0177              09/05/2023   WATHI     Orginal Version
//*TC-TCN-0180
//*TC-TCN-0184
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.managetests.ManageTestsMainTests;

public class EditAcceptedCriteriaUpdateButtonTest extends TestConfiguteMainTests {

	@Test
	public static void editacceptedcriteriaupdatebutton() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);

		testCase = extent.createTest("TESTCASE-TC-TCN-0177/TC-TCN-0180/TC-TCN-0184");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		
		ManageTestsMainTests.clickonManageTestConfigure();

		Thread.sleep(2000);

		// STEP 01- CALL EXCEL
		TestConfiguteMainTests.Excel2();

		// STEP 02- SELECT A RECORD
		TestConfiguteMainTests.selecttest2();

		Thread.sleep(2000);

		// STEP 03- CLICK ON EDIT CONFIG ICON
		TestConfiguteMainTests.clickeditconfigicon2();

		Thread.sleep(3000);

		//STEP 04- CLICK ON ACCEPTED CRITERIA TAB
		TestConfiguteMainTests.clickonacceptedcriteriatab();

		//STEP 05- SCROLL UP THE PAGE
		TestConfiguteMainTests.scrollup();

		//STEP 06- CALL THE EXCEL
		TestConfiguteMainTests.Excel3();

		//STEP 07-SELECT A MATERIAL TO BE EDIT
		TestConfiguteMainTests.selectmaterial();

		//STEP 08-CLICK ON EDIT MATERIAL BUTTON
		TestConfiguteMainTests.clickeditmaterial();

		//STEP 09- PASS THE VALUE TO THE DROPDOWN
		TestConfiguteMainTests.Exceledit();

		//STEP 10-CLICK ON UPDATE BUTTON
		TestConfigPage.updatebuttonreviewtest.click();

		//STEP 11- CHECK WHETHER THE "EDIT ACCEPTED VALUE" MODAL IS CLOSED OR NOT 
		TestConfiguteMainTests.modalclose();

		//STEP 12- CALL EXCEL
		TestConfiguteMainTests.Excel3();

		//STEP 13-SELECT A MATERIAL TO BE EDIT
		TestConfiguteMainTests.selectmaterial();

		//STEP 14-CLICK IN EDIT MATERAIL BUTTON
		TestConfiguteMainTests.clickeditmaterial();
		
		Thread.sleep(2000);
		
		//STEP 15- COMPARE THE EDITED DATA
		TestConfiguteMainTests.compare();
		
		Thread.sleep(2000);
		
		//STEP 16- CLICK ON CANCEL BUTTON
		TestConfigPage.cancelbuttonreviewtest.click();
		
		//STEP 17- CHECK WHETHER THE "EDIT ACCEPTED VALUE" MODAL IS CLOSED OR NOT  
		TestConfiguteMainTests.modalclose();
		
		Thread.sleep(2000);
		
		//STEP 18-CLICK ON "PREVIOUS" BUTTON
		TestConfigPage.previousbutton.click();
		
		//STEP 19-CHECK THE SCREEN AFTER CLICK ON "PREVIOUS" BUTTON
		TestConfiguteMainTests.expectedscreen();
		
		//STEP 20-SCROLL DOWN
		TestConfiguteMainTests.scrolldown();
		
		Thread.sleep(2000);
		
		//STEP 21-CONFIGURE EQUATION TAB IS ACTIVE
		TestConfiguteMainTests.configureequeation();
		
		Logout.LogoutFunction();
		
		
		
		
		

	}
}
