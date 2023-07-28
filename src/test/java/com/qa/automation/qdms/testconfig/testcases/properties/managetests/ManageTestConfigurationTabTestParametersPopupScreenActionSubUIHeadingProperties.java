/**********************************************************************************
* Description
*------------
*Test Configure - Manage Test Configuration Tab- Test Parameters Pop up Screen- "Action" Sub UI Heading Properties
***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 18/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ==========
*MTC-MT-175          18/07/2023    Shobika      Original Version
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


	public class ManageTestConfigurationTabTestParametersPopupScreenActionSubUIHeadingProperties extends DriverIntialization {

		static ManageTestsPage managetestheading = new ManageTestsPage();

		@Test
		public static void ManageTestConfigurationTabTestParametersPopupScreenActionSubUIHeadingPropertie() throws InterruptedException, IOException {

			// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
			// TEST PAGE
			NavigateManageTestFromLogin.navigateManageTestFromLogin("Manage Tests", 10);

			// COMMON METHOD FOR SEARCH AND CLICK
			AddGroupKey.actionS(0, 7, ManageTestsPage.managetexttablecontainer, "Description",
					"Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-175-01", 2);
	//
			// CHECKING TEST PARAMETER POPUP PARAMETER HEADING PROPERTIES
			ManageTestConfigurationTabTestParametersPopupactionheading();
	        
//			//REFRESH		
			driver.navigate().refresh();

			// LOGOUT
			Logout.LogoutFunction();

		}

		public static void ManageTestConfigurationTabTestParametersPopupactionheading() {

			PageFactory.initElements(driver, managetestheading);

			PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
					"MTC-MT-175-02", ManageTestsPage.popuptableparameteractionheading, "Manage Test - Test Parameter Pop up Action Sub UI Heading");

		}

	}



