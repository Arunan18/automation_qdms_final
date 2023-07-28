//***********************************************************************************
//* Description
//*------------
//* Configure Test  Using Main Category wise (with due day)
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 30/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0335        	30/05/2023     Saranka     Orginal Version
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
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.Addaditionalinformation;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigureConfirmStep;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigureTestUsingMainCategorywiseDueDay extends DriverIntialization {
	static TestConfigPage catDueDay = new TestConfigPage();
	static configGroupTestsPage configPage = new configGroupTestsPage();
	static SampleActionMethods action = new SampleActionMethods();

	@Test
	public void configureTestMaterialFunc() throws InterruptedException, IOException {
		PageFactory.initElements(driver, catDueDay);
		PageFactory.initElements(driver, configPage);
//_______________________________		
// LOGIN TO THE SYSTEM
//_______________________________		
		LoginTest.Login();

//_______________________________        
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        
		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", catDueDay.testconfigurationcard,
				"01--TEST CONFIGURATION CARD DISPLAYED", "02--TEST CONFIGURATION CARD ENABLED",
				catDueDay.testconfigurationtext, "TEST CONFIGURATION",
				"03--ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

//_______________________________       
// NAVIGATE TO TEST CONFIGURATION
//_______________________________        
		WebElement TestConFigure = driver.findElement(By.xpath("//div[contains(text(),'Test Configure')]"));
		SampleActionMethods.clicking(TestConFigure, 2, "TEST CONFIGURE");

//_______________________________        
//STEP1 :ADD  THE CONFIGURETEST  
// _______________________________

		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-first");
		Thread.sleep(2000);

//__________________________________________________________       
//STEP2 :SELECTING THE PARAMETER IN TEST PARAMETER PAGE
// __________________________________________________________

		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-Second");
		Thread.sleep(3000);

//________________________________________        
//STEP3 :ADD THE PARAMETER
//_______________________________________        

		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-Second");
		Thread.sleep(2000);
//_______________________________________
//STEP4 :ADD THE EQUATIONS
//_______________________________________        

		configureEquationStep.equation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-Third");
		Thread.sleep(3000);

//_______________________________________
//CLICK ON NEXT BUTTON
//_______________________________________

		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//_____________________________________       
//STEP5 : ADD THE ACCEPTCRETERIA
//______________________________________        
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-fourth");
		Thread.sleep(3000);

//_______________________________        
//CLICK ON NEXT BUTTON  
//_______________________________        
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

//_______________________________        
//MOVE TO NEXT STEP 
//_______________________________        
		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//_______________________________       
//STEP6 :ADD TEST KEYS  
//_______________________________        
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-fifth");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		TestConfigPage.nextBtn.click();

		Thread.sleep(3000);

//__________________________________    
//STEP8 :ADD ADITIONAL INFORMATION
//_________________________________        

		Thread.sleep(3000);
		Addaditionalinformation.adddata("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-seventh");

//__________________________________       
//DOWN THE PAGE 
//___________________________________       

		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

//_________________________________        
//MOVE TO NEXT PAGE 
//___________________________________      

		TestConfigPage.nextBtn.click();
		Thread.sleep(3000);
//____________________________________
// REVIEW TEST CHECK IN REVIEW TAB
//___________________________________        

		ReviewTestConfig.ReviewTest("Test Configuragtion Module", "Test_Configure", "TC-TCN-0335-first",
				"TC-TCN-0335-Second", "TC-TCN-0335-Third", "TC-TCN-0335-fourth", "TC-TCN-0335-fifth",
				"TC-TCN-0335-sixth", "TC-TCN-0335-seventh");

//__________________________________
// DONE BUTTON CLICK
//________________________________     

		SampleCommonMethods.singleclick("DONE BUTTON PROPERTYS", catDueDay.donebutton, "DONE BUTTON DISPLAYED",
				"DONE BUTTON ENABLED");

// __________________________________
// CHECK SAMPLE CODE
// _________________________________

		TestConfigureConfirmStep.confirmTestConfigure("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-0335-eighth", AddConfigureTest.testname, AddConfigureTest.testtype, "First",
				AddConfigureTest.active);

// _______________________________
// LOGOUT TO THE SYSTEM
// _______________________________
		Logout.LogoutFunction();

	}

}
