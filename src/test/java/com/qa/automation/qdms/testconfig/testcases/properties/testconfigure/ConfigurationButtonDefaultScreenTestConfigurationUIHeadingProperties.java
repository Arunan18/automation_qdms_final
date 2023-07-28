/**********************************************************************************
* Description
*------------
*
*Test Configuration Button Default Screen Test Configuration UI Heading Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 15/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TC-0003	        15/07/2023    Shobika      Original Version
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


	public class ConfigurationButtonDefaultScreenTestConfigurationUIHeadingProperties extends DriverIntialization {
		static TestConfigPage testConfiggurationheading = new TestConfigPage();

		@Test
		public void ConfigurationButtonDefaultScreenTestConfigurationUIHeadingPropertie()throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Configuration Button Default Screen Test Configuration UI Heading Properties
			tcHeading();
			// Refresh 
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		
			public void tcHeading() {
				PageFactory.initElements(driver, testConfiggurationheading);
				try {
					TestConfigPage.testconfigureButton.click();
					Thread.sleep(2000);
					tcheading();

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
		public static void tcheading() throws InterruptedException {
			PageFactory.initElements(driver, testConfiggurationheading); 
			Thread.sleep(2000);
  // Test Configuration Button Default Screen Test Configuration UI Heading Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx","Test Configuration",
					"TC-TC-0003-02", TestConfigPage.tcheading, "Test Configuration Button Default Screen Test Configuration UI Heading Properties");
		}
	}






