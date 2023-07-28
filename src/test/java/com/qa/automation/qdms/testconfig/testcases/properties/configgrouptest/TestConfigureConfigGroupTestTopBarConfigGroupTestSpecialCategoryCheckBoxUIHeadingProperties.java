/******************************************************************************************************************
* Description
*------------
Test Configure  Config Group Test  Top Bar Config Group Test Special Category Check Box UI Heading Properties
*******************************************************************************************************************

*
* Author           :M.Mathushan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0034           04/07/2023   M.Mathushan    Original Version
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

public class TestConfigureConfigGroupTestTopBarConfigGroupTestSpecialCategoryCheckBoxUIHeadingProperties
		extends DriverIntialization {
	@Test
	
	public static  void propertiesChecking() throws InterruptedException, IOException {

		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();

		// Check Properties
		propertiesConfigGroupTest_SpecialCategoryCheckBoxHeading();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTest_SpecialCategoryCheckBoxHeading() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0034-02", configGroupTestsPage.ConfigGroupTest_SpecialCategoryCheckBoxHeading,
				"Step-4--Config Group Test- 'Special Category' Check Box Headng Properties");

	}
}
