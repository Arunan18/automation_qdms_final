/**********************************************************************************
* Description
*------------
Test Configure - Configure Test Table-  Top Bar Add Key Test  icon 5  Properties
***********************************************************************************
*
* Author           : THAKSHILA
* Date Written     : 14/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
TC-TCN-0710          14/07/2023     THAKSHILA    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigureConfigureTestTableTopBarAddKeyTesticon5Properties extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void testParaMeterTableProps() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0710");
		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CHECKING PROPERTIES
			commonMethodIconProperties();

		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void commonMethodIconProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0710-02", TestConfigPage.reviewConfigureAddKeyHeading,
				"Test Configure - Configure Test Table-  Top Bar Add Key Test  icon 5  Properties");

	}
}
