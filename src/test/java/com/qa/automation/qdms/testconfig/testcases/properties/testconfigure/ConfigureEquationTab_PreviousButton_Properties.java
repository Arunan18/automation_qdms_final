//***********************************************************************************
// Description
//------------
//Test Configure - Configure Test Table-  Configure Equation Tab-  "Previous"  Button Properties
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 26/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0618           26/06/2023    NILUXY.K      Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureEquationTab_PreviousButton_Properties extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void previousButton() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure","TC-TCN-0618");

		//CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);	
	
		//DOWN THE PAGE
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//CALLING THE METHOD FOR CHECKING THE PREVIOUS BUTTON PROPERTIES
		previousButtonProperties();

		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();
	}

	// COMMON METHOD FOR CALLING THE PROPERTIES FOR BUTTON
	public static void previousButtonProperties() {
		PageFactory.initElements(driver, testPage);
		// CHECK PREVIOUS BUTTON PROPERTIES
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0618-02",
				TestConfigPage.acceptedcretpreviousbutton, "CONFIGURE EQUATION PREVIOUS BUTTON PROPERTIES");
	}

}
