//***********************************************************************************
//* Description
//*------------
//* CLICK ON ADD PARAMETER BUTTON FUNTION
//***********************************************************************************
//*
//* Author           :MATHUSAN
//* Date Written     : 27/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-PAR-0036			 27/04/2023    MATHUSAN     Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class CheckAddParameterButtonFunctionality extends DriverIntialization {

	static TestParameterPage TPP = new TestParameterPage();
	static TestConfigPage TPBF = new TestConfigPage();
	static SampleCommonMethods method = new SampleCommonMethods();

	@Test
	public static void Parameteraddbuttonfunction() throws InterruptedException, IOException {
		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TPBF);
		PageFactory.initElements(driver, method);

		// Click LOGIN Button
		LoginTest.Login();

		// Click Test Configuration
		TestConfigPage.testconfigurationcard.click();

		// Click Test Button
		TestConfigPage.testtopnav.click();

		// Click Test Parameter Button
		TestConfigPage.testparameterleftnav.click();

		/* CLICK ON ADD PARAMETER BUTTON FUNTION */
		Parameteraddbutton();

		// Click the Refresh
		driver.navigate().refresh();

		// Click the Logout
		Logout.LogoutFunction();

	}

	public static void Parameteraddbutton() {

		/* CLICK ON ADD PARAMETER BUTTON FUNTION */

		PageFactory.initElements(driver, method);
		PageFactory.initElements(driver, TPP);
		PageFactory.initElements(driver, TPBF);

		SampleCommonMethods.methodoneclick("STEP_01-- TEST PARAMETER ADD BUTTON EXPECTED WINDOWS PROPERTIES",
				TestParameterPage.addparameter, "01--ADD PARAMETERS BUTTON DISPLAYED",
				"02--ADD PARAMETERS BUTTON ENABLED", TestParameterPage.AddParameterWindowHeading, "Add Parameter",
				"03--ADD PARAMETERS BUTTON WINDOW VISIBLE");

	}

}