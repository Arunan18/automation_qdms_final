/****************************************************************************************
* Description
*------------
*Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen  - Edit Accepted Value Screen - "Update" Button Properties
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
*MTC-MT-231        17/07/2023    THAKSHILA    Modified Version    */

package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class PopScreenEditAcceptedValueScreenUpdateButtonProperties
		extends DriverIntialization {
	static ManageTestsPage manageTest = new ManageTestsPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The
		// Manage Test Page and Click on Accepted Value Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 8, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-231");

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
			buttonProperties();

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

	public static void buttonProperties() {
		PageFactory.initElements(driver, manageTest);
		
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-231-02",
				ManageTestsPage.acceptValuePopEditUpdateButton,
				"Test Configure - Manage Test Configuration Tab- Accepted Value Pop up Screen  - Edit Accepted Value Screen - Update Button Properties");

	}
}
