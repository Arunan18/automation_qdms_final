/**********************************************************************************
* Description
*------------
* Test Parameter Table "Delete" icon UI Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 14/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0089         14/07/2023     Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testparameter;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;


	public class TestParameterTableDeleteiconUIProperties extends DriverIntialization {


		@Test
		public static void TestParameterTableDeleteiconUIPropertie() throws InterruptedException, IOException {

			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test_Parameter", "TC-PAR-0089-01");
			//icon properties 
			deleteiconIcon();
			// Logout
			Logout.LogoutFunction();

		}
		public  static void deleteiconIcon() {
			
			try {
				TestConfigPage.paraMeterbutton.click();
				Thread.sleep(2000);
				pmedeleteiconIcon (TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
		
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
				}

		public static void pmedeleteiconIcon(String data) {
			// icon Properties
			PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Parameter",
					"TC-PAR-0089-02",
					driver.findElement(By.xpath("//td[text()='"+ data +"']//following-sibling::td/span/a[2]")),
					"Parameter Table delete icon UI Properties");
		}

}
	