/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Material Test Table "Test" Search Text Box  Properties
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-TC-0047             22/06/2023            kajan         Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class testSearchpopupTextBoxUI extends DriverIntialization{



@Test
	public void testSearchpopupUIProperties() throws InterruptedException, IOException {
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
					TestConfigPage.SearchTestIcon.click();
					Thread.sleep(1000);
					testtabTestSearchpopuptextboxUI();
				}  catch (NoSuchElementException e) {
					testCase = extent.createTest("Checking The TEST CONFIGRATION TEST search icon");
		            testCase.log(Status.INFO, "Unable to Locate the element 'TEST CONFIGRATION TEST SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (ElementClickInterceptedException e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST SEARCH ICON");
		            testCase.log(Status.INFO, "Unable to Click on the element 'TEST CONFIGRATION TEST SEARCH ICON'");
		            testCase.log(Status.FAIL, "TEST FAIL ❎");
		        }
		        catch (Exception e) {
		        	testCase = extent.createTest("Checking The TEST CONFIGRATION TEST SEARCH ICON");
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
	public void testtabTestSearchpopuptextboxUI() {
		TestConfigPage tcp=new TestConfigPage();
		PageFactory.initElements(driver, tcp);
//      GET PROPERTIES OF STATUS POPUP TEXTBOX BY TEXTBOX PROPERTTIES COMMON METHOD
      ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test", "TC-TC-0047-01", TestConfigPage.SearchPlaceHolder,
              "Checking TEST TABLE TEST search POPUP TEXTBOX UI Properties :");
	}
	


	






	

}
