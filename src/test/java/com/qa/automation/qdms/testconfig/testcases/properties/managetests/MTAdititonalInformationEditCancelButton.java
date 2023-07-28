/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field- Action -Edit Icon - "Cancel" Button Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (24)         MTC-MT-299         26/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAdititonalInformationEditCancelButton extends DriverIntialization {

	@Test
	public static void mTAdititonalInformationEditSaveButton() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickandClickIcon("Manage Tests", 10, "Description", "Test Configuration Properties",
				"Manage_Tests", "MTC-MT-299",1);

//		Check Additional Information Pop-up Properties
		if (NavigateManageTestFromLogin.clicked) {
			Thread.sleep(500);
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
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests", "MTC-MT-299-02",
				ManageTestsPage.editCancelBtn,
				"Checking Additional Inormation Edit Cancel Button Properties :");
	}
}
