/**********************************************************************************
* Description
*------------
Test Configure Configure Active  Check Box Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 12/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0433           12/07/2023    Shobika      Original Version
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

public class ConfigureTestTableActiveCheckboxProperties extends DriverIntialization {
	static TestConfigPage activecheckbox = new TestConfigPage();

	@Test
	public void ConfigureTestTableActiveCheckboxPropertie() throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Configure Configure Active CheckBox Properties
		activeCheckbox();
		// Refresh
		driver.navigate().refresh();
		// logout test
		Logout.LogoutFunction();
	}

	public void activeCheckbox() {
		PageFactory.initElements(driver, activecheckbox);
		try {
			TestConfigPage.testconfigureButton.click();
			Thread.sleep(2000);
			activeCheckBox();

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

	public static void activeCheckBox() {
		PageFactory.initElements(driver, activecheckbox);

		// Test Configure Configure Active CheckBox Properties
		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0433-02",
				TestConfigPage.activecheckbox, "Test Configur Active CheckBox Properties");
	}
}
