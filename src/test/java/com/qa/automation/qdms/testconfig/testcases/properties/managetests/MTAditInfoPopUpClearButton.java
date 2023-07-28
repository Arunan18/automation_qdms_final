/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen -Add Field-"Clear" Button Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (11)         MTC-MT-289         23/06/2023       Arunan    Original Version
*****************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class MTAditInfoPopUpClearButton extends DriverIntialization{

	@Test
	public static void mTAditInfoPopUpClearButton() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests",10,"Description","Test Configuration Properties","Manage_Tests","MTC-MT-289");
		
//		Check Additional Information Pop-up Properties
		if(NavigateManageTestFromLogin.clicked) { 
			properties();
		}
		
//		Refresh
		driver.navigate().refresh();
		
//		Logout
		Logout.LogoutFunction();
	}
	
	public static void properties() {
		ManageTestsPage mtp=new ManageTestsPage();
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx",
	                "Manage_Tests","MTC-MT-289-02",ManageTestsPage.clearButton,
	                "Checking Additional Inormation PopUp Clear Button Properties :");
	}
}
