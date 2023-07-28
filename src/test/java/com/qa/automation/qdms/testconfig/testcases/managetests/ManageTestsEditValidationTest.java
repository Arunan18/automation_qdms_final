//***********************************************************************************
//* Description
//*------------
//* MANAGE TESTS- TESTS EDIT VALIDATION
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 05/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*MTC-MT-002              05/05/2023   WATHI     Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;

public class ManageTestsEditValidationTest extends ManageTestsMainTests {

	@Test
	public static void parametertypesinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, mtp);
		PageFactory.initElements(driver, tpp);
		

		testCase = extent.createTest("TESTCASE-MTC-MT-002");

		LoginTest.Login();
		
		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();
		
		Thread.sleep(2000);
		
		ManageTestsMainTests.clickonManageTestConfigure();
		
		Thread.sleep(2000);
		
		//STEP 01- READ EXCEL
		ManageTestsMainTests.Excel();
		
		Thread.sleep(2000);
		
		//STEP 02- SELECT A RECORD WHICH NEED TO BE EDIT
		ManageTestsMainTests.selecttest();
		
		Thread.sleep(2000);
		
		//STEP 03- CHECK THE VALIDATION MESSAGE
		ManageTestsMainTests.validation();
		
		Logout.LogoutFunction();
		
	}	

}
