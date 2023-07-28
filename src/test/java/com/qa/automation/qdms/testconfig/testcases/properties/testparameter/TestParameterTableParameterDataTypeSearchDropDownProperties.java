/**********************************************************************************
* Description
*------------
* Test Parameter Table Parameter Data Type Search DropDown Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 04/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0084          05/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class TestParameterTableParameterDataTypeSearchDropDownProperties extends DriverIntialization {
	static TestParameterPage pmDatasearchdropdown = new TestParameterPage();

	@Test
	public void TestParameterTableParameterDataTypeSearchDropDownPropertie() throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
        // Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Parameter Data Type search drop down Properties
		ParameterdatasearchDropdown();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();

	}

	public void ParameterdatasearchDropdown() {
		PageFactory.initElements(driver, pmDatasearchdropdown);
		try {
			TestConfigPage.paraMeterbutton.click();
			Thread.sleep(2000);
 
			try {
				TestParameterPage.tpmsearchicon.click();
				Thread.sleep(2000);
				pmDatasearchdropdown();

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
			testCase = extent.createTest("Checking Test Parameter Search icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Test Parameter Search icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking The Test Parameter Search icon");
			testCase.log(Status.INFO, "Unable to Click on the element 'Test Parameter Search icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");
		} catch (Exception e) {
			testCase = extent.createTest("Test Parameter Search icon");
			testCase.log(Status.FAIL, "TEST FAIL ");

		}

	}

	public static void pmDatasearchdropdown() {
		PageFactory.initElements(driver, pmDatasearchdropdown);
		
		// Parameter Data Type search drop down Properties
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Parameter", "TC-PAR-0084-02",
				TestParameterPage.pmDatasearchdropdown,
				"Test Parameter Table Parameter Data Type search dropdown Properties","1");
	}
}
