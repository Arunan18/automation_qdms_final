//***********************************************************************************
//* Description
//*------------
//* ParameterPaginationTest
//***********************************************************************************
//*
//* Author           : yogalingam kajenthiran
//* Date Written     : 25/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*  TC-PAR-0034     25/04/2023    		 kajan     Original Version
//*						
//************************************************************************************


package com.qa.automation.qdms.testconfig.testcases.testparameter;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.Paginationmethods;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class ParameterPaginationTest extends DriverIntialization{
	
	
	
	
       @Test
	public static void parameterPaginationTest() throws InterruptedException, IOException {
    		 SampleActionMethods action = new SampleActionMethods();
    	   	 TestConfigPage page = new TestConfigPage();
    	   	 TestParameterPage tp=new TestParameterPage();
    	   PageFactory.initElements(driver, page);
   		PageFactory.initElements(driver, action);
   		PageFactory.initElements(driver, tp);
   		

   		// LOGIN TO THE SYSTEM
   		LoginTest.Login();
   		Thread.sleep(2000);
   		
   		// CLICK THE TEST CONFIGURATION MODULE
   		TestConfigPage.testconfigurationcard.click();
   		Thread.sleep(2000);
   		
   		//parameter tab navigate
   		TestParameterPage.pharameter.click();
   		Actions actions = new Actions(driver);
   		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
  		//pagination
		Paginationmethods.pagination("Test Configuragtion Module", "Test_Parameter", "TC-TPM-0025", TestConfigPage.previousbt,TestConfigPage.nextbt, TestConfigPage.pag2nd, TestConfigPage.pag1st, TestConfigPage.pagdrp, TestParameterPage.bef, 4, TestParameterPage.aft, "TEST PARAMETER");
		
	}
       
       
       
   
	

}
