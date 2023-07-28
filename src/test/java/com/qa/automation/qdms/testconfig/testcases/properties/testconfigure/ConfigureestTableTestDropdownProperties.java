/**********************************************************************************
* Description
*------------
*
*Test Configure - Configure Test Table-  "Test"  Drop-Down  Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 11/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0415           11/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;


	public class ConfigureestTableTestDropdownProperties extends DriverIntialization {
		static TestConfigPage testdropdown = new TestConfigPage();

		@Test
		public void ConfigureestTableTestDropdownPropertie()throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Configure Configure Test Table Test Drop-down Properties
			testdropdown();
			// Refresh 
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		
			public void testdropdown() {
				PageFactory.initElements(driver, testdropdown);
				try {
					TestConfigPage.testconfigureButton.click();
					Thread.sleep(2000);
					testDropdown();

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
		public static void testDropdown() {
			PageFactory.initElements(driver, testdropdown); 
			
 // Test Configure Configure Test Table Test Drop-down  Properties
			ProCommonMethods.dropDown("Test Configuration Properties.xlsx","Test_Configure",
					"TC-TCN-0415-02", TestConfigPage.testDropdown,
					"Test Configure Configure Test Table Test Drop-down  Properties", "1");
		}
	}







