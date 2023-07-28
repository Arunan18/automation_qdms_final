/**********************************************************************************
* Description
*------------
* Test Configure Table - Parameter Table-Add Parameter Pop up Screen- "Parameter" Filed UI Heading  Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 27/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0463          27/06/2023      RAHUL.S    Original Version
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

public class AddParameterScreenParaMeterUI extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void addParaMeterPopupHeading() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0463");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CLICKING ADD PARAMETER BUTTON
			TestConfigMethods.clickElement(TestConfigPage.addParameterBTN, "THE ADD PARAMETER BUTTON");

			// CHECKING DATA TYPE RESET BUTTON PROPERTIES

			addParaMeterScreenParaMeterHeading();
		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void addParaMeterScreenParaMeterHeading() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(TestConfigPage.addParaMeterScreenParameterHeading));
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0463-02", TestConfigPage.addParaMeterScreenParameterHeading,
				"ADD PARAMETER POPUP PARAMETER HEADING");

	}
}
