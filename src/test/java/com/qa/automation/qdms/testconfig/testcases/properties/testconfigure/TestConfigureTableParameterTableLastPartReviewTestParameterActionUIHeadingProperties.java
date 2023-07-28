/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table Last Part- Review Test Parameter- "Action" UI Heading Properties
***********************************************************************************
*
* Author           :  THAKSHILA
* Date Written     :  10/07/2023 
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0536         10/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableLastPartReviewTestParameterActionUIHeadingProperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterReviewTestParameterProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0536");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING Heading PROPERTIES
			scrollDownUntilElementFound();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void scrollDownUntilElementFound() throws InterruptedException, IOException {
		// Scroll down the page using Actions class
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

		// check properties
		commonMethodForHeadingProperties();

	}

	public static void commonMethodForHeadingProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0536-02", TestConfigPage.reviewTestParaMeterACtionheading,
				"Test Configure Table - Parameter Table Last Part- Review Test Parameter- Action UI Heading Properties");

	}
}
