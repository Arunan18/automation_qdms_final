/**********************************************************************************
* Description
*------------
* Test Parameter Table "Add Parameter"  Pop up Screen Add Parameter UI Heading Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0092          05/07/2023    Shobika      Original Version
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

	public class TestParameterTableAddParameterPopupScreenAddParameterUIHeadinProperties extends DriverIntialization {
		static TestParameterPage AddParameterHeading = new TestParameterPage();

		@Test
		public void TestParameterTableAddParameterPopupScreenAddParameterUIHeadinPropertie() throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Add Parameter Pop up Screen Add Parameter UI Heading Properties
			AddParameterheading();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();

		}

		public void AddParameterheading() {
			PageFactory.initElements(driver, AddParameterHeading);
			try {
				TestConfigPage.paraMeterbutton.click();
				Thread.sleep(2000);

				try {
					TestParameterPage.addparameterbtn.click();
					Thread.sleep(2000);
					AddParameterHeading();

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

		public static void AddParameterHeading() {
			PageFactory.initElements(driver, AddParameterHeading);

			// Add Parameter Pop up Screen Add Parameter UI Heading Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0092-02",
					TestParameterPage.addparameteheading,
					"Test Parameter Table Add Parameter Pop up Screen Add Parameter UI Heading Properties");
		}
	}


