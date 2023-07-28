
/****************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Select "Between" Condition, First Table:
 * "Material" Column Search Pop-Up, "Reset" Button Properties
 ****************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 12/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0645		    12/07/2023      Shangeetha    Original Version  
 ***************************************************************************************************************************/

package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class TestConfigAcceptedCriteriaFirstTableMaterialColumnSearchPopUpResetBtn extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0645");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(1000);

		// Accepted criteria Tab, Select "Between" Condition, First Table :Check "Material" Column Search Pop-Up's "Reset" Button Properties 
		methodClickOnColumnSearchIcon();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodClickOnColumnSearchIcon() {
		PageFactory.initElements(driver, testPage);

		try {
			TestConfigPage.equationConditionBetweenMaterialColumnSearchIcon.click();
			Thread.sleep(500);
			testCase = extent.createTest("Click on Column 'Search' Icon");
			testCase.log(Status.INFO, "Clicked on Column 'Search' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	

			// Check 'Material' Column Search Pop-Up's 'Reset' Button Properties
			methodMaterialColumnSearchIconPopUpResetButton();
			
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Column 'Search' Icon");
			testCase.log(Status.INFO, "Unable to Click on the Column 'Search' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");		
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the Column 'Search' Icon");
			testCase.log(Status.INFO, "Unable to Locate and Click on the Column 'Search' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void methodMaterialColumnSearchIconPopUpResetButton() {
		PageFactory.initElements(driver, testPage);
		// Accepted criteria Tab, Select "Between" Condition, First Table :Check "Material" Column Search Pop-Up's "Reset" Button Properties 
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0645-02", TestConfigPage.equationConditionBetweenMaterialColSearchPopResetBtn, "'Reset' Button Properties on 'Material' Column Search Pop-Up");
	}
}
