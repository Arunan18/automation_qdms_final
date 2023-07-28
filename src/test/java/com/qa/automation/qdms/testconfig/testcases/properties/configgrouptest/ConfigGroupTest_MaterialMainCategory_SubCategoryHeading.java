/***********************************************************************************
* Description
*------------
Test Configure - Config Group Test - Top Bar Config Group Test - "Sub Category" UI Heading Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0028           26/06/2023   Quenthan     Orginal Version
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

public class ConfigGroupTest_MaterialMainCategory_SubCategoryHeading extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	ConfigGroupTestSiteButton.navicationToPath();	

//		Check Properties
	propertiesConfigGroupTest_SubCategoryHeading();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_SubCategoryHeading() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0028-02", configGroupTestsPage.ConfigGroupTest_SubCategoryHeading, "Step-4--Config Group Test- 'Sub Category' Heading Properties");

	}




}
