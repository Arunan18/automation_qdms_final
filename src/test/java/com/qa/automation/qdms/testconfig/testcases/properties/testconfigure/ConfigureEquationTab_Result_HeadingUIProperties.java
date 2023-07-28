//***********************************************************************************
// Description
//------------
//Test Configure-Configure Test Table-Configure Equation Tab-Equation Type-"RESULT"Heading UI Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 22/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0578           22/06/2023    NILUXY.K      Original Version
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

public class ConfigureEquationTab_Result_HeadingUIProperties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0578");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);

		// CALLING THE METHOD FOR CHECKING THE RESULT HEADING PROPERTIES
		resultHeadingProperties();
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR HEADING
	public static void resultHeadingProperties() {
		PageFactory.initElements(driver, testPage);
		// CHECK 'RESULT' HEADING PROPERTIES
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0578-02", TestConfigPage.resultHeading, "RESULT-HEADING PROPERTIES");
	}

}
