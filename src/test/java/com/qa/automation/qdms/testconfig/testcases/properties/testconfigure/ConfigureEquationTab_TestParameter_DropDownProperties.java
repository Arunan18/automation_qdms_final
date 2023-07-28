//***********************************************************************************
// Description
//------------
//Test Configure-Configure Test Table-Configure Equation Tab-"Equation Type"DropDown-"Test Parameter"DropDown Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 23/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0581           23/06/2023    NILUXY.K      Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureEquationTab_TestParameter_DropDownProperties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0581");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);

		// CALLING THE METHOD FOR CHECKING THE PARAMETER DROPDOWN PROPERTIES
		parameterDropdownProperties();
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR DROPDOWN
	public static void parameterDropdownProperties() {
		PageFactory.initElements(driver, testPage);
		// CHECK 'TEST PARAMETER DROPDOWN' PROPERTIES
		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0581-02",
				TestConfigPage.dropDownTestParameter, "CONFIGURE EQUATION TEST PARAMETER DROPDOWN PROPERTIES", "1");

	}

}
