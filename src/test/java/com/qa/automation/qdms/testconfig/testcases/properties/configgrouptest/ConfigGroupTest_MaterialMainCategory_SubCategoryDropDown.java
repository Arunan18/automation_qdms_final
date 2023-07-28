/***********************************************************************************
* Description
*------------
Test Configure - Config Group Test - Top Bar Config Group Test - "Sub Category" Drop Down Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0029           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class ConfigGroupTest_MaterialMainCategory_SubCategoryDropDown extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	ConfigGroupTestSiteButton.navicationToPath();
	TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0029-01");
	ConfigGroupTest_MaterialMainCategory_SubCategoryDropDown.fillDdMAtrialmanin();
	


//		Check Properties
	propertiesConfigGroupTest_SubCategoryDropDown();

		driver.navigate().refresh();
		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_SubCategoryDropDown() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		ProCommonMethods.dropDownMulti("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0029-02", configGroupTestsPage.ConfigGroupTest_SubCategoryDropDown, "Step-4--Config Group Test- 'Sub Category' Drop Down Properties","1",2);

	}
	
	public static void fillDdMAtrialmanin() {
		
		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown,TestConfiRev_MaterialSubHeadingProperties.adddata.get(1));
		
	}




}
