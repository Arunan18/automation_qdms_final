/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table-Add Parameter Pop up Screen- Enter GroupKey- "+" icon  Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0487         05/07/2023     THAKSHILA    Original Version
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
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableAddParameterPopupScreenEnterGroupKeyPlusiconProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterAddGroupPopupScreenProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0487");
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
			groupKeyTextplusIconProperties();

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

	public static void groupKeyTextplusIconProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0487-02", TestConfigPage.paraMeterAddParaMeterAddGroupEnterGroupKeyPlusIcon,
				"Enter GroupKey + icon Properties");

	}
}
