/**********************************************************************************
* Description
*------------
* Test Parameter Table Parameter Data Type Search Icon Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 04/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0082          05/07/2023    Shobika      Original Version
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

public class TestParameterTableParameterDataTypeSearchiconProperties extends DriverIntialization {
	static TestParameterPage tpmsearchicon = new TestParameterPage();

	@Test
	public void TestParameterTableParameterDataTypeSearchiconPropertie() throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Parameter Table Parameter Data Type Search Icon Properties
		Parameterdatasearchicon();
		// logout test
		Logout.LogoutFunction();

	}

	public void Parameterdatasearchicon() {
		PageFactory.initElements(driver, tpmsearchicon);

		try {
			TestConfigPage.paraMeterbutton.click();
			Thread.sleep(2000);

			pmDatasearchicon();

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

		}

	}

	public static void pmDatasearchicon() {
		PageFactory.initElements(driver, tpmsearchicon);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Parameter",
				"TC-PAR-0082-02", TestParameterPage.tpmsearchicon,
				"Test Parameter Table Parameter Data Type Search Icon Properties");
	}
}
