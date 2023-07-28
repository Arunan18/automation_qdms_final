
/***********************************************************************************
* Description
*------------
*Test Configure - Config Group Test - Top Bar Config Group Test-"Material Main Category" Drop Down Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0027           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigGroupTest_MaterialMainCategory_DropDown extends DriverIntialization {

	@Test
	public void propertiesChecking() throws InterruptedException, IOException {

		ConfigGroupTestSiteButton.navicationToPath();

//		Check Properties
		propertiesConfigGroupTest_MaterialMainCategoryDropDown();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_MaterialMainCategoryDropDown() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		ProCommonMethods.dropDown("Test Configuration Properties.xlsx", "Config_Group_Test", "TC-CGT-0027-02",
				configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown,
				"Step-4--Config Group Test- 'Material Main Category' Drop Down Properties", "1");

	}

}
