//***********************************************************************************
//* Description
//*------------
//*Test Parameter search icon function- Test Configuration - Test Case
//***********************************************************************************
//*
//* Author           : Saranka Somessaran
//* Date Written     : 01/05/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//* TC-TCN-0090         01/05/2023   Saranka     Original Version
//*
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.testconfigure;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;


import com.qa.automation.qdms.sample.commonmethods.SampleActionMethods;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;

import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testcases.plant.MultiSearchMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestParameterSearchIconFunction extends DriverIntialization {
  static	TestConfigPage SearchFunctionPage = new TestConfigPage();
  
 
 //==================================== M ET H O D  ======================================== 
  
  @Test
  public void methodCalling() throws InterruptedException, IOException {
	  
	LoginTest.Login();
	
	TestParameterSearchIconFunction.naviagteToTestConfigurationParameter();
	  	  

//____________________________________________________________
	
//  STEP:1 PARAMETRT SEARCH ICON VISIBLE AND ENABLE
	  
//  STEP:2 VERIFY THAT THE SEARCH MODAL IS DISPLAY 
	  
//	STEP:3 VERIFY THAT THE SEARCH MODEL CONTAINS THE EXPECTED ELEMENTS
	  
//	 STEP : 4 ENTER A SEARCH TERM AND CLICK THE SEARCH BUTTON
	  
//______________________________________________________________________
	  
	  
	  TestParameterSearchIconFunction.ParameterSearchIconFunction();
	  
//_______________________________________________________________________
// LOGOUT 
//______________________________________________________________________
	  
	  MultiSearchMethods.Logout();
	  
  }
	
  
 //===========================================  T E S T C A S E =========================================================
	
//_________________________________________________________________
//NAVIGATE TO TEST CONFIGURATION PARAMETER
//_________________________________________________________________ 
	public static void naviagteToTestConfigurationParameter() throws InterruptedException {
		PageFactory.initElements(driver, SearchFunctionPage);
		
		// NAVIGATE TO TEST CONFIGURATION

		SampleCommonMethods.methodoneclick("STEP:1 TEST CONFIGURATION PROPERTIES", TestConfigPage.testconfigurationcard,
		"TEST CONFIGURATION CARD DISPLAYED", "TEST CONFIGURATION CARD ENABLED",
		TestConfigPage.testconfigurationtext, "TEST CONFIGURATION",
		"ON CLICK THE TEST CONFIGURATION CARD IT'S REDERECT TO CORRECT WINDOW");
		
		
        Thread.sleep(2000);
        TestConfigPage.ManageCofigureMenuBar.click();
        
        Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//div[@class='ant-table-body']")).click();
        try {
            boolean pass = false;
            Thread.sleep(1000);
            for (int i = 0; i < 1000; i++) {
                if (!pass) {
                    try {
                        driver.findElement(By.xpath("///th[@class='ant-table-cell'][13]")).click();
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
         
     
        
        
		
	}
  
    
  
//__________________________________________________________________
//  SEARCH ICON FUNCTION
//__________________________________________________________________
	
	public static void ParameterSearchIconFunction() throws InterruptedException {
		PageFactory.initElements(driver, SearchFunctionPage);
		
		 TestConfigPage.Editconfi.click();	
         
			//NAVIGATE TO PARAMETER
			Thread.sleep(2000);
			SampleActionMethods.clicking(TestConfigPage.TestParameterStepTwo, 2, "TEST PARAMETER STEP TWO");		
			
			WebElement AddGroup = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
			Thread.sleep(2000);
			AddGroup.click();
		
		
		
		
		SampleActionMethods.clicking(TestConfigPage.ParameterSearchIcon, 2,"PARAMETER SEARCH ICON");
		
		
	
		testCase = extent.createTest("STEP 2: VERIFY THAT THE SEARCH MODAL IS DISPLAY");
		
//_____________________________________________________________________
//  STEP:2 VERIFY THAT THE SEARCH MODAL IS DISPLAY
//________________________________________________________________________		
		WebElement searchModal = driver.findElement(By.xpath("(//div[@class='ant-table-filter-dropdown'])[1]"));
		if (searchModal.isDisplayed()) {
		    // Log the test step status as pass if the search modal is displayed
		    testCase.log(Status.PASS, "SEARCH MODAL IS DISPLAYED ");
		} else {
		    // Log the test step status as fail if the search modal is not displayed
		    testCase.log(Status.FAIL, "SEARCH MODAL IS NOT DISPLAYED");
		}
		
//______________________________________________________________		
//  STEP :3  VERIFY THAT THE SEARCH MODEL CONTAINS THE EXPECTED ELEMENTS
//_____________________________________________________________		
		
		testCase = extent.createTest("STEP:3 VERIFY THAT THE SEARCH MODEL CONTAINS THE EXPECTED ELEMENTS");
		WebElement searchInput = searchModal.findElement(By.xpath("//input[contains(@placeholder,'Parameter')]"));
		if (searchInput.isDisplayed()){
		    // Log the test step status as pass if the search input field is displayed
			testCase.log(Status.PASS, "Search input field is displayed");
		} else {
		    // Log the test step status as fail if the search input field is not displayed
			testCase.log(Status.FAIL, "Search input field is not displayed");
		}

		WebElement searchButton = searchModal.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-sm']"));
		if (searchButton.isDisplayed()) {
		    // Log the test step status as pass if the search button is displayed
			testCase.log(Status.PASS, "Search button is displayed");
		} else {
		    // Log the test step status as fail if the search button is not displayed
			testCase.log(Status.FAIL, "Search button is not displayed");
		}
//_____________________________________________________________________________
//   STEP : 4 ENTER A SEARCH TERM AND CLICK THE SEARCH BUTTON
//_____________________________________________________________________________	
		testCase = extent.createTest("STEP : 4 ENTER A SEARCH TERM AND CLICK THE SEARCH BUTTON");
		Thread.sleep(2000);
		TestConfigPage.ParameterTextBox.sendKeys("me");
		
		SampleActionMethods.clicking(TestConfigPage.SearchButtonParameter, 2, " PARAMETER SEARCH BUTTON");

		//  VERIFY THAT THE SEARCH RESULTS ARE DISPLAYED 
		WebElement searchResultsTable = driver.findElement(By.xpath("//div[@class='ant-table-body']"));
		List<WebElement> searchResultsRows = searchResultsTable.findElements(By.xpath("//tr"));
		assertTrue(searchResultsRows.size() > 0, "Search results table is empty");

		// VALIDATE THE CONTENT OF THE SEARCH RESULTS 
		for (WebElement row : searchResultsRows) {
		    List<WebElement> cells = row.findElements(By.xpath("//td"));
		    // Validate the content of each cell in the row
	
		}

		driver.navigate().refresh();
		Thread.sleep(2000);
	}
} 
