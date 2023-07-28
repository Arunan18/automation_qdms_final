//********************************************************************************************************
//* Description
//*------------
//* Configure Test  Using Material wise (Using Input & Results Parameter)Finish Product With Active
//********************************************************************************************************
//*
//* Author           : MATHUSAN
//* Date Written     : 09/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0405			 09/06/2023    MATHUSAN     Original Version
//* 
//********************************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class FinishproductConfigureTestUsingMaterialwiseUsingInputandResultsParameterWithactive
		extends DriverIntialization {

	static Logout logout = new Logout();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod action = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();
	static TestConfigPage addPage = new TestConfigPage();
	static SampleActionMethods SA = new SampleActionMethods();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, logout);
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, SA);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// TOP NAVIGATION
		SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);

		// NAVIGATE TO TEST CONFIGURATION
		SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);

		//STEP-01
		// CONFIGURE TEST FIELD
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-first");
		Thread.sleep(2000);

		// TEST PARAMETER FIELD
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-second");
		Thread.sleep(3000);

		// ADD PARAMETER FIELD
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-second");
		Thread.sleep(2000);

		// CONFIGURE EQUATION FIELD
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-third");
		Thread.sleep(3000);

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ACCEPTED CRITERIA FIELD
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-fourth");
		Thread.sleep(3000);
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ACCEPTED CRITERIA FIELD
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-fifth");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ADD ACCEPTED CONDITION
		AcceptCondition.condition("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-sixth");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// ADD INFORMATION
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-seventh");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// REVIEW TEST CHECK IN REVIEW TAB
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0405-first",
				"TC-TCN-0405-second", "TC-TCN-0405-third", "TC-TCN-0405-fourth", "TC-TCN-0405-fifth", " ",
				"TC-TCN-0405-seventh");

		// NAVIGATE TO TEST CONFIGURATION
		SampleActionMethods.clicking(addPage.donebutton, 2000, "DONE BUTTON PROPERTYS");
		Thread.sleep(2000);

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0405-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "second",
				AddConfigureTest.active);

		// LOGOUT TO THE SYSTEM
		logout.LogoutFunction();
	}

}
