/**********************************************************************************
* Description
*------------
*
*Test Configure  Configure Test Table  "Main Category" Drop-Down Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 11/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0421           11/07/2023    Shobika      Original Version
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


	public class TestTableMainCategoryDropdownProperties extends DriverIntialization {
		static TestConfigPage maincategorydropdown = new TestConfigPage();

		@Test
		public void TestTableMainCategoryDropdownPropertie() throws InterruptedException, IOException {
			// login test
			LoginTest.Login();
			// Navigation to TestConfiguration
			TestConfigNavigation.TestConfigurationCard();
			// Test Configure Configure Test Table Main category Drop-down Properties
			maincategorydropdown();
			// Refresh
			driver.navigate().refresh();
			// logout test
			Logout.LogoutFunction();
		}

		public void maincategorydropdown() {
			PageFactory.initElements(driver, maincategorydropdown);
			try {
				TestConfigPage.testconfigureButton.click();
				Thread.sleep(2000);
				maincategoryDropdown();

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

		public static void maincategoryDropdown() {
			PageFactory.initElements(driver, maincategorydropdown);

			// Test Configure Configure Test Table Main category Drop-down Properties
			ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0421-02",
					TestConfigPage.maincategorydropdown, "Test Configure Configure Test Table Main Category Drop-down  Properties",
					"1");
		}
	}



