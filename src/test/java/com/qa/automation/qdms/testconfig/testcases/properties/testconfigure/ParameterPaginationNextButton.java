/************************************************************************************
* Description
*------------
* Test Configure Table - Parameter  Table- Pagination next button Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0456         26/06/2023      RAHUL.S    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ParameterPaginationNextButton extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();

	@Test
	public static void paraMeterPaginationNextButtonProperties() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0456");

		// CLICK THE TEST PARAMETER
		TestConfigMethods.clickButton(2);

		// CHECKING DATA TYPE DROPDOWN PROPERTIES
		if (NavigateManageTestFromLogin.clicked) {
			paraMeterPaginationNextButton();
		}

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void paraMeterPaginationNextButton() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(TestConfigPage.paginationNextButtonParaMeter));
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0456-02", TestConfigPage.paginationNextButtonParaMeter,
				"PARAMETER PAGINATION NEXT BUTTON PROPERTIES");
	}
}
