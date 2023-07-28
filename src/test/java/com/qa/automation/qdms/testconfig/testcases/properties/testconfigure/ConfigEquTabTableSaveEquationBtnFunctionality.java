
/********************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Configure Equation Tab, "Save Equation" button Functionality 
 ********************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 08/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0616			 08/07/2023   Shangeetha    Original Version  
 ******************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.functionality;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigEquTabTableSaveEquationBtnFunctionality extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();
	
	@Test
	public static void configureEquation() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0616");

		// Calling The Method For Navigate To Test Configure Module-Configure Equation Tab
		TestConfigMethods.navigate_TestConfigureTabs(3);
        Thread.sleep(1000);
        
		// Calling The Method To Check 'Save Equation' Button Functionality on Test Configure Module, Configure Equation Tab
        configModuleConfigEquationTabPopUpSaveEquationBtnFunctionality();
 
		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	
	public static void configModuleConfigEquationTabPopUpSaveEquationBtnFunctionality() {
		PageFactory.initElements(driver, testPage);
		//Check 'Delete' Icon Pop-Up, 'Save Equation' Button Functionality
		functionality.ButtonAndIconunctionalityMtd("'Save Equation' Button Functionality", TestConfigPage.configEquationTabSaveEquationlBtn, "Button");
		
	}
}
