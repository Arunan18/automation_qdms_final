
/***************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Second Table, "Parameter" Column Heading Properties
 ***************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 10/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0653 		    10/07/2023      Shangeetha    Original Version  
 *************************************************************************************************************************************/



package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigAcceptedCriteriaTabParameterColumnHeadingProperties extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0653");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(1000);

		// Check 'Parameter' Column Heading Properties on Test Configure Module, Accepted criteria Tab  
		methodAcceptCriteriaTabParameterColumnHeadingProperties();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodAcceptCriteriaTabParameterColumnHeadingProperties() {
		PageFactory.initElements(driver, testPage);
		// Check 'Parameter' Column Heading Properties on Test Configure Module, Accepted criteria Tab
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0653-02", TestConfigPage.acceptedCriteriaTableTwoParameterColumnHeading, "'Parameter' Column Heading Properties");
	}
}

