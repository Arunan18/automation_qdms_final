//***********************************************************************************
//* Description
//*------------
//*Add Validation - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*TC-Test-0023        26/04/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.sample.pages.IncomingSamplePage;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class AddValidation extends DriverIntialization {
	static TestConfigPage addValidationPage = new TestConfigPage();

//============================================ M E T H O D ==============================================================
	@Test
	public static void Method() throws InterruptedException, IOException {

//_______________________________________________________
//  LOGIN
//________________________________________________________

		LoginTest.Login();

//_______________________________________________________
//  NAVIGATE TO TEST
//________________________________________________________		

		AddValidation.navigateToTest();

//________________________________________________________
// STEP:1 CHECK ADD VALIDATION MESSAGE
//________________________________________________________

		AddValidation.CheckAddvalidation();
		
//________________________________________________________
//  LOGOUT
//________________________________________________________
		
		AddValidation.Logout();

	}

//=============================================  T E S T C A S E S =========================================================	

//_________________________________________________________________________
// NAVIGATE TO TEST
//__________________________________________________________________________	

	public static void navigateToTest() {
		PageFactory.initElements(driver, addValidationPage);

// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

// NAVIGATE TO TEST SIDE BUTTON
		SampleCommonMethods.methodoneclick("STEP:1 TEST PROPERTIES", TestConfigPage.TestNavigation,
				"TEST SIDE BUTTON IS DISPLAY", "TEST SIDE BUTTON IS ENABLED", TestConfigPage.ParameterText,
				"TEST SIDE BUTTON", "ON CLICK THE TEST BUTTON IT'S REDERECT TO CORRECT FORM");
	}

//____________________________________________________________________
//  CHECK ADD VALIDATION
//____________________________________________________________________

	public static void CheckAddvalidation() throws InterruptedException {
		PageFactory.initElements(driver, addValidationPage);

		Thread.sleep(2000);

		ActionCommonMethod.addValidation("Test Configuragtion Module.xlsx", "Test", "TC-Test-0023-01",
				TestConfigPage.addButton, TestConfigPage.PlaceHolderTestName, TestConfigPage.ValidationText,
				TestConfigPage.SaveButton); 
		
		ActionCommonMethod.addValidation("Test Configuragtion Module.xlsx", "Test", "TC-Test-0023-02",
				TestConfigPage.addButton, TestConfigPage.PlaceHolderTestName, TestConfigPage.ValidationText,
				TestConfigPage.SaveButton); 
		
		
	

	} 

//____________________________________________________________
//LOGOUT
//______________________________________________________________	
	public static void Logout() throws InterruptedException {

		Thread.sleep(2000);
		WebElement Admin = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color'])[1]"));
		Admin.click(); 

		Thread.sleep(2000);
		WebElement Logout = driver.findElement(By.xpath(
				"//body/div/div/div[contains(@class,'ant-dropdown ant-dropdown-placement-bottomRight')]/ul[@role='menu']/li[@role='menuitem']/span[@class='ant-dropdown-menu-title-content']/p[1]"));
		Logout.click();

	}
 
}
