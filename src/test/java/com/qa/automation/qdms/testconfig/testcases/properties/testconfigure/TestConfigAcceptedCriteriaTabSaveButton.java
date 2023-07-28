
/***************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value,  "Save" Button Properties
 ****************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 11/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0652	        11/07/2023      Shangeetha    Original Version  
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

public class TestConfigAcceptedCriteriaTabSaveButton extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void AcceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0652");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(1000);

		// Check 'Save' Button Properties on Accepted Criteria Tab
		methodSaveButtonProperties();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	
	public static void methodSaveButtonProperties() {
		PageFactory.initElements(driver, testPage);
		// Check 'Save' Button Properties on Accepted Criteria Tab 
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0652-02", TestConfigPage.acceptedCriteriaSaveButton, "'Save' Button Properties ");
	}
}

