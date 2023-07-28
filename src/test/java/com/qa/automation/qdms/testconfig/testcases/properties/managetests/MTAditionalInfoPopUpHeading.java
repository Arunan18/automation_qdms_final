/***************************************************************************************************
* DECRIPTION
*---------------------------------------------------------------------------------------------------
* Test Configure - Manage Test Configuration Tab- Additional Information Pop up Screen - "Additional Information" UI Heading  Properties
****************************************************************************************************
*
* @author      : Suntharalingam Arunan
* 
* ==================================================================================================
*     No    /     Test Case Number    /   Date          /      Intis      /    Comments
* ==================================================================================================
* (2)         MTC-MT-278         22/06/2023       Arunan    Original Version
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

public class MTAditionalInfoPopUpHeading extends DriverIntialization{

	@Test
	public static void mTAditionalInfoPopUpHeading() throws InterruptedException, IOException {
//		Login >> Additional Information Click via Manage test
		NavigateManageTestFromLogin.clickIcon("Manage Tests",10,"Description","Test Configuration Properties","Manage_Tests","MTC-MT-278");
		
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
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx",
	                "Manage_Tests","MTC-MT-278-02",ManageTestsPage.additionalInfoPopUpHeading,
	                "Checking Additional Inormation PopUp Heading Properties :");
	}
}
