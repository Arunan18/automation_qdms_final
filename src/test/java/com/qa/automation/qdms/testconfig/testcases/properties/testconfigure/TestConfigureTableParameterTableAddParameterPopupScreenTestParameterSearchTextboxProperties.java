/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Test Parameter"  Search Text box Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0480          05/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableAddParameterPopupScreenTestParameterSearchTextboxProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterAddGroupPopupScreenProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0479");
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
			wait.until(ExpectedConditions
					.visibilityOf(TestConfigPage.paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchICon));
		} catch (TimeoutException e) {

			throw new RuntimeException("Element not found");
		}

		try {
			TestConfigPage.paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchICon.click();
			;
			// If clicks
			popUpScreenTextBoxProperties();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the Search Icon");
			testCase.log(Status.INFO, "Unable to Locate the Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Search Icon");
			testCase.log(Status.INFO, "Unable to Click on Search Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest(" Check Search Icon Pop-Up");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void popUpScreenTextBoxProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		ProCommonMethods.textBoxProperties("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0480-02",
				TestConfigPage.paraMeterAddParaMeterAddGroupPopUpScreenTestParameterSearchIConTextBox,
				"Test Configure Table - Parameter Table-Add Parameter Pop up Screen-Test Parameter Search Text box Properties");

	}
}
