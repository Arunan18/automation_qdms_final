/***********************************************************************************
* Description
*------------
Test Configure - Config Group Test - Top Bar Config Group Test - "Select Material" Drop down Properties
*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0031           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.ProCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class ConfigGroupTest_SelectMaterialDropdown extends DriverIntialization{


@Test
	public void propertiesChecking() throws InterruptedException, IOException {
	ConfigGroupTestSiteButton.navicationToPath();
	TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0031-01");
	ConfigGroupTest_MaterialMainCategory_SubCategoryDropDown.fillDdMAtrialmanin();
	ConfigGroupTest_SelectMaterialDropdown.fillDdMAtrialSubmanin();

//		Check Properties
	propertiesConfigGroupTest_SelectMaterialDropdown();

		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_SelectMaterialDropdown() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		ProCommonMethods.dropDownMulti("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0031-02", configGroupTestsPage.ConfigGroupTest_SelectMaterialDropdown, "Step-4--Config Group Test- 'Select Material' Drop down Properties","1",3);

	}
	public static void fillDdMAtrialSubmanin() {
		
		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_SubCategoryDropDown,TestConfiRev_MaterialSubHeadingProperties.adddata.get(2));
		
	}

	

}
