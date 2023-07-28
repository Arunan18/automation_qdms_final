/**********************************************************************************
* Description
*------------
Test Configure Configure Active  UI Heading  Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 12/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0432           12/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

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


	public class ConfigureTestTableActiveUIHeadingProperties extends DriverIntialization {
		static TestConfigPage activeheading = new TestConfigPage();

		@Test
		public void ConfigureTestTableActiveUIHeadingPropertie() throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Configure Configure Active Heading Properties
			activeHeading();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		public void activeHeading() {
			PageFactory.initElements(driver, activeheading);
			try {
				TestConfigPage.testconfigureButton.click();
				Thread.sleep(2000);
				aCtivEheading();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Test Configu re  Button");
				testCase.log(Status.INFO, "Unable to Locate the element 'est Configure Button'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking The Test  Configure  Button");
				testCase.log(Status.INFO, "Unable to Click on the element 'Test Configure  Button'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (Exception e) {
				testCase = extent.createTest("Checking The Test Configure  Button");
				testCase.log(Status.FAIL, "TEST FAIL ");
				System.out.println(e.toString());
			}
		}

		public  void aCtivEheading() {
			PageFactory.initElements(driver, activeheading);

			// Test Configure Configure Active Heading Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
					"TC-TCN-0432-02", TestConfigPage.activeheading,
					"Test Configure Configure Report Active Heading  Properties");
		}
	}






