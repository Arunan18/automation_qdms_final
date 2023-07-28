//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE- ACCEPTED CONDITION DELETE FUNCTION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 17/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0199              17/05/2023   WATHI     Orginal Version
//*TC-TCN-0201
//*TC-TCN-0202
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

public class AcceptedConditionDeleteFunctionTest extends TestConfiguteMainTests {

	@Test
	public static void editacceptedcriteriaupdatebutton() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);

		testCase = extent.createTest("TESTCASE-TC-TCN-0199/TC-TCN-0201/TC-TCN-0202");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		ManageTestsMainTests.clickonManageTestConfigure();

		Thread.sleep(2000);

		// STER 01- CALL EXCEL
		TestConfiguteMainTests.Excel199();

		// STEP 02- SELECT A DATA
		TestConfiguteMainTests.selecttest199();

		// STEP 03- CLICK ON SELECTED ACCEPTED CONDITION
		TestConfiguteMainTests.clickacceptedcondition199();

		Thread.sleep(2000);

		// STEP 04- SCROLL DOWN
		TestConfiguteMainTests.scrollup();

		// STEP 05- CALL EXCEL
		TestConfiguteMainTests.Excel199delete();

		// STEP 06- CLIKC ON DELETE ICON
		TestConfiguteMainTests.clickdeletecondiot();
		
		Thread.sleep(2000);

		// STEP 07- CLICK ON CANCEL BUTTON
		TestConfiguteMainTests.deletecancelbutton();

		// STEP 08- CHECK WEATHER POPUP GOES OFF
		TestConfiguteMainTests.deleteconfirmationpopupclose();

		// STEP 09- CALL EXCEL
		TestConfiguteMainTests.Excel199delete();

		// STEP 10- CLIKC ON DELETE ICON
		TestConfiguteMainTests.clickdeletecondiot();
		
		Thread.sleep(2000);

		// STEP 11- CLICK ON OK BUTTON
		TestConfiguteMainTests.deleteOkbutton();
		
		// STEP 12- CHECK WEATHER DELETED ITEM AVAIABLE
		TestConfiguteMainTests.confirmdeletion();
		
		//STEP 13- CLICK ON OK BUTTON
		TestConfigPage.lastcancelbutton.click();

		Thread.sleep(2000); 
		
		Logout.LogoutFunction();   

	}
}