/**********************************************************************************
* Description
*------------
*
*Test "Configure Test" Table Heading UI Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0413           10/07/2023    Shobika      Original Version
*
************************************************************************************/
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


	public class TestConfigureTestTableHeadingUIProperties extends DriverIntialization {
		static TestConfigPage TestConfigureTestTableHeading = new TestConfigPage();

		@Test
		public void TestConfigureTestTableHeadingUIPropertie()
				throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Configure Test Table Heading UI Properties
			testConfigure();
			// Refresh 
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		
			public void testConfigure() {
				PageFactory.initElements(driver, TestConfigureTestTableHeading);
				try {
					TestConfigPage.testconfigureButton.click();
					Thread.sleep(2000);
					testconfigure();

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
		public static void testconfigure() {
			PageFactory.initElements(driver, TestConfigureTestTableHeading); 

			// Test Configure Test Table Heading UI Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx","Test_Configure",
					"TC-TCN-0413-02", TestConfigPage.TestConfigureTestTableHeading,
					"Test Configure Test Table Heading UI Properties");
		}
	}



