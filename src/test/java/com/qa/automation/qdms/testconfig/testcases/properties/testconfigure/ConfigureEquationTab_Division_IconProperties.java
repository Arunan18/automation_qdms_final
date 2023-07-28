//***********************************************************************************
// Description
//------------
//Test Configure-Configure Test Table-Configure Equation Tab-Equation Type "/" icon Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 22/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0591           22/06/2023    NILUXY.K      Original Version
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

public class ConfigureEquationTab_Division_IconProperties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void divisionIcon() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0591");

		//CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);	
	
		//CALLING THE METHOD FOR CHECKING THE DIVSION ICON PROPERTIES
		divisionIconProperties();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR ICON
	public static void divisionIconProperties() {
		PageFactory.initElements(driver, testPage);
		// CHECK '/' ICON PROPERTIES
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0591-02",
				TestConfigPage.divisionIcon, "'/' ICON PROPERTIES");
	}

}
