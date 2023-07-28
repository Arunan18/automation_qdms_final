/**********************************************************************************
* Description
*------------
Test Configure Table - Parameter Tab-  "Next"  Button Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 13/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0570          13/07/2023     THAKSHILA    Original Version
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

public class TestConfigureTableParameterTabNextButtonProperties extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void testParaMeterTableProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0570");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING PROPERTIES
			excelMethodCheckBox();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void excelMethodCheckBox() throws InterruptedException, IOException {

		// Scroll down the page using Actions class
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// Check properties
		commonMethodButtonProperties();

	}

	public static void commonMethodButtonProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0570-02", TestConfigPage.reviewTestParaMeterNextButton,
				"Test Configure Table - Parameter Tab- Next  Button Properties");

	}
}
