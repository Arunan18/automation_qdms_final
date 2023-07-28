//***********************************************************************************
//* Description
//*------------
//* TEST PAPAMETER-PARAMETER TYPE SINGLE SEARCH & RESET
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-PAR-0021             26/04/2023   WATHI     Orginal Version
//*TC-PAR-0023
//*TC-PAR-0024
//*TC-PAR-0025
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class ParameterTypeSingleSearchTest extends TestParameterMainTests{


	@Test
	public static void parametertypesinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, tp);

		testCase = extent.createTest("TESTCASE-TC-PAR-0021/TC-PAR-0023/TC-PAR-0024/TC-PAR-0025");

		LoginTest.Login();

		TestConfigNavigation.TestConfigurationCard();

		TestParameterMainTests.clickonTestParameter();

		Thread.sleep(2000);

		// STEP 01- CHECK THE TABLE CONTENT BEFORE SEARCH
		TestParameterMainTests.firstcolumnBefore();

		// STEP 02- PARAMETER TYPE FILED SINGLE SEARCH
		TestParameterMainTests.parametertypefieldsinglesearch();
		
		Thread.sleep(2000);
		
		//STEP 03-CLICK ON SEARCH ICON
		TestParameterPage.parametertypesearchicon.click();
		
		// STEP 04- CLICK ON RESET BUTTON
		TestParameterPage.parametertypeResetbutton.click(); 

		Thread.sleep(2000);

		// STEP 05- CHECK THE RESET BUTTON IS INVISIBLE
		TestParameterMainTests.parameterTyperesetButtondisapper();

		// STEP 06- CHECK THE TABLE AFTER REST WHETER THE CONTENT IS SAME
		TestParameterMainTests.firstcolumnAfter();

		Logout.LogoutFunction();

	}
}
