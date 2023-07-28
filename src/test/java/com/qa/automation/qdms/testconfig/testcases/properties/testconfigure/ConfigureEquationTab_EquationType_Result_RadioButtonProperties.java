//***********************************************************************************
// Description
//------------
//Test Configure-Configure Test Table-Configure Equation Tab-Equation Type-"RESULT"Radio Button Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 22/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0579           22/06/2023    NILUXY.K      Original Version
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

public class ConfigureEquationTab_EquationType_Result_RadioButtonProperties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0579");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);

		// CALLING THE METHOD FOR CHECKING THE RESULT RADIO ICON PROPERTIES
		resultRadioIconProperties();
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR RADIO ICON
	public static void resultRadioIconProperties() {
		PageFactory.initElements(driver, testPage);
		// CHECK 'RESULT'RADIO ICON PROPERTIES
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0579-02",
				TestConfigPage.resultRadioButton, "RESULT RADIO ICON PROPERTIES");
	}

}
