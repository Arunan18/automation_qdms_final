//***********************************************************************************
//* Description
//*------------
//* TEST CONFIG-Add Accepted condition function for two result parameter test config test
//***********************************************************************************
//*
//* Author           : WATHSALA WEERAKOON
//* Date Written     : 01/06/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-TCN-0385           01/06/2023   WATHI     Original Version
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

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.AcceptCondition;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.commonmethods.TestParameterStep;
import com.qa.automation.qdms.testconfig.commonmethods.configureEquationStep;

public class AddAcceptedconditionFunction_TwoResultParameterTestConfigTest extends TestConfiguteMainTests {

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

		testCase = extent.createTest("TESTCASE-TC-TCN-0385");

		LoginTest.Login();

		Thread.sleep(2000);

		TestConfigNavigation.TestConfigurationCard();

		Thread.sleep(2000);

		TestConfiguteMainTests.clickontestconfigure();

		// STEP 01- ADD CONFIGUTE TEST
		AddConfigureTest.addConfigureTest("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-AddConfigureTest-0385");

		Thread.sleep(2000);

		// STEP 02- SELECT PARAMETERS
		TestParameterStep.selectParameter("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-selectParameter-0385");

		Thread.sleep(3000);

		// STEP 03- ADD PARAMETER
		TestParameterStep.addPaameter("Test Configuragtion Module", "Test_Configure", "TC-TCN-selectParameter-0385");

		Thread.sleep(2000);

        
		
		WebElement next = driver.findElement(By.xpath("//span[normalize-space()='Next']"));


		Thread.sleep(3000);

		// STEP 04- ADD ACCEPT CRIETERIA
		Acceptedcriteria.Acceptedcriteriatest("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-Acceptedcriteriatest-0385");

		Thread.sleep(3000);

		// STEP 05- SCROLL DOWN
		Actions actions = new Actions(driver);

		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1500);
		next.click();

		Thread.sleep(1500);

		// STEP 06- ADD TEST EQUATION
		AddKeyTestfunction.AddTestEquation("Test Configuragtion Module", "Test_Configure",
				"TC-TCN-AddTestEquation-0349");
		Thread.sleep(1500);

		// STEP 07- CLICK ON NEXT BUTTON
		next.click();

		// STEP 08- CHECK ACCEPTANCE CONDITION BUTTON IS AVAIABLE OR NOT
		TestConfiguteMainTests.acceptancecondition();

		Thread.sleep(2000);

		// STEP 09- CLICK ON ACCEPTANCE CONDITION BUTTON AND CHECK THE DIALOG BOX
		TestConfiguteMainTests.clickonacceptedconditiontab();

		Thread.sleep(3000);

		// STEP 10- ACCEPTED CONDITION
		AcceptCondition.condition("Test Configuragtion Module", "Test_Configure", "TC-TCN-0385-sixth");
		
		// STEP 11- SCROLL DOWN
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(3000);
		
		//STEP 12- CHECK THE ADDED VALUE
		TestConfiguteMainTests.conditionconfirm();

		//Logout.LogoutFunction();

	}
}