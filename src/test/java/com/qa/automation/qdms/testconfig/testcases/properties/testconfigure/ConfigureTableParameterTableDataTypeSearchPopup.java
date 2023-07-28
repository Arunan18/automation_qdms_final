/**********************************************************************************
* Description
*------------
*Test Configure Table - Parameter  Table - "Data Type"  Search Pop up  Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0449           13/07/2023    Shobika      Original Version
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


	public class ConfigureTableParameterTableDataTypeSearchPopup extends DriverIntialization {
		static TestConfigPage pmdatatypepopup = new TestConfigPage();

		@Test
		public void ConfigureTableParameterTableDataTypeSearchpopup() throws InterruptedException, IOException {
			// Navigation
			TestConfiRev_MaterialSubHeadingProperties.navicateAndProperties("Test_Configure", "TC-TCN-0449-01", 1);
			// Test Configure Table Parameter search Pop-up screen
			pmdataTypePopUp();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		public void pmdataTypePopUp() {
			PageFactory.initElements(driver, pmdatatypepopup);

			try {
				TestConfigPage.datatypesearchicon.click();
				Thread.sleep(2000);
				pmdatatypePopUp();

				
			} catch (NoSuchElementException e) {
				testCase = extent.createTest("Checking Parameter Data type Icon");
				testCase.log(Status.INFO, "Unable to Locate the element 'Checking Parameter search Icon'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (ElementClickInterceptedException e) {
				testCase = extent.createTest("Checking Parameter Data type Icon");
				testCase.log(Status.INFO, "Unable to Click on the element 'Checking Parameter search Icon'");
				testCase.log(Status.FAIL, "TEST FAIL ");
			} catch (Exception e) {
				testCase = extent.createTest("Checking The Parameter Data type Icon");
				testCase.log(Status.FAIL, "TEST FAIL ");
				System.out.println(e.toString());
			}
			
		
		}

		public void pmdatatypePopUp() {
			PageFactory.initElements(driver, pmdatatypepopup);

			// Test Configure Table Parameter Data Type Pop-up screen
			PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0449-02",
					TestConfigPage.pmdatatypepopup, "Test Configure Table Parameter Data Type Pop-up screen ");
		}
	}


