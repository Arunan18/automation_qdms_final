/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Test Parameter Table "Parameter" Search Text Box  Properties
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-PAR-0072             26/06/2023            kajan         Original Version
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

public class parameterSearchTextboxUI extends DriverIntialization{

@Test
	public void parameterSearchpopupUIProperties() throws InterruptedException, IOException {
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
					TestParameterPage.parameterSearchicon.click();
					Thread.sleep(1000);
					parametertabparameterSearchpopuptextboxUI();
				}  catch (NoSuchElementException e) {
					testCase = extent.createTest("Checking The TEST CONFIGRATION parameter search icon");
		            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION parameter  SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (ElementClickInterceptedException e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter  SEARCH ICON");
		            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION parameter  SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (Exception e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION parameter SEARCH ICON");
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
	public void parametertabparameterSearchpopuptextboxUI() {
		TestParameterPage tp=new TestParameterPage();
		PageFactory.initElements(driver, tp);
//      GET PROPERTIES OF STATUS POPUP TEXTBOX BY TEXTBOX PROPERTTIES COMMON METHOD
      ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0072-02", TestParameterPage.parameterSearchtextbox,
              "Checking parameter TABLE parameter search POPUP TEXTBOX UI Properties :");
	}
	


}
