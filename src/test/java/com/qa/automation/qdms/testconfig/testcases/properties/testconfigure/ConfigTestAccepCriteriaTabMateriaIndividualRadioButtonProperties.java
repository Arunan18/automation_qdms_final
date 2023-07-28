
/*********************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value Table, Material Section, "Individual" Radio Button Properties 
 *********************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 08/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0637 		     08/07/2023   Shangeetha    Original Version  
 ******************************************************************************************************************************/


package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigTestAccepCriteriaTabMateriaIndividualRadioButtonProperties extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();
	
	@Test
	public static void configureEquation() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0637");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
        Thread.sleep(1000);
        
    	// Check 'Individual' Radio Button Properties on Test Configure Module, Accepted criteria Tab 
        methodAcceptCriteriaTabIndividualRadioBtnProperties();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	
	public static void methodAcceptCriteriaTabIndividualRadioBtnProperties() {
		PageFactory.initElements(driver, testPage);
		// Check 'Individual' Radio Button Properties on Test Configure Module, Accepted criteria Tab 
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0637-02", TestConfigPage.acceptedCriterialIndividualRadioButton, "'Individual' Radio Button Properties");
	}
}


