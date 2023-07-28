//***********************************************************************************
//* Description
//*------------
//*Configure Test   Using Sub Category wise (with due day)
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 30/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0336        	30/05/2023     Saranka     Orginal Version
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
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigureTestUsingSubCategorywiseWithDueDay extends DriverIntialization {
	static TestConfigPage catDueDay = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static SampleActionMethods action = new SampleActionMethods();

	@Test
	public void configureTestSubCatFunc() throws InterruptedException, IOException {
		PageFactory.initElements(driver, catDueDay);
		PageFactory.initElements(driver, configPage);

//__________________________________		
// LOGIN TO THE SYSTEM
//__________________________________	
		
		LoginTest.Login();
//__________________________________
// NAVIGATE TO TEST CONFIGURATION
//__________________________________	
		
		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", catDueDay.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				catDueDay.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
//__________________________________
// NAVIGATE TO TEST CONFIGURATION
//__________________________________		
		
		WebElement TestConFigure = driver.findElement(By.xpath("//div[contains(text(),'Test Configure')]"));
		SampleActionMethods.clicking(TestConFigure, 2, "TEST CONFIGURE");
		
//__________________________________
// STEP1 :ADD THE CONFIGURETEST
//__________________________________
		
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-first");
		Thread.sleep(2000);

//__________________________________		
// STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
//__________________________________	
		
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-Second");
		Thread.sleep(3000);
		
//__________________________________		
// STEP3 :ADD THE PARAMETER
//__________________________________	
		
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-Second");
		Thread.sleep(2000);
		
//__________________________________		
// STEP4 :ADD THE EQUATIONS
//__________________________________	
		
		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-Third");
		Thread.sleep(3000);
//__________________________________
// CLICK ON NEXT BUTTON
//__________________________________
		
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//__________________________________		
// STEP5 : ADD THE ACCEPTCRETERIA
//__________________________________		
		
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-fourth");
		Thread.sleep(3000);
//__________________________________		
// CLICK ON NEXT BUTTON
//__________________________________		
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//__________________________________		
// MOVE TO NEXT STEP
//__________________________________	
		
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
		
//__________________________________		
// STEP6 :ADD TEST KEYS
//__________________________________		
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-fifth");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		Thread.sleep(3000);
//__________________________________
// STEP8 :ADD ADITIONAL INFORMATION
//__________________________________	
		
		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-seventh");

//__________________________________		
// DOWN THE PAGE
//__________________________________
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
//__________________________________		
// MOVE TO NEXT PAGE
//__________________________________	
		
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
		
//____________________________________
// REVIEW TEST CHECK IN REVIEW TAB
//___________________________________  
		
		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0336-first",
				"TC-TCN-0336-Second", "TC-TCN-0336-Third", "TC-TCN-0336-fourth", "TC-TCN-0336-fifth",
				"TC-TCN-0336-sixth", "TC-TCN-0336-seventh");

//_______________________________
// DONE BY CLICK
//_______________________________
		
		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", catDueDay.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");
// __________________________________
// CHECK SAMPLE CODE
// _________________________________

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0336-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "First",
				AddConfigureTest.active);
//_______________________________
// LOGOUT TO THE SYSTEM
//_______________________________		
		Logout.LogoutFunction();

	}

}
