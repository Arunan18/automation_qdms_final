/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table-Add Parameter Pop up Screen- Enter GroupKey- "Remove" button functionality
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0489         05/07/2023     THAKSHILA    Original Version
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

public class TestConfigureTableParameterTableAddParameterPopupScreenEnterGroupKeyRemovebuttonfunctionality
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterAddGroupPopupScreenProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0489");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING BUTTON PROPERTIES
			addParaMeterAddGroupButton();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void addParaMeterAddGroupButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		try {
			TestConfigPage.paraMeterAddParaMeterAddGroupButton.click();
			// If clicks
			addParaMeterAddGroupPopUpParameterSearchIcon();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the 'Add Group' Button");
			testCase.log(Status.INFO, "Unable to Locate the 'Add Group'' Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the 'Add Group' Button");
			testCase.log(Status.INFO, "Unable to Click on 'Add Group' Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check 'Add Group' Button Pop-Up");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void addParaMeterAddGroupPopUpParameterSearchIcon() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		try {

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(
					ExpectedConditions.visibilityOf(TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyPlusIcon));
		} catch (TimeoutException e) {

			throw new RuntimeException("Element not found");
		}

		try {
			TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyPlusIcon.click();

			// If clicks
			popUpScreenRemoveButtonFunctionality();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the Plus Icon");
			testCase.log(Status.INFO, "Unable to Locate the Plus Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Plus Icon");
			testCase.log(Status.INFO, "Unable to Click on Plus Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check Plus Icon ");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void popUpScreenRemoveButtonFunctionality() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		// Functionality test code
		testCase = extent.createTest("REMOVE BUTTON FUNCTIONALITY");
		try {
			if (TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyRemoveButton.isDisplayed()) {

				testCase = extent.createTest("STEP-1-REMOVE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyRemoveButton.isEnabled()) {

					testCase = extent.createTest("STEP-2-REMOVE BUTTON IS ENABLED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyRemoveButton.click();

						testCase = extent.createTest("STEP-3-REMOVE BUTTON IS CLICKED");
						testCase.log(Status.PASS, "TEST PASS ☑");

					} catch (NoSuchElementException e2) {

						testCase = extent.createTest("LOCATE THE REMOVE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO LOCATE THE REMOVE BUTTON");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (ElementClickInterceptedException e2) {

						testCase = extent.createTest("CLICKED ON THE REMOVE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO CLICK ON REMOVE BUTTON ");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (Exception e2) {

						testCase = extent.createTest("CHECK REMOVE BUTTON FUNCTIONALITY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} else {
					testCase = extent.createTest("STEP-2-REMOVE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-1-REMOVE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "TEST FAIL ❎");

		}

	}

}
