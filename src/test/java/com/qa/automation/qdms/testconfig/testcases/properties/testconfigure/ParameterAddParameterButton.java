/************************************************************************************
* Description
*------------
* Test Configure Table - Parameter Table-"Add Parameter" Button Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0460         26/06/2023      RAHUL.S    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ParameterAddParameterButton extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test = null;

	@Test
	public static void paraMeterAddButton() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0460");

		// CLICK THE TEST PARAMETER
		TestConfigMethods.clickButton(2);

		// CHECKING DATA TYPE RESET BUTTON PROPERTIES
		if (NavigateManageTestFromLogin.clicked) {
			addParaMeterButton();
		}

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void addParaMeterButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(TestConfigPage.addParameterBTN));
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0460-02", TestConfigPage.addParameterBTN, "PARAMETER ADD PARAMETER BUTTON");

	}
}
