//***********************************************************************************
//* Description
//*------------
//* TEST PAPAMETER-MAIN TESTS
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/03/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                      25/04/2023   WATHI     Orginal Version
//
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.CommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleSingleSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;
  
public class TestParameterMainTests extends DriverIntialization {

	static TestConfigPage tc = new TestConfigPage();
	static TestParameterPage tp = new TestParameterPage();
	
	static String Actcolumn1=null;
	static String Ectcolumn1=null;
	
	public static void clickonTestParameter()

	{

		SampleCommonMethods.methodoneclick("STEP 01-CLICK ON TEST PARAMETER BUTTON",
				TestConfigPage.testparameterleftnav, "TEST PARAMETER IS DISPLAY", "TEST PARAMETER IS ENABLED",
				TestConfigPage.testParametertableHeading, "Parameter", "TEST PARAMETER BUTTN HAS BEEN TESTED");
		;
	}

	public static void parameterfieldsinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(TestParameterPage.parametersearchicon,
				TestParameterPage.parametersearchtextbox, TestParameterPage.parametersearchbutton, "PARAMETER",
				"Test Configuragtion Module", "Test_Parameter", "TC-PAR-0013", 1, 2, TestParameterPage.parameterColumn,
				TestParameterPage.parameterBeforesearch, TestParameterPage.parameterAftersearch, true);

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

	public static void firstcolumnBefore() {

		 Actcolumn1=TestParameterPage.tablecontent.getText();
		System.out.println(Actcolumn1);
	}
	
	public static void firstcolumnAfter() {

		Ectcolumn1=TestParameterPage.tablecontent.getText();
		System.out.println(Ectcolumn1);
		
		CommonMethods.TestCasePrint("STEP 05-TABLE IS RESET CORRECTLY", Ectcolumn1, Actcolumn1);
	}
	
	public static void parametertypefieldsinglesearch() throws IOException, InterruptedException

	{

		SampleSingleSearchMethods.singleSearch(TestParameterPage.parametertypesearchicon,
				TestParameterPage.parametertypesearchtextbox, TestParameterPage.parametertypesearchbutton, "PARAMETER",
				"Test Configuragtion Module", "Test_Parameter", "TC-PAR-0023", 1, 2, TestParameterPage.parametertypeColumn,
				TestParameterPage.parametertypeBeforesearch, TestParameterPage.parametertypeAftersearch, true);

	}
	
	public static void parameterTyperesetButtondisapper() {

		try {

			boolean ActualrestButton = TestParameterPage.parametertypeResetbutton.isDisplayed();
			boolean ExpectedButton = false;
			CommonMethods.TestCasePrint("RESET BUTTON IS NOT VISIBLE", ExpectedButton, ActualrestButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}