/**********************************************************************************
* Description
*------------
*Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Close" Button Functionality
***********************************************************************************
*
* Author           :THAKSHILA
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0500       06/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableAddParameterPopuPScreenCloseButtonFunctionalty
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterPopupCloseButton() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0499");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CLICKING ADD GROUP BUTTON
			TestConfigMethods.clickElement(TestConfigPage.paraMeterAddParaMeterAddGroupButton, "THE ADD GROUP BUTTON");

			// CHECKING BUTTON PROPERTIES

			commonMethodForButtonProperties();
		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void commonMethodForButtonProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		// Functionality test code
		testCase = extent.createTest("ADD PARAMETER CLOSE BUTTON FUNCTIONALITY");
		try {
			if (TestConfigPage.paraMeterAddParaMeterAddGroupKeysCloseButton.isDisplayed()) {

				testCase = extent.createTest("STEP-1-ADD GROUP CLOSE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (TestConfigPage.paraMeterAddParaMeterAddGroupKeysCloseButton.isEnabled()) {

					testCase = extent.createTest("STEP-2-ADD GROUP CLOSE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						TestConfigPage.paraMeterAddParaMeterAddGroupKeysCloseButton.click();

						testCase = extent.createTest("STEP-3-ADD GROUP CLOSE BUTTON IS CLICKED");
						testCase.log(Status.PASS, "TEST PASS ☑");

					} catch (NoSuchElementException e2) {

						testCase = extent.createTest("LOCATE THE ADD GROUP CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO LOCATE THE CLOSE BUTTON");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (ElementClickInterceptedException e2) {

						testCase = extent.createTest("CLICKED ON THE ADD GROUP CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO CLICK ON ADD GROUP CLOSE BUTTON ");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (Exception e2) {

						testCase = extent.createTest("CHECK ADD GROUP CLOSE BUTTON FUNCTIONALITY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} else {
					testCase = extent.createTest("STEP-2-ADD GROUP CLOSE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-1-ADD GROUP CLOSE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

}
