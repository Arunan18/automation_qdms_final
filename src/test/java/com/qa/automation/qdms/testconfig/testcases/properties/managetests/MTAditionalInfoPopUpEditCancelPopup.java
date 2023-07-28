/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- Action -Edit Icon - "Cancel Button" Pop up Screen Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (27)         MTC-MT-300         22/06/2023       Arunan    Original Version
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

public class MTAditionalInfoPopUpEditCancelPopup extends DriverIntialization {

	@Test
	public static void mTAditionalInfoPopUp() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test 
		NavigateManageTestFromLogin.clickCancelClick("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-300", 1);

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
		PropertiesCommonMethods.searchBoxPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-300-02", ManageTestsPage.editCancelpopUp,
				"Checking Additional Inormation PopUp Edit Cancel PopUp Properties :");
	}
}
