//***********************************************************************************
//* Description
//*------------
//* Group Key Close Button Function- Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 09/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0063         09/05/2023     Saranka     Original Version
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

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;

import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class GroupKeyCloseButtonFunction extends DriverIntialization {

	static TestConfigPage CancelBtn = new TestConfigPage();
	
//====================================================  M E T H O D ========================================================
	@Test
	public void method() throws InterruptedException, IOException {
		
		LoginTest.Login();
		
		GroupKeyCloseButtonFunction.CloseButtonFunctionality();
		
		Logout.LogoutFunction();
		
		
	}

//======================================================  T E S T C A S E S ================================================

//_____________________________________________
// NAVIGATE TO MANAGE TEST
//______________________________________________	

	public static void CloseButtonFunctionality() throws InterruptedException, IOException {
		PageFactory.initElements(driver, CancelBtn);

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
				"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
				TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
				"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");

		Thread.sleep(2000);
		TestConfigPage.ManageCofigureMenuBar.click();

//____________ SCROLL ______________________________

		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
		try {
			boolean pass = false;
			Thread.sleep(1000);
			for (int i = 0; i < 1000; i++) {
				if (!pass) {
					try {
						driver.findElement(By.xpath("//th[normalize-space()='Edit Configure']")).click();
						pass = true;
					} catch (Exception e) {
					}
				}
				if (!pass) {
					actions.sendKeys(Keys.ARROW_RIGHT).perform();
					Thread.sleep(2);
				} else {
					break;
				}
			}
		} catch (Exception e) {

		}
	TestConfigPage.Editconfi.click();
//____________________________________	
//NAVIGATE TO PARAMETER
//____________________________________	
		
			Thread.sleep(2000);
			SampleActionMethods.clicking(TestConfigPage.TestParameterStepTwo, 2, "TEST PARAMETER ");
			
				
//____________________________________	
// NAVIGATE TO ADD-GROUP
//____________________________________	
						
			WebElement AddGroup = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
			Thread.sleep(2000);
			SampleActionMethods.clicking(AddGroup, 2, "STEP:1 ADD GROUP");
			

//____________________________			
// BEFOR CLCIK CLOSE BUTTON
//_____________________________
			
			WebElement ModalContent = driver.findElement(By.xpath("//div[@class='ant-modal-content']"));
			boolean isModalVisible = ModalContent.isDisplayed();

//___________________________________	
// CLOSE BUTTON CLICK
//____________________________________
			
			WebElement CloseBtn = driver.findElement(By.xpath("//span[@aria-label='close']"));
			Thread.sleep(2000);
			SampleActionMethods.clicking(CloseBtn, 2, "STEP:2 CLOSE BUTTON");

//__________________________________			
//AFTER CLCIK CLOSE BUTTON
//__________________________________			
			ModalContent = driver.findElement(By.xpath("//div[@class='ant-modal-content']"));
			boolean isModalNotVisible = !ModalContent.isDisplayed();

			testCase = extent.createTest("STEP:3 AFTER CLICK CLOSE BUTTON VERIFY");
			if (isModalVisible && isModalNotVisible) {
			    testCase.log(Status.PASS, "Modal was visible and then hidden after clicking close button");
			    System.out.println("Modal was visible and then hidden after clicking close button");
			} else {
			    testCase.log(Status.FAIL, "Modal was not visible or not hidden after clicking close button");
			    System.out.println("Modal was not visible or not hidden after clicking close button");
			}

	}

}
