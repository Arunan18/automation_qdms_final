/**********************************************************************************
* Description
*------------
*Test Parameter Table  Reset All Button Properties

***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-PAR-0115           10/07/2023    Shobika      Original Version
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
import com.qa.automation.qdms.testconfig.pages.TestParameterPage;

public class TestParameterTableResetAllButtonProperties extends DriverIntialization {
	static TestParameterPage resetallbtn = new TestParameterPage();

	@Test
	public void TestParameterTableAddParameterButtonPopupScreenClosebuttonPropertie()
			throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Parameter Table Reset All Button Properties
		resetallbtn();
		// logout test 
		Logout.LogoutFunction();
	}

	public void resetallbtn() {
		PageFactory.initElements(driver, resetallbtn);
		try {
			TestParameterPage.testparameterbtn.click();
			Thread.sleep(2000);
			resetallBtn();

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

	public static void resetallBtn() {
		PageFactory.initElements(driver, resetallbtn);
		// Test Parameter Table Reset All Button Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Parameter",
				"TC-PAR-0115-02", TestParameterPage.resetallbutton,
				"Test Parameter Table  Reset All Button Properties");
	}
}
