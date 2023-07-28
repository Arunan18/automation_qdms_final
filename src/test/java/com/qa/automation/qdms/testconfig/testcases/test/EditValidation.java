//***********************************************************************************
//* Description
//*------------
//*Edit Validation - Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 26/04/2023
//* 
//*
//* 
//* Test Case Number       Date    Intis        Comments
//* ================       ====    =====        ========
//* TC-Test-0032      26/04/2023   Saranka     Original Version
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
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class EditValidation extends DriverIntialization {
	static TestConfigPage EditvalidationPage = new TestConfigPage();	
	
	
//============================================ M E T H O D ==============================================================
		@Test	
		public void method() throws InterruptedException, IOException {
//_______________________________________________________
//  LOGIN
//________________________________________________________

				LoginTest.Login();

//_______________________________________________________
//  NAVIGATE TO TEST
//________________________________________________________		

			EditValidation.navigateToTest();

//________________________________________________________
// STEP:1 CHECK ADD VALIDATION MESSAGE EMPTY SAVE, AL READY EXITS
//________________________________________________________

				EditValidation.CheckEditValidation();
				
//________________________________________________________
//  LOGOUT
//________________________________________________________
				
				EditValidation.Logout();

			}
	

//=============================================  T E S T C A S E S =========================================================	

//_________________________________________________________________________
// NAVIGATE TO TEST
//__________________________________________________________________________	

		public static void navigateToTest() {
			PageFactory.initElements(driver, EditvalidationPage);

			// NAVIGATE TO TEST CONFIGURATION
			SampleActionMethods.clicking(TestConfigPage.testconfigurationcard, 2, "TEST CONFIGURATION CARD");

			
 
			// NAVIGATE TO TEST SIDE BUTTON
			SampleActionMethods.clicking(TestConfigPage.TestBtn, 2, "TEST SIDE BUTTON");
		}

//____________________________________________________________________
//  CHECK ADD VALIDATION
//____________________________________________________________________

		public static void CheckEditValidation() throws InterruptedException {
			PageFactory.initElements(driver, EditvalidationPage);

			Thread.sleep(2000);
			
			ActionCommonMethod.editValidation("Test Configuragtion Module.xlsx", "Test", "TC-Test-0032-01", 0, 1, TestConfigPage.Table, TestConfigPage.PlaceHolderTestName, TestConfigPage.ValidationText, TestConfigPage.SaveButton);
			
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

	
	
