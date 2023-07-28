//***********************************************************************************
// Description
//------------
//Test Configure - Configure Test Table-  Configure Equation Tab - "Equation Type" Drop Down Under- Select Parameter for create equation- Under -"Relevent Checkbox" UI Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 26/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0587           26/06/2023    NILUXY.K      Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureEquationTab_SelectParameter_RelevantCheckboxProperties
		extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();
	static String data = null;

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0587");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);

		// CLICK THE SEARCH ICON BUTTON
		TestConfigMethods.clickElement(TestConfigPage.resultRadioButton, "CHECKING THE RESULT RADIO ICON");

		// CALLING THE METHOD FOR CHECKING RELEVENT CHECKBOX PROPERTIES
		releventCheckboxProperties();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR CHECKBOX
	public static void releventCheckboxProperties() {
		PageFactory.initElements(driver, testPage);

		// CHECK RELEVENT CHECKBOC PROPERTIES
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0587-02", TestConfigPage.releventHeadingUnderSelectParameter,
				"SELECT PARAMETER EQUATION UNDER_'RELEVENT'-CHECKBOX PROPERTIES");

	}

}

