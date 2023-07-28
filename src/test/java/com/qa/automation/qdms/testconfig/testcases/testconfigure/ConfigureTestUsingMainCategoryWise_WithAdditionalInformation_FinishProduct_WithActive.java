//***********************************************************************************
//* Description
//*------------
//* Configure Test Using Main Category Wise With Additional Information (FINISH PRODUCT TEST- WITH ACTIVE)
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 26/05/2023
//* 
//* 
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0322        	26/05/2023   Gobithan     Orginal Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigureTestUsingMainCategoryWise_WithAdditionalInformation_FinishProduct_WithActive
		extends DriverIntialization {

	static TestConfigPage addPage = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static TestParameterStep testparameter = new TestParameterStep();
	static configureEquationStep configure = new configureEquationStep();
	static AcceptCondition accepted = new AcceptCondition();
	static Addaditionalinformation additionalinformation = new Addaditionalinformation();
	static SampleActionMethods action = new SampleActionMethods();

	@Test
	public static void configuretest() throws InterruptedException, IOException {
		PageFactory.initElements(driver, addPage);
		PageFactory.initElements(driver, configPage);
		PageFactory.initElements(driver, testparameter);
		PageFactory.initElements(driver, accepted);
		PageFactory.initElements(driver, additionalinformation);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		// TESTCASE REPORT
		extent.createTest(
				"TC-TCN-0322-ConfigureTest Using MainCategoryWise WithAdditionalInformation FinishProduct WithActive");

		// TOP NAVIGATION
		action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");

		// NAVIGATE TO TEST CONFIGURATION
		Thread.sleep(2000);
		action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");

		// CONFIGURE TEST FIELD
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-first");

		// TEST PARAMETER FIELD
		Thread.sleep(2000);
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-second");

		// ADD PARAMETER FIELD
		Thread.sleep(3000);
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-second");

		// CONFIGURE EQUATION FIELD
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-third");
		Thread.sleep(3000);
		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();

		// ACCEPTED CRITERIA FIELD
		Thread.sleep(3000);
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-fourth");

		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		// ACCEPTED CRITERIA FIELD
		Thread.sleep(3000);
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-fifth");

		Thread.sleep(3000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-seventh");
		TestConfigPage.nextBtn.click();

		// Review test Check in Review Tab
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0322-first",
				"TC-TCN-0322-second", "TC-TCN-0322-third", "TC-TCN-0322-fourth", "TC-TCN-0322-fifth", "",
				"TC-TCN-0322-seventh");

		// DONE BUTTON PROPERTYS
		action.clicking(addPage.donebutton, 2000, "DONE BUTTON ACTION");

		// CONFIRM THE TEST HAS BEAN ADDED OR NOT IN SAMPLE
		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0322-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "first",
				AddConfigureTest.active);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
