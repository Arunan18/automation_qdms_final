/************************************************************************************
* Description
*------------
* Test Configure Table - Parameter  Table- Pagination Drop down Properties
***********************************************************************************
*
* Author           : SIVABALAN RAHUL
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0458         26/06/2023      RAHUL.S    Original Version
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
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ParameterPaginationDropDown extends DriverIntialization {
	static TestConfigPage testConfig = new TestConfigPage();
	static String test = null;

	@Test
	public static void paraMeterPagninationDropDown() throws InterruptedException, IOException {

		// LOGIN AND NAVIGATE TO TEST CONFIGURE AND NAVIGATE TO EDIT CONFIGURE
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0458");

		// CLICK THE TEST PARAMETER
		TestConfigMethods.clickButton(2);

		// CHECKING DATA TYPE DROPDOWN PROPERTIES
		if (NavigateManageTestFromLogin.clicked) {
			paraMeterPageDropDown();
		}
		// REFRESH
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();
	}

	public static void paraMeterPageDropDown() throws InterruptedException, IOException {
		PageFactory.initElements(driver, testConfig);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(TestConfigPage.paginationParaMeter));
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0458-02",
				TestConfigPage.paginationParaMeter, "PARAMETER PAGINATION DROP DOWN PROPERTIES", "1");
	}
}
