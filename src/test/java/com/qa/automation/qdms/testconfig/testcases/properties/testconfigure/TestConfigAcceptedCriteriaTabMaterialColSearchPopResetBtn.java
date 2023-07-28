
/***************************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Second Table, "Material" Column Search Icon's Pop-Up, "Reset"
 * Button Properties
 ***************************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 10/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0664 		    10/07/2023      Shangeetha    Original Version  
 *************************************************************************************************************************************/


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

public class TestConfigAcceptedCriteriaTabMaterialColSearchPopResetBtn extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void AcceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0664");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(1000);

		// Check 'Reset' Button Properties on 'Material' Column Search Pop-Up  
		methodClickOnColumnSearchIcon();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}

	public static void methodClickOnColumnSearchIcon() {
		PageFactory.initElements(driver, testPage);

		try {
			TestConfigPage.acceptedCriteriaTableTwoMaterialColumnSearchIcon.click();
			Thread.sleep(500);
			testCase = extent.createTest("Click on Column 'Search' Icon");
			testCase.log(Status.INFO, "Clicked on Column 'Search' Icon");
			testCase.log(Status.PASS, "TEST PASS ☑");	

			// Check 'Reset' Button Properties on 'Material' Column Search Pop-Up
			methodResetButtonProperties();
			
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the Column 'Search' Icon");
			testCase.log(Status.INFO, "Unable to Click on the Column 'Search' Icon");
			testCase.log(Status.FAIL, "TEST FAIL");		
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Click on the Column 'Search' Icon");
			testCase.log(Status.INFO, "Unable to Locate and Click on the Column 'Search' Icon");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}

	}

	public static void methodResetButtonProperties() {
		PageFactory.initElements(driver, testPage);
		// Check 'Reset' Button Properties on 'Material' Column Search Pop-Up 
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0664-02", TestConfigPage.acceptedCriteriaTableTwoMaterialColSrchPopResetBtn, "'Reset' Button Properties on 'Material' Column Search Pop-Up");
	}
}
