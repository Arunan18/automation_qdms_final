
/****************************************************************************************************************************
 * Description
 *------------
 * Test Configure Module, Top Bar Accepted criteria, Accepted Value, Select " Equal (=)" Condition, First Table:
 * "Value" Column Heading UI Properties
 ****************************************************************************************************************************
 *
 * Author           : Shangeetha Mahendran
 * Date Written     : 13/07/2023
 * 
 *
 * 
 * Test Case Number        Date         Intis          Comments
 * ================        ====         =====          ========
 * TC-TCN-0646		    13/07/2023      Shangeetha    Original Version  
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
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.commonnavigation.NavigateManageTestFromLogin;

public class AcceptedCriteriaFirstTableEqualValueColumnHeading extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();
	@Test
	public static void acceptedCriteria() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0646");

		// Calling The Method For Navigate To Test Configure Module-Accepted criteria Tab
		TestConfigMethods.navigate_TestConfigureTabs(4);
		Thread.sleep(2000);

		//Accepted criteria Tab, First Table: Check 'Value' Column Heading Properties   
		methodSelectDropdownValue();        

		// Log Out Of The System.
		Logout.LogoutFunction();

	}


	public static void methodSelectDropdownValue() {
		PageFactory.initElements(driver, testPage);

		try {
			
			//"Select Test Parameter" Drop-down: Select "cemen (F)"
			ActionCommonMethod.dropdDown(TestConfigPage.acceptedCriteriaSelectTestParameterDropdownTextBox, NavigateManageTestFromLogin.excelDataValue.get(1));
			Thread.sleep(500);
			testCase = extent.createTest("Select the option 'cemen (F)' from the 'Select Test Parameter' Drop-down");
			testCase.log(Status.INFO, "Selected the option 'cemen (F)' from the 'Select Test Parameter' Drop-down");
			testCase.log(Status.PASS, "TEST PASS ☑");	
						
			//"Equation Condition" Drop-down: Select "Equal(=)"
			ActionCommonMethod.dropdDown(TestConfigPage.equationConditionSelectionDropdownTextBox, NavigateManageTestFromLogin.excelDataValue.get(2));
			Thread.sleep(1000);
			testCase = extent.createTest("Select the option ' Equal (=)' from the 'Equation' Drop-down");
			testCase.log(Status.INFO, "Selected the option ' Equal (=)' from the 'Equation' Drop-down");
			testCase.log(Status.PASS, "TEST PASS ☑");	
			
			//"Equal" Condition, First Table: Check 'Value' Column Heading Properties   
			methodFirstTableValueColumnHeadingProperties(); 
			
			
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Select the particular dropdown option");
			testCase.log(Status.INFO, "Unable to select the particular dropdown option");
			testCase.log(Status.FAIL, "TEST FAIL ❎");		
		} catch (Exception e) {
			testCase = extent.createTest("Locate and Select the particular dropdown option");
			testCase.log(Status.INFO, "Unable to Locate and Select the particular dropdown option");
			testCase.log(Status.FAIL, "TEST FAIL ❎");
		}
	}


	public static void methodFirstTableValueColumnHeadingProperties() {
		PageFactory.initElements(driver, testPage);
		//Accepted criteria Tab, "Equal" Condition, First Table: Check 'Value' Column Heading Properties   
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0646-02", TestConfigPage.equationConditionEqualValueHeading, "'Value' Column Heading Properties");
	}
}
