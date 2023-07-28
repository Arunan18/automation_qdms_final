/************************************************************************************
* Description
*------------
* Test Configure Table - Parameter  Table - "Data Type"  Search Button  Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 23/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0451         23/06/2023      RAHUL.S    Original Version
*
*************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ParameterTableDataTypeSearchButton extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test = null;

	@Test
	public static void dataTypeSearchDropDown() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0451");

		// CLICK THE TEST PARAMETER
		TestConfigMethods.clickButton(2);

		// CLICK THE SEARCH ICON BUTTON
		TestConfigMethods.clickElement(TestConfigPage.SearchIconDataType, "CHECKING THE DATA TYPE SEARCH ICON");

		// CHECKING DATA TYPE SEARCH BUTTON PROPERTIES
		if (NavigateManageTestFromLogin.clicked) {
		dataTypeSearchButton();
		}
		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void dataTypeSearchButton() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//button[1]"))));
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0451-02", driver.findElement(By.xpath("//div[@class='ant-table-filter-dropdown']//button[1]")),
				"PARAMETER DATATYPE SEARCH BUTTON");

	}
}
