//***********************************************************************************
//* Description
//*------------
//* TEST CONFIG-Configure Test  Using Material wise  (Material wise accepted value)
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 25/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0349           25/05/2023   WATHI     Original Version
//						 08/06/2023	  ARUNAN	Updated Version
//
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
import com.qa.automation.qdms.testconfig.commonmethods.AcceeptedCretiaStep;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class FPConfigureTestUsingMaterialwise_MaterialwiseAcceptedValueCommonWise extends DriverIntialization {

	 
	@Test
	public static void ConfigureTestUsingMaterialwiseMaterialwiseAcceptedValue() throws InterruptedException, IOException{
		SampleActionMethods action = new SampleActionMethods();
		TestConfigPage testnav = new TestConfigPage();
		TestConfigNavigation config = new TestConfigNavigation();
		PageFactory.initElements(driver, testnav);
        PageFactory.initElements(driver, config);
        PageFactory.initElements(driver, action);
	  
	        extent.createTest("TC-TCN-0349:RM_WithActive_ConfigureTestUsingMaterialwise_MaterialwiseAcceptedValu");
	        // LOGIN TO THE SYSTEM
	        LoginTest.Login();
	        /* TEST CONFIGURATION CARD PROPERTIES DISPLAYED & ENABLED */
	        SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2000, "TEST CONFIGURATION CARD");
	        Thread.sleep(2000);
	        
	        /* TEST TOP NAVIGATION PROPERTIES DISPLAYED & ENABLED */
	        SampleActionMethods.clicking(TestConfigPage.testtopnav, 2000, "TEST CONFIGURE TOP NAVIGATION BUTTON");
	        Thread.sleep(2000);
	        /* TEST CONFIGURE SIDE NAVIGATION PROPERTIES DISPLAYED & ENABLED */
	        SampleActionMethods.clicking(TestConfigPage.testconfigleftnav, 2000, "TEST CONFIGURE LEFT NAVIGATION BUTTON");
	        Thread.sleep(2000);
	//STEP1 :ADD  THE CONFIGURETEST    
	        AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddConfigureTest-0349");
	        Thread.sleep(2000);
	//STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
	        TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-selectParameter-0349");
	        Thread.sleep(3000);
	//STEP3 :ADD THE PARAMETER        
	        TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-selectParameter-0349");
	        Thread.sleep(3000);
	//STEP4 :ADD THE EQUATIONS
	        configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-equation-0349");
	        Thread.sleep(3000);
	//MOVE TO NEXT PAGE
	        TestConfigPage.nextBtn.click();
	        Thread.sleep(3000);
	//STEP5 : ADD THE ACCEPTCRETERIA
	        AcceeptedCretiaStep.accepted("Test Configuragtion Module", "Test_Configure", "TC-TCN-Acceptedcriteriatest-0349");
	        Thread.sleep(3000);
	//MOVE TO DOWN 
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	//MOVE TO NEXT PAGE 
	        TestConfigPage.nextBtn.click();
	        Thread.sleep(3000);
	//STEP6 :ADD TEST KEYS 
	        AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddTestEquation-0349");
	//MOVE TO NEXT PAGE    
	        Thread.sleep(3000);
	        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	        TestConfigPage.nextBtn.click();
	//STEP7 :ADD ADITIONAL INFORMATION
	        Thread.sleep(3000);
	        Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0349-seventh");
	//DOWN THE PAGE        
	        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
	//MOVE TO NEXT PAGE        
	        TestConfigPage.nextBtn.click();
	        Thread.sleep(3000);
	// STEP8:  REVIEW TEST CHECK IN REVIEW TAB 
	        ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddConfigureTest-0349",
	                "TC-TCN-selectParameter-0349", "TC-TCN-equation-0349", "TC-TCN-Acceptedcriteriatest-0349", "TC-TCN-AddTestEquation-0349",
	                "", "TC-TCN-0349-seventh");
	//STEP9:    DONE BUTTON CLICK
	        SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", TestConfigPage.donebutton, "DONE BUTTON DISPLAYED",
	                "DONE BUTTON ENABLED");
	//STEP10 :CONFIRM THE TEST HAS BEEN ADDED OR NOT IN SAMPLES    
	        TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
	                "TC-TCN-confirmTestConfigure-0349", AddConfigureTest.testname, AddConfigureTest.testtype, "Second",
	                AddConfigureTest.active);
	        
	// LOGOUT TO THE SYSTEM
	        Logout.LogoutFunction();
	        
	       
	    }
	}





