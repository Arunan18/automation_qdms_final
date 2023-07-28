//***********************************************************************************
//* Description
//*------------
//* TEST CONFIGURE-ACCEPTED COMDITION TAB FUNCTION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 08/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0014              08/05/2023   WATHI     Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.testcases.managetests.ManageTestsMainTests;

public class AcceptedConditionTabFunctionTest extends TestConfiguteMainTests{
	
	@Test
	public static void acceptedconditiontabfunctiontest() throws InterruptedException, IOException
	{
		
		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);
		
		testCase = extent.createTest("TESTCASE-TC-TCN-0014");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);
		
		ManageTestsMainTests.clickonManageTestConfigure();
		
		//STEP 01- CALL EXCEL
		TestConfiguteMainTests.Excel();
		
		//STEP 02- SELECT A RECORD
		TestConfiguteMainTests.selecttest();
		
		Thread.sleep(2000);
		
		//STEP 03- CLICK ON EDIT CONFIG ICON
		TestConfiguteMainTests.clickeditconfigicon();
		
		Thread.sleep(3000);
		
		//STEP 04- CHECK ACCEPTANCE CONDITION BUTTON IS AVAIABLE OR NOT
		TestConfiguteMainTests.acceptancecondition();
		
		Thread.sleep(2000);
		
		//STEP 05- CLICK ON ACCEPTANCE CONDITION BUTTON AND CHECK THE DIALOG BOX
		TestConfiguteMainTests.clickonacceptedconditiontab();
		
		Logout.LogoutFunction();
		
	}

}
