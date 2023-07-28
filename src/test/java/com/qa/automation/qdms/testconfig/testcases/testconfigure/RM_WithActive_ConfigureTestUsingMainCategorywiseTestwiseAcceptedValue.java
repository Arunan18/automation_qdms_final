//***********************************************************************************
//* Description
//*------------
//*RM_WithActive_ConfigureTestUsingMainCategorywiseTestwiseAcceptedValue
//***********************************************************************************
//*
//* Author           : Niluxy Krishnathavam
//* Date Written     : 25/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0257            25/05/2023    Niluxy       Orginal Version
//*
//************************************************************************************

package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class RM_WithActive_ConfigureTestUsingMainCategorywiseTestwiseAcceptedValue extends DriverIntialization {
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
		
		extent.createTest("TC-TCN-0257:RM_WithActive_ConfigureTestUsingMainCategorywiseTestwiseAcceptedValue");
		// LOGIN TO THE SYSTEM
		LoginTest.Login();

/* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
		action.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURATION CARD");
		Thread.sleep(2000);
		
		/* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		action.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
		Thread.sleep(2000);
		/* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
		action.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
		Thread.sleep(2000);
//STEP1 :ADD  THE CONFIGURETEST	
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-first");
		Thread.sleep(2000);
//STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-second");
		Thread.sleep(3000);
//STEP3 :ADD THE PARAMETER		
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-second");
		Thread.sleep(3000);
//STEP4 :ADD THE EQUATIONS
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-third");
		Thread.sleep(3000);
//MOVE TO NEXT PAGE
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP5 : ADD THE ACCEPTCRETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-fourth");
		Thread.sleep(3000);
//MOVE TO DOWN 
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//MOVE TO NEXT PAGE 
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//STEP6 :ADD TEST KEYS 
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-fifth");
//MOVE TO NEXT PAGE	
		Thread.sleep(3000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();
//STEP7 :ADD ADITIONAL INFORMATION
		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-seventh");
//DOWN THE PAGE		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//MOVE TO NEXT PAGE		
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);

// STEP8:  REVIEW TEST CHECK IN REVIEW TAB 
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0257-first",
				"TC-TCN-0257-second", "TC-TCN-0257-third", "TC-TCN-0257-fourth", "TC-TCN-0257-fifth",
				"TC-TCN-0257-sixth", "TC-TCN-0257-seventh");

//STEP9:    DONE BUTTON CLICK
		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", testnav.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");

//STEP10 :CONFIRM THE TEST HAS BEEN ADDED OR NOT IN SAMPLES    
		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0257-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "First",
				AddConfigureTest.active);
		
// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}
}
