/***************************************************************************************************
* DESCRIPTION
*---------------------------------------------------------------------------------------------------
* Test "Parameter" Table Heading UI Properties
****************************************************************************************************
*
* @author      : kajan
* 
* ===================================================================================================
*     Test Case Number    ||      Date      ||      Intis     ||   Comments
* ===================================================================================================
*       TC-PAR-0068             26/06/2023            kajan         Original Version
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
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class parameterMainHeadingUI extends DriverIntialization{

	@Test
	public void testParametersideBarProperties() throws InterruptedException, IOException {
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
				testparametertabTableMainHeading();
				
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
	public void testparametertabTableMainHeading() {
		TestParameterPage tcp=new TestParameterPage();
		PageFactory.initElements(driver, tcp);
//      GET PROPERTIES OF STATUS HEADING BY TEXT PROPERTIES COMMON METHOD
      PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter", "TC-TC-0068-02", TestParameterPage.testparameterheading,
              "Checking TEST PARAMETER TABLE Heading UI Properties :");
		
	}

}
