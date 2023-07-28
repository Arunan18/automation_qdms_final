/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Test - Material Test Table - Add Test-Pop up Screen "Cancel" button Functionality
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-TC-0058             23/06/2023            kajan         Original Version
*                                       
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.test;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.sample.commonmethods.SampleCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class addTestCancelButtonfunction extends DriverIntialization{

@Test
	public void addtestcancelbtnfunI() throws InterruptedException, IOException {
		//login test
		LoginTest.Login();
		
		//click testconfigration
		clicktestconfigrationcard();
		
		
		//logout test
		Logout.LogoutFunction();
		
	}
	public void clicktestconfigrationcard() {
		TestConfigPage tcp=new TestConfigPage();
		PageFactory.initElements(driver, tcp);
		
		try {
			TestConfigPage.testconfigurationcard.click();
			Thread.sleep(500);
			try {
				TestConfigPage.TestBtn.click();
				Thread.sleep(500);
				
				try {
					TestConfigPage.addButton.click();
					Thread.sleep(1000);
					addtestcancelbtnfun();
				}  catch (NoSuchElementException e) {
					testCase = extent.createTest("Checking The TEST CONFIGRATION TEST ");
		            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION TEST ADD BUTTON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (ElementClickInterceptedException e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST ADD BUTTON");
		            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION TEST ADD BUTTON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (Exception e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST ADD BUTTON");
		            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
		        }
				
				
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking The TEST CONFIGRATION TEST BUTTON");
	            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION TEST BUTTON'");
	            testCase.log(Status.FAIL, "TEST FAIL ❎");
	        }
	        catch (ElementClickInterceptedException e) {
	        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST BUTTON");
	            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION TEST BUTTON'");
	            testCase.log(Status.FAIL, "TEST FAIL ❎");
	        }
	        catch (Exception e) {
	        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST BUTTON");
	            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
	        }
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The TEST CONFIGRATION");
            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (ElementClickInterceptedException e) {
        	testCase = extent.createTest("Checking The TEST CONFIGRATION");
            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (Exception e) {
        	testCase = extent.createTest("Checking The TEST CONFIGRATION");
            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
        }
		
	}
	public void addtestcancelbtnfun() {
		TestConfigPage tcp=new TestConfigPage();
		PageFactory.initElements(driver, tcp);
		try {
//			boolean value1= TestConfigPage.addtestcancelbtn.isDisplayed();
//			SampleCommonMethods.TestCasePrint("cancel button visiblity", "true",String.valueOf(value1));
////			boolean value2 = TestConfigPage.addtestcancelbtn.isEnabled();
//			SampleCommonMethods.TestCasePrint("cancel button enablity", "true",String.valueOf(value2));
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking The cancel button function");
            testCase.log(Status.INFO, "Unable to Locate the element 'cancel button function'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (ElementClickInterceptedException e) {
        	testCase = extent.createTest("Checking The cancel button function");
            testCase.log(Status.INFO, "Unable to Click on the element 'cancel button function'");
            testCase.log(Status.FAIL, "TEST FAIL ❎");
        }
        catch (Exception e) {
        	testCase = extent.createTest("Checking The cancel button function");
            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
        }
		
	}
	
}
