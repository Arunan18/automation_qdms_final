/**********************************************************************************
* Description
*------------
*Test Parameter Table  -Add Parameter Button-Pop up Screen Cancel Button Functionality
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0102          06/07/2023    Shobika      Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testparameter;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class TestParameterTableAddParameterButtonPopupScreenCancelbuttonFunctionality extends DriverIntialization {
	static TestParameterPage parameterclosebutton = new TestParameterPage();

	@Test
	public void TestParameterTableAddParameterButtonPopupScreenClosebuttonPropertie()
			throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Parameter Table Add Parameter Button-Pop up Screen close button
		// Properties
		parameterclosebutton();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void parameterclosebutton() {
		PageFactory.initElements(driver, parameterclosebutton);
		try {
			TestConfigPage.paraMeterbutton.click();
			Thread.sleep(2000);

			try {
				TestParameterPage.addparameterbtn.click();
				Thread.sleep(2000);
				addtestcancelbtnfun();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Test Parameter Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'Test Parameter Button'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking The Test Parameter Button");
				testCase.log(Status.INFO, "Unable to Click on the element 'Test Parameter Button'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (Exception e) {
				testCase = extent.createTest("Checking The Test Parameter Button");
				testCase.log(Status.FAIL, "TEST FAIL ");
				System.out.println(e.toString());

			}

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Parameter Table Add Parameter Button");
			testCase.log(Status.INFO, "Unable to Locate the element 'Parameter Table Add Parameter Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Parameter Table Add Parameter Button");
			testCase.log(Status.INFO, "Unable to Click on the element 'Parameter Table Add Parameter Button'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Parameter Table Add Parameter Button");
			testCase.log(Status.FAIL, "TEST FAIL ");
		}
		
		} 


	public void addtestcancelbtnfun() {
			PageFactory.initElements(driver, parameterclosebutton);
			try {
				if (TestParameterPage.parameterancelbutton.isDisplayed()) {
					testCase = extent.createTest("Add condition Action Edit Popup Screen Cancel Button is Displayed");
					testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Cancel Button is Displayed ");
					testCase.log(Status.PASS, "TEST PASS");

				if (TestParameterPage.parameterancelbutton.isEnabled()) {
					testCase = extent.createTest("Add condition Action Edit Popup Screen Cancel Button is Enabled");
					testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Cancel Button is Enabled");
					testCase.log(Status.PASS, "TEST PASS");
				
					} else {
				  testCase = extent.createTest("Add condition Action Edit Popup Screen Cancel Button is not Enabled");
				  testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Cancel Button is not Enabled");
				  testCase.log(Status.FAIL, "TEST FAIL");
					}
					 } else {
				testCase = extent.createTest("Add condition Action Edit Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Cancel Button is not Displayed");
				testCase.log(Status.FAIL, "TEST FAIL");
					}		
					} catch (NoSuchElementException e) {
				 testCase = extent.createTest("Checking The Add condition Action Edit Popup Screen Cancel Button");
				 testCase.log(Status.INFO, "Add condition Action Edit Popup Screen Cancel Button is not available");
				 testCase.log(Status.FAIL, "TEST FAIL");
 
				 } catch (Exception e) {
				testCase = extent.createTest("Checking The Add condition Action Edit Popup Screen Cancel Button");
				testCase.log(Status.INFO,"Unable to check the functionality of Add condition Action Edit Popup Screen Cancel Button");
				testCase.log(Status.FAIL, "TEST FAIL");
				
			
				 }
	
	}		 
			
}