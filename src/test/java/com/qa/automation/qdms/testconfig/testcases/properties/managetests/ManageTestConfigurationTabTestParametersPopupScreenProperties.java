/**********************************************************************************
* Description
*------------
*Test Configure - Manage Test Configuration Tab- "Test Parameters" Pop up Screen Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 18/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ==========
* MTC-MT-163           18/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.commonmethods.AddGroupKey;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ManageTestConfigurationTabTestParametersPopupScreenProperties extends DriverIntialization {

	static ManageTestsPage managetestparameterpoppup = new ManageTestsPage();

	@Test
	public static void testparPopupParameterUiProperties() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE
		NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);

		// COMMON METHOD FOR SEARCH AND CLICK
		AddGroupKey.actionS(0, 7, ManageTestsPage.managetexttablecontainer, "Description",
				"Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-163-01", 2);
//
		// CHECKING TEST PARAMETER POPUP PARAMETER HEADING PROPERTIES
		ManageTestConfigurationTabTestParametersPopup();
        
//		//REFRESH		
		driver.navigate().refresh();

		// LOGOUT
		Logout.LogoutFunction();

	}

	public static void ManageTestConfigurationTabTestParametersPopup() {

		PageFactory.initElements(driver, managetestparameterpoppup);

		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-163-02", ManageTestsPage.popuptableparameter, "Manage Test - Test Parameter Pop up ");

	}

}
