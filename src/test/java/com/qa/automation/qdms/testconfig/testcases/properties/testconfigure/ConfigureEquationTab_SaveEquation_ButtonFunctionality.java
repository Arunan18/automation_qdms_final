//***********************************************************************************
// Description
//------------
//Test Configure - Configure Test Table-  Configure Equation Tab - Equation Type Action - "Save Equation" button Functionality
//***********************************************************************************
//
// Author           : NILUXY KRISHNATHAVAM
// Date Written     : 26/06/2023
//  
// Test Case Number       Date         Author        Comments
// ================       ====         =====        ========
// TC-TCN-0616          26/06/2023    NILUXY.K      Original Version
//************************************************************************************
package com.qa.automation.qdms.testconfig.testcases.properties.testconfigure;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class ConfigureEquationTab_SaveEquation_ButtonFunctionality extends DriverIntialization {
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void configureEquation() throws InterruptedException, IOException {

		// CALLING THE COMMON METHOD FOR NAVIGATE FROM-LOGIN TO SCROLLING IN THE MANAGE
		// TEST PAGE AND CLICK ONE DATA FROM EXCEL
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure","TC-TCN-0616");

		// CALLING THE METHOD FOR NAVIGATE TO TEST CONFIGURE MODULE-CONFIGURE EQUATION
		// TAB
		TestConfigMethods.navigate_TestConfigureTabs(3);
	
		//DOWN THE PAGE
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		
		// CALLING THE METHOD FOR CHECKING THE SAVE BUTTON FUNCTIONALITY
		saveButtonFucntionality();
		
		// LOGOUT TO THE SYSTEM
		Logout.LogoutFunction();

	}

	// COMMON METHOD FOR CALLING THE FUCNTIONALITY FOR BUTTON
	public static void saveButtonFucntionality() {
		PageFactory.initElements(driver, testPage);
		// CHECK 'SAVE'BUTTON FUCNTIONALITY
		try {
			TestConfigPage.eqsavebtn.isDisplayed();
			testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON DISPLYED");
			testCase.log(Status.INFO, "THE SAVE BUTTON IS DISPLYED");
			testCase.log(Status.PASS, "TEST PASS ");
			try {
				TestConfigPage.eqsavebtn.isEnabled();
				testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON ENABLED");
				testCase.log(Status.INFO, "THE SAVE BUTTON IS ENABLED");
				testCase.log(Status.PASS, "TEST PASS ");

			} catch (NoSuchElementException e) {
				testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON DISPLYED");
				testCase.log(Status.INFO, "THE SAVE BUTTON IS NOT DISPLYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");

			} catch (Exception e) {
				testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON DISPLYED");
				testCase.log(Status.INFO, "THE SAVE BUTTON IS NOT DISPLYED");
				testCase.log(Status.FAIL, "TEST FAIL ❎");
			}

		} catch (

		NoSuchElementException e) {
			testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON ENABLED");
			testCase.log(Status.INFO, "THE SAVE BUTTON IS NOT ENABLED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		} catch (Exception e) {
			testCase = extent.createTest("CHECKING THE SAVE EQUATION BUTTON ENABLED");
			testCase.log(Status.INFO, "THE SAVE BUTTON IS NOT ENABLED");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}

}
