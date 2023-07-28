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
//
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
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;

public class ConfigureTestUsingMaterialwise_MaterialwiseAcceptedValue extends TestConfiguteMainTests {

	@Test

	public static void ConfigureTestUsingMaterialwiseMaterialwiseAcceptedValue()
			throws InterruptedException, IOException {

		PageFactory.initElements(driver, tcn);
		PageFactory.initElements(driver, plantequ);
		PageFactory.initElements(driver, src);
		PageFactory.initElements(driver, user);
		PageFactory.initElements(driver, tpp);
		PageFactory.initElements(driver, mtp);
		PageFactory.initElements(driver, tc);
		

		testCase = extent.createTest("TESTCASE-TC-TCN-0349");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		TestConfiguteMainTests.clickontestconfigure();
		
		// STEP 01- ADD CONFIGUTE TEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddConfigureTest-0349");
        
		Thread.sleep(2000);
        
		// STEP 02- SELECT PARAMETERS
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-selectParameter-0349");
        
		Thread.sleep(3000);
        
		// STEP 03- ADD PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-selectParameter-0349");
        
		Thread.sleep(2000); 
        
		//STEP 04- CONFIGURE EQUATION
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-equation-0349");
        
		Thread.sleep(3000);
        
		//STEP 05- CLICK ON NEXT BUTTON 
		WebElement next = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
        
	
		next.click();
        
		Thread.sleep(3000);
        
		//STEP 06- ADD ACCEPT CRIETERIA 
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-Acceptedcriteriatest-0349");
        
		Thread.sleep(3000);
        
		//STEP 08- SCROLL DOWN
		Actions actions = new Actions(driver);
        
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1500);
		next.click();
        
		Thread.sleep(1500);
       
		// STEP 09- ADD TEST EQUATION
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddTestEquation-0349");
		Thread.sleep(1500);
		
		// STEP 10- CLICK ON NEXT BUTTON
		next.click();
        
		Thread.sleep(3000);
       
		// STEP 11- SCROLL DOWN
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        
		Thread.sleep(3000);
		
        // STEP 12- ADD DATA
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0349-seventh");
        
		// STEP 13- CLICK ON NEXT BUTTON
		next.click();
		
        // STEP 14- REVIEW TEST
        ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-AddConfigureTest-0349", "TC-TCN-selectParameter-0349", "TC-TCN-equation-0349", "TC-TCN-Acceptedcriteriatest-0349", "TC-TCN-AddTestEquation-0349","TC-TCN-0349-sixth","TC-TCN-0349-seventh");
        
        // STEP 15- CLICK ON DONE BUTTON
        SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS",tc.donebutton , "DONE BUTTON DISPLAYED", "DONE BUTTON ENABLED");
		
        // STEP 16- CONFIRM THE TEST CONFIGURE
        TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure", "TC-TCN-confirmTestConfigure-0349",AddConfigureTest.testname,AddConfigureTest.testtype,"second", AddConfigureTest.active);

		Logout.LogoutFunction();

	}
}