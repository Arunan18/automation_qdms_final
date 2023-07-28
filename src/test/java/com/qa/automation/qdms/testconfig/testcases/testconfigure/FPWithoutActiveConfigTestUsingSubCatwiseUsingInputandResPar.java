//***********************************************************************************
//* Description
//*------------
//*FPWithoutActiveConfigTestUsingSubCatwiseUsingInputandResPar
//***********************************************************************************
//*
//* Author           : Priyanka Sundaramoorthy
//* Date Written     : 09/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0407           09/06/2023    Priyanka       Orginal Version
//*
//*******************************************************************************

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
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class FPWithoutActiveConfigTestUsingSubCatwiseUsingInputandResPar extends DriverIntialization {

	static SampleActionMethods action = new SampleActionMethods();
	static TestConfigPage testnav = new TestConfigPage();
	static ActionCommonMethod actions = new ActionCommonMethod();
	static SampleCommonMethods sample = new SampleCommonMethods();
	static TestConfigNavigation config = new TestConfigNavigation();

	@Test
	public static void FPTestActiveWithKeyTest() throws IOException, InterruptedException {

		extent.createTest("TC-TCN-0407:FPWithoutActiveConfigTestUsingSubCatwiseUsingInputandResPar");

		PageFactory.initElements(driver, testnav);
		PageFactory.initElements(driver, config);
		PageFactory.initElements(driver, action);

		// LOGIN TO THE SYSTEM
		LoginTest.Login();

		/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_01-- TEST CONFIGURATION PROPERTIES",
				TestConfigPage.testconfigurationcard, "01--TEST CONFIGURATION CARD DISPLAYED",
				"02--TEST CONFIGURATION CARD ENABLED", TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		TestConfigNavigation.mainmethod("STEP_02-- TEST TOP NAVIGATION PROPERTIES", TestConfigPage.testtopnav,
				"01--TEST TOP NAVIGATION BUTTON DISPLAYED", "02--TEST TOP NAVIGATION BUTTON ENABLED",
				TestConfigPage.testleftnav, TestConfigPage.testparameterleftnav, TestConfigPage.testconfigleftnav,
				TestConfigPage.configgrouptestleftnav, "03--ON CLICK THE TEST TOP NAVIGATION SHOWES CORRECT WINDOW");

		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		SampleCommonMethods.methodoneclick("STEP_03-- TEST CONFIGURE PROPERTIES", TestConfigPage.testconfigleftnav,
				"01--TEST CONFIGURE LEFT NAVIGATION BUTTON DISPLAYED",
				"02--TEST CONFIGURE LEFT NAVIGATION BUTTON ENABLED", TestConfigPage.testconfigurationheading,
				"Configure Test",

				"03--ON CLICK THE TEST CONFIGURE LEFT NAVIGATION SHOWES CORRECT WINDOW");

		// STEP1 :ADD THE CONFIGURETEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-first");
		Thread.sleep(2000);
		// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-secound");
		Thread.sleep(3000);
		// STEP3 :ADD THE PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-secound");
		Thread.sleep(2000);
		// STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-third");
		Thread.sleep(3000);

		// CLICK ON NEXT BUTTON
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
		// STEP5 : ADD THE ACCEPTCRETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-fourth");
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
		// CLICK ON NEXT BUTTON
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// MOVE TO NEXT STEP
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
		// STEP8 :ADD ADITIONAL INFORMATION
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-seventh");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		TestConfigPage.nextBtn.click();

		// Review test Check in Review Tab
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0407-first",
				"TC-TCN-0407-secound", "TC-TCN-0407-third", "TC-TCN-0407-fourth", "TC-TCN-0407-fifth",
				"TC-TCN-0407-sixth", "TC-TCN-0407-seventh");

		// Done Button Clicksingleclick
		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", TestConfigPage.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0407-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "first",
				AddConfigureTest.active);

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

}
