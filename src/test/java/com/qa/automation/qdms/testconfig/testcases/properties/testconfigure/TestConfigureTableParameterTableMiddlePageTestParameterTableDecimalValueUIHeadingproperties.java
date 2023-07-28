/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Table Middle Page- Test Parameter Table- "Decimal Value" UI Heading Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     :  07/07/2023 
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0517          07/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureTableParameterTableMiddlePageTestParameterTableDecimalValueUIHeadingproperties
		extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterTestParameterProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0517");
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
		PageFactory.initElements(driver, testConfig);

		// Find the target element you want to scroll to
		WebElement targetElement = TestConfigPage.scrollDown;

		// Create an Actions instance
		Actions actions = new Actions(driver);
		Thread.sleep(2000);
		// Perform a series of actions to scroll to the target element
		actions.moveToElement(targetElement).perform();

		// check properties
		commonMethodForHeadingProperties();

	}

	public static void commonMethodForHeadingProperties() throws InterruptedException, IOException {

		PageFactory.initElements(driver, testConfig);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0517-02", TestConfigPage.paraMeterAddParaMeterDecimalValueSubHead,
				"Decimal Value heading Properties");

	}
}
