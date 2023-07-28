
/***********************************************************************************
* Description
*------------
Test Configure - Config Group Test - Top Bar "Config Group Test" UI Heading Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0025           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigGroupTest_Heading extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	
	ConfigGroupTestSiteButton.navicationToPath();


//		Check Properties
	propertiesConfigGroupTest_Heading();

		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_Heading() {


		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0025-02", configGroupTestsPage.ConfigGroupTest_Heading, "Step-4--Config Group Test 'Config Group Test' Heading Properties");

	}


	

}
