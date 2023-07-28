/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -"Active"- UI Heading  Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (8)         MTC-MT-285         22/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAditInfoPopUpActiveTextBoxHeading extends DriverIntialization {

	@Test
	public static void mTAditInfoPopUpActiveTextBoxHeading() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-285");

//		Check Additional Information Pop-up Properties
		if (NavigateManageTestFromLogin.clicked) {
			properties();
		}

//		Refresh
		driver.navigate().refresh();

//		Logout
		Logout.LogoutFunction();
	}

	public static void properties() {
		ManageTestsPage mtp = new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-285-02", ManageTestsPage.ActiveCheckBoxHeading,
				"Checking Additional Inormation PopUp Active Checkbox Heading Properties :");
	}
}
