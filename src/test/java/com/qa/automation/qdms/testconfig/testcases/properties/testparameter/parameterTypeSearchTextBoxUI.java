/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Test Parameter Table "Parameter Type" Search Drop Down Properties
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-PAR-0078             22/06/2023            kajan         Original Version
*                                       
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testparameter;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class parameterTypeSearchTextBoxUI extends DriverIntialization{


@Test
	public void parametertypeSearchpopupUIProperties() throws InterruptedException, IOException {
		//login test
		LoginTest.Login();
		
		//click testconfigration
		clicktestconfigrationcard();
		
		
		//logout test
		Logout.LogoutFunction();
		
	}
	public void clicktestconfigrationcard() {
		TestParameterPage tp=new TestParameterPage();
		TestConfigPage tcp=new TestConfigPage();
		PageFactory.initElements(driver, tcp);
		PageFactory.initElements(driver, tp);
		
		try {
			TestConfigPage.testconfigurationcard.click();
			Thread.sleep(500);
			try {
				TestConfigPage.TestParameter.click();
				Thread.sleep(500);
				try {
					TestParameterPage.parametertypesearchicon.click();
					Thread.sleep(1000);
					parametertabparametertypeSearchpopuptextboxUI();
				}  catch (NoSuchElementException e) {
					testCase = extent.createTest("Checking The TEST CONFIGRATION parameter type search icon");
		            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION parameter type  SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (ElementClickInterceptedException e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter type SEARCH ICON");
		            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION parameter type  SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (Exception e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter type SEARCH ICON");
		            testCase.log(Status.FAIL, "TEST FAIL ❎"); 
		        }
				
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking The TEST CONFIGRATION parameter BUTTON");
	            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION parameter BUTTON'");
	            testCase.log(Status.FAIL, "TEST FAIL ❎");
	        }
	        catch (ElementClickInterceptedException e) {
	        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter BUTTON");
	            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION parameter BUTTON'");
	            testCase.log(Status.FAIL, "TEST FAIL ❎");
	        }
	        catch (Exception e) {
	        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter BUTTON");
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
	public void parametertabparametertypeSearchpopuptextboxUI() {
		TestParameterPage tp=new TestParameterPage();
		PageFactory.initElements(driver, tp);
//      GET PROPERTIES OF ONE ROLE ALLOCTION POPUP SCREEN DROPDOWN BY DROPDOWN PROPERTIES COMMON METHOD
      ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0078-02", TestParameterPage.parametertypesearchtextbox,
              "Checking parameter TABLE parameter search POPUP TEXTBOX UI Properties :","1");
	}
	




}
