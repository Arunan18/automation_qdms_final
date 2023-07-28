/**********************************************************************************
* Description
*------------
* Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Cancel" Button  Functionality
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 4/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0470         4/07/2023      THAKSHILA   Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableAddParameterPopupScreenCancelButtonFunctionality
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterPopupCancelButton() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0470");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CLICKING ADD PARAMETER BUTTON
			TestConfigMethods.clickElement(TestConfigPage.addParameterBTN, "THE ADD PARAMETER BUTTON");

			// CHECKING CANCEL BUTTON
			addParaMeterScreenCancelButton();
		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void addParaMeterScreenCancelButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(TestConfigPage.addParaMeterScreenCancelButton));
		} catch (TimeoutException e) {

			throw new RuntimeException("Element not found");
		}

		// Functionality test code
		testCase = extent.createTest("ADD PARAMETER CANCEL BUTTON FUNCTIONALITY");
		try {
			if (TestConfigPage.addParaMeterScreenCancelButton.isDisplayed()) {

				testCase = extent.createTest("STEP-1-ADD PARAMETER CANCEL BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (TestConfigPage.addParaMeterScreenCancelButton.isEnabled()) {

					testCase = extent.createTest("STEP-2-ADD PARAMETER CANCEL BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						TestConfigPage.addParaMeterScreenCancelButton.click();

						testCase = extent.createTest("STEP-3-ADD PARAMETER CANCEL BUTTON IS CLICKED");
						testCase.log(Status.PASS, "TEST PASS ☑");

					} catch (NoSuchElementException e2) {

						testCase = extent.createTest("LOCATE THE ADD PARAMETER CANCEL BUTTON");
						testCase.log(Status.INFO, "UNABLE TO LOCATE THE CANCEL BUTTON");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (ElementClickInterceptedException e2) {

						testCase = extent.createTest("CLICKED ON THE ADD PARAMETER CANCEL BUTTON");
						testCase.log(Status.INFO, "UNABLE TO CLICK ON ADD PARAMETER CANCEL BUTTON ");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (Exception e2) {

						testCase = extent.createTest("CHECK ADD PARAMETER CANCEL BUTTON FUNCTIONALITY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} else {
					testCase = extent.createTest("STEP-2-ADD PARAMETER CANCEL BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-1-ADD PARAMETER CANCEL BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

}
