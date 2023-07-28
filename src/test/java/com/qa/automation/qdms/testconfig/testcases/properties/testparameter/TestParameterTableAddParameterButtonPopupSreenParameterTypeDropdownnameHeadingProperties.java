/**********************************************************************************
* Description
*------------
* Test Parameter Table Add Parameter Button-Pop up Screen Parameter Type Drop down name Heading Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0094          05/07/2023    Shobika      Original Version
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


	public class TestParameterTableAddParameterButtonPopupSreenParameterTypeDropdownnameHeadingProperties extends DriverIntialization {
		static TestParameterPage ParameterTypeDropdownnameHeading = new TestParameterPage();

		@Test
		public void TestParameterTableAddParameterButtonPopupSreenParameterTypeDropdownnameHeadingPropertie() throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Add Parameter Button-Pop up Screen Parameter Type Drop down name Heading Properties
			ParameterTypeDropdownnameHeading();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();

		}

		public void ParameterTypeDropdownnameHeading() {
			PageFactory.initElements(driver, ParameterTypeDropdownnameHeading);
			try {
				TestConfigPage.paraMeterbutton.click();
				Thread.sleep(2000);

				try {
					TestParameterPage.addparameterbtn.click();
					Thread.sleep(2000);
					ParameterTypeDropdownnameheading();

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

		public static void ParameterTypeDropdownnameheading() {
			PageFactory.initElements(driver, ParameterTypeDropdownnameHeading);

			// Add Parameter Button-Pop up Screen Parameter Type Drop down name Heading Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0093-02",
					TestParameterPage.parametrdatatype,
					"Test Parameter Table Add Parameter Button-Pop up Screen Parameter Type Drop down name Heading Properties");
		}
	}






