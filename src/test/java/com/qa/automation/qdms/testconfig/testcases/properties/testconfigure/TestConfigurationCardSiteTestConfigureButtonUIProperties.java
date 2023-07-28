/**********************************************************************************
* Description
*------------
*Test Configuration Card Site Test Configure Button UI Properties

***********************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-TCN-0410           10/07/2023    Shobika      Original Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;

public class TestConfigurationCardSiteTestConfigureButtonUIProperties extends DriverIntialization {
	static TestConfigPage testconfigurebutton = new TestConfigPage();

	@Test
	public void TestConfigurationCardSiteTestConfigureButtonUIPropertie() throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		// Test Configuration Card Site Test Configure Button UI Properties
		testconfigurebutton(); 
		// logout test
		Logout.LogoutFunction();
	}

	public static void testconfigurebutton() {
		PageFactory.initElements(driver, testconfigurebutton);
		
		// Test Configuration Card Site Test Configure Button UI Properties
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure",
				"TC-TCN-0410-02", TestConfigPage.testconfigureButton,
				"Test Configuration Card Site Test Configure Button UI Properties");
	}
}
