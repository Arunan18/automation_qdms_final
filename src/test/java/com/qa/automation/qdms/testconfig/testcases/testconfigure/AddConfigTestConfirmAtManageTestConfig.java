//***********************************************************************************
//* Description
//*------------
//* TEST CONFIG-Add Configure Test and confirm the add in Manage Test Configure Module
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0378           01/06/2023   WATHI     Original Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;

public class AddConfigTestConfirmAtManageTestConfig extends TestConfiguteMainTests {

	@Test

	public static void AddConfigTestConfirmAtManageTestConfigure()
			throws InterruptedException, IOException {

		PageFactory.initElements(driver, tcn);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);
		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, tpp);
		PageFactory.initElements(driver, mtp);
		PageFactory.initElements(driver, tc);
		

		testCase = extent.createTest("TESTCASE-TC-TCN-0378");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		TestConfiguteMainTests.clickontestconfigure();
		
		// STEP 01- ADD CONFIGUTE TEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddConfigureTest-0378");
        
		Thread.sleep(5000);
		
		// STEP 02 - CLICK ON THE MANAGE TEST CONFIGURE
		TestConfiguteMainTests.clickonmanagetestconfigure();
		
		Thread.sleep(2000);
		
		// STEP 03 - SEARCH THE ADDED DATA IS AVAILABLE
		TestConfiguteMainTests.managetestconfigutefieldsinglesearch();
		
		//STEP 04 - CHECK SEARCHED VALUE IS AVIALABE OR NOT
		
		TestConfiguteMainTests.searchtestavaiable();
		
		Logout.LogoutFunction();
}
}