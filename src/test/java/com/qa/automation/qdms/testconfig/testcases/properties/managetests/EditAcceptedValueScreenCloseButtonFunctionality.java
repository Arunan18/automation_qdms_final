/****************************************************************************************
* Description
*------------
*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen  - Edit Accepted Value Screen - "Close" Button Functionality
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
*MTC-MT-230          17/07/2023    THAKSHILA    Modified Version    */

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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

public class EditAcceptedValueScreenCloseButtonFunctionality extends DriverIntialization {
	static ManageTestsPage testConfig = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The
		// Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-230");

		// Calling The Method To Check The Edit Icon Pop-Up: 'Relevant to Result' Label
		// Properties
		methodLocateAndClick(NavigateManageTestFromLogin.excelDataValue.get(1));

		// Refresh
		driver.navigate().refresh();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodLocateAndClick(String searchCode) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		try {

			// Locate the "Edit" Icon
			driver.findElement(By.xpath("//td[text()='" + searchCode + "']/following-sibling::td[4]/span/a/span"))
					.click();
			testCase = extent.createTest("Locate the element 'Edit' Icon");
			testCase.log(Status.INFO, "Located the element 'Edit' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");

			// Get Edit Icon Pop-Up: Properties
			buttonFunctionality();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Locate the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate Click on the element, 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.INFO, "Unable to Locate and Click on the element 'Edit' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void buttonFunctionality() {
		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 4);

		// Functionality test code
		testCase = extent.createTest("EDIT ICON POP UP CLOSE BUTTON FUNCTIONALITY");

		wait.until(ExpectedConditions.elementToBeClickable(ManageTestsPage.acceptValuePopEditCloseButton));

		try {
			if (ManageTestsPage.acceptValuePopEditCloseButton.isDisplayed()) {

				testCase = extent.createTest("STEP-1-CLOSE BUTTON IS DISPLAYED");
				testCase.log(Status.PASS, "TEST PASS ☑");

				if (ManageTestsPage.acceptValuePopEditCloseButton.isEnabled()) {

					testCase = extent.createTest("STEP-2-CLOSE BUTTON IS DISPLAYED");
					testCase.log(Status.PASS, "TEST PASS ☑");

					try {

						ManageTestsPage.acceptValuePopEditCloseButton.click();

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
