/**********************************************************************************
* Description
*------------
* Test Parameter Table Add Parameter Button UI Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0090          05/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;


	public class TestParameterTableAddParameterButtonUIProperties extends DriverIntialization {
		static TestParameterPage AddParameterButton = new TestParameterPage();

		@Test
		public void TestParameterTableAddParameterButtonUIPropertie() throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Parameter Table Add Parameter Button UI Properties
			AddParameterButton();
			// logout test
			Logout.LogoutFunction();

		}

		public void AddParameterButton() {
			PageFactory.initElements(driver, AddParameterButton);
			try {
				TestConfigPage.paraMeterbutton.click();
				Thread.sleep(2000);
				AddparameterButton();

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

			}
		}

		public static void AddparameterButton() {
			PageFactory.initElements(driver, AddParameterButton);

			// Test Parameter Table Add Parameter Button UI Properties
			PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter",
					"TC-PAR-0090-02", TestParameterPage.addparameterbtn,
					"Test Parameter Table Add Parameter Button UI Properties");
		}
	}


