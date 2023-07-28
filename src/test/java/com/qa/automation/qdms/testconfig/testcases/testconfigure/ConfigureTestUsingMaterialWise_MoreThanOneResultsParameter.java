//***********************************************************************************
//* Description
//*------------
//**TC-TCN-0346 - Configure Test Using Material wise (more than one results parameter)

//***********************************************************************************
//*
//* Author           : SIVABALAN RAHUL
//* Date Written     : 26/05/2023
//* 
//*
//* 
//* Test Case Number       Date         AUTHOR        Comments
//* ================       ====         =====        ========
//*TC-TCN-0346          26/05/2023      RAHUL.S       Original Version
//*                     01/06/2023      RAHUL.S       RECHECKED
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

public class ConfigureTestUsingMaterialWise_MoreThanOneResultsParameter extends DriverIntialization {
	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	@Test
	public static void action() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);
		extent.createTest("TC-TCN-0346:Configure Test Using Material wise (more than one results parameter)");

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// TOP NAVIGATION
		action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);

		// NAVIGATE TO TEST CONFIGURATION
		action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-first");
		Thread.sleep(2000);

		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-second");
		Thread.sleep(3000);

		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-second");
		Thread.sleep(2000);

		// STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-third");
		Thread.sleep(3000);

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// STEP5 : ADD THE ACCEPTCRETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-fourth");
		Thread.sleep(3000);

		// CLICK ON NEXT BUTTON
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// MOVE TO NEXT STEP
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// STEP6 :ADD TEST KEYS
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-fifth");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// STEP7 :ADD ACCEPTED CONDITION
		AcceptCondition.condition("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-sixth");

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// STEP8 :ADD ADITIONAL INFORMATION
		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-seventh");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

		// Review test Check in Review Tab
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0346-first",
				"TC-TCN-0346-second", "TC-TCN-0346-third", "TC-TCN-0346-fourth", "TC-TCN-0346-fifth",
				"TC-TCN-0346-sixth", "TC-TCN-0346-seventh");

		// NAVIGATE TO TEST CONFIGURATION
		action.clicking(TestConfigPage.donebutton, 2000, "DONE BUTTON CONFIRMATION");
		Thread.sleep(2000);

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0346-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "first",
				AddConfigureTest.active);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
