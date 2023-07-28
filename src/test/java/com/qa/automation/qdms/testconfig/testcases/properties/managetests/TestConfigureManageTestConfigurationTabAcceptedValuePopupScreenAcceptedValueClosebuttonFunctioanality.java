/****************************************************************************************
* Description
*------------
*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen - Accepted Value - "Close" button Functionality
***************************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 17/07/2023
* 
*
* 
* Test Case Number       Date         Name        Comments
* ================       ====         =====        ========
*  
*MTC-MT-240         17/07/2023    THAKSHILA    Modified Version    */

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureManageTestConfigurationTabAcceptedValuePopupScreenAcceptedValueClosebuttonFunctioanality
		extends DriverIntialization {
	static ManageTestsPage manageTest = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The
		// Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-240");

		// Get properties
		buttonProperties();
		// Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void buttonProperties() {
		PageFactory.initElements(driver, manageTest);

		WebDriverWait wait = new WebDriverWait(driver, 4);

		// Functionality test code
		testCase = extent.createTest("EDIT ICON POP UP CLOSE BUTTON FUNCTIONALITY");

		wait.until(ExpectedConditions.elementToBeClickable(ManageTestsPage.acceptValuePopDeletePopUpClsButton));

		try {
			if (ManageTestsPage.acceptValuePopDeletePopUpClsButton.isDisplayed()) {

				testCase = extent.createTest("STEP-1-CLOSE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (ManageTestsPage.acceptValuePopDeletePopUpClsButton.isEnabled()) {

					testCase = extent.createTest("STEP-2-CLOSE BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						ManageTestsPage.acceptValuePopDeletePopUpClsButton.click();

						testCase = extent.createTest("STEP-3-CLOSE BUTTON IS CLICKED");
						testCase.log(Status.PASS, "TEST PASS ☑");

					} catch (NoSuchElementException e2) {

						testCase = extent.createTest("LOCATE THE CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO LOCATE THE CANCEL BUTTON");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (ElementClickInterceptedException e2) {

						testCase = extent.createTest("CLICKED ON THE CLOSE BUTTON");
						testCase.log(Status.INFO, "UNABLE TO CLICK ON CANCEL BUTTON ");
						testCase.log(Status.FAIL, "TEST FAIL ❎");

					} catch (Exception e2) {

						testCase = extent.createTest("CHECK CLOSE BUTTON FUNCTIONALITY");
						testCase.log(Status.FAIL, "TEST FAIL ❎");
					}

				} else {
					testCase = extent.createTest("STEP-2-CLOSE BUTTON IS NOT ENABLED");
					testCase.log(Status.FAIL, "TEST FAIL ❎");
				}
			} else {
				testCase = extent.createTest("STEP-1-CLOSE BUTTON IS NOT DISPLAYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}
		} catch (Exception e) {
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}
}
