/************************************************************************************
* Description
*------------
* Test Configure Table - Parameter  Table - "Data Type"  Search Drop Down  Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 23/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0450       23/06/2023      RAHUL.S    Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class ParameterTableDataTypeSearchDropDown extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test = null;

	@Test
	public static void dataTypeSearchDropDown() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0450");

		if (NavigateManageTestFromLogin.clicked) {
			// CLICK THE TEST PARAMETER
			TestConfigMethods.clickButton(2);

			// CLICK THE SEARCH ICON BUTTON
			TestConfigMethods.clickElement(TestConfigPage.SearchIconDataType, "CHECKING THE DATA TYPE SEARCH ICON");

			// CHECKING DATA TYPE DROPDOWN PROPERTIES

			dataTypeDropDown();
		}

		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void dataTypeDropDown() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.dataTypeSearchButton));
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0450-02",
				TestConfigPage.dataTypeSearchButton, "THE DATA TYPE DROP DOWN PROPERTIES", "1");
	}
}
