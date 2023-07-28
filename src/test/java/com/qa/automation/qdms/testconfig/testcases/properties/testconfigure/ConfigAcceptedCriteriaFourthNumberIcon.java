
/***************************************************************************************************************
 * Description
 *------------
 * Test Configure - Configure Test Table-  Top Bar "Accepted criteria"  icon "4"  Properties
 ***************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 07/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0620			 07/07/2023   Shangeetha    Original Version  
 **************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigAcceptedCriteriaFourthNumberIcon extends DriverIntialization{
static TestConfigPage testPage = new TestConfigPage();
	
	@Test
	public static void configureEquation() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0620");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
        Thread.sleep(1000);
        
		// Check Test Configure Module, "Accepted criteria"  icon "4"  Properties
        methodAcceptCriteriaTabHeading();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	
	public static void methodAcceptCriteriaTabHeading() {
		PageFactory.initElements(driver, testPage);
		// Check Test Configure Module, "Accepted criteria"  icon "4"  Properties
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0620-02", TestConfigPage.acceptedCriteriaFourthNumberIcon, "'Accepted criteria, 4 Icon' Properties");
		
	}
}
