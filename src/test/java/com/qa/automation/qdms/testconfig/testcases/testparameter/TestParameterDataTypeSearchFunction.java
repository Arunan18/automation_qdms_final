//***********************************************************************************
//* Description
//*------------
//* TestParameterDataTypeSearchFunction
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0029
//* TC-PAR-0032
//* TC-PAR-0033
//* TC-PAR-0066     25/04/2023     kajan     Original Version
//*						
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class TestParameterDataTypeSearchFunction extends TestParameterMainTests{


	@Test
	public static void parametersinglesearch() throws InterruptedException, IOException {

		PageFactory.initElements(driver, tc);
		PageFactory.initElements(driver, tp);

		testCase = extent.createTest("TestParameterDataTypeSearchFunction");

		LoginTest.Login();

		TestConfigNavigation.TestConfigurationCard();

		TestParameterMainTests.clickonTestParameter();

		Thread.sleep(2000);

		// STEP 01- CHECK THE TABLE CONTENT BEFORE SEARCH
		firstcolumnBefore();

		// STEP 02- PARAMETER FILED SINGLE SEARCH
		parameterfieldsinglesearch();

		// STEP 03- CLICK ON RESET BUTTON
		TestParameterPage.parameterResetbutton.click();
 
		Thread.sleep(2000);

		// STEP 04- CHECK THE RESET BUTTON IS INVISIBLE
		resetButtondisapper();

		// STEP 05- CHECK THE TABLE AFTER REST WHETER THE CONTENT IS SAME
		firstcolumnAfter();

		Logout.LogoutFunction();

	}
	
	//*********methods******************
	public static void firstcolumnBefore() {

		 Actcolumn1=TestParameterPage.tablecontent.getText();
		System.out.println(Actcolumn1);
	}
	public static void parameterfieldsinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(TestParameterPage.parameterdatatpesearchicon,
				TestParameterPage.parameterdatatypesearchtextbox, TestParameterPage.parameterdatatypesearchbutton, "PARAMETER DATA TYPE",
				"Test Configuragtion Module", "Test_Parameter", "TC-PAR-0066", 1, 2, TestParameterPage.parameterDATATYPEColumn,
				TestParameterPage.parameterBeforesearch, TestParameterPage.parameterDATATYPEAftersearch, true);

	}
	public static void resetButtondisapper() {

		try {

			boolean ActualrestButton = TestParameterPage.parameterResetbutton.isDisplayed();
			boolean ExpectedButton = false;
			CommonMethods.TestCasePrint("RESET BUTTON IS NOT VISIBLE", ExpectedButton, ActualrestButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void firstcolumnAfter() {

		Ectcolumn1=TestParameterPage.tablecontent.getText();
		System.out.println(Ectcolumn1);
		
		CommonMethods.TestCasePrint("STEP 05-TABLE IS RESET CORRECTLY", Ectcolumn1, Actcolumn1);
	}

	

}
