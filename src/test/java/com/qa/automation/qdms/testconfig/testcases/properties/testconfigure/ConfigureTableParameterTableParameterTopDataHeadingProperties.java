/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter  Table - "Parameter" Top Data Heading Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0441           13/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;


	public class ConfigureTableParameterTableParameterTopDataHeadingProperties extends DriverIntialization {
		static TestConfigPage parameterdatahading = new TestConfigPage();

		@Test
		public void ConfigureTableParameterTableParameterTopDataHeadingPropertie() throws InterruptedException, IOException {
			// Navigation
			TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0441-01", 1);
			// Test Configure Table Parameter TopBar data Heading UI Properties
			tbParameterDataHading();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		public void tbParameterDataHading() {
			PageFactory.initElements(driver, parameterdatahading);

			try {
				TestConfigPage.topbartestparametericon.click();
				Thread.sleep(2000);
				tbParameterdataHading();

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking top bar test parameter");
				testCase.log(Status.INFO, "Unable to Locate the element 'Checking top bar test parameter'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking Checking top bar test parameter");
				testCase.log(Status.INFO, "Unable to Click on the element 'Checking top bar test parameter'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (Exception e) {
				testCase = extent.createTest("Checking The Checking top bar test parameter");
				testCase.log(Status.FAIL, "TEST FAIL ");
				System.out.println(e.toString());
			}
			  
		}

		public void tbParameterdataHading() {
			PageFactory.initElements(driver, parameterdatahading);

			// Test Configure Table Parameter TopBar data Heading UI Properties
			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
					"TC-TCN-0441-02", TestConfigPage.tbdataheading,
					"Test Configure Table Parameter TopBar data Heading UI Properties");
		}
	}



