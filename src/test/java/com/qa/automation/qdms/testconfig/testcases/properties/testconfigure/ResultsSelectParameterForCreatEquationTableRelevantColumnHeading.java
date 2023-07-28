
/***********************************************************************************************************************************************
 Description
------------
 Test Configure,Configure Test Table, Configure Equation Tab, "Equation Type"- Results, Select a Test Parameter Drop-down, 
 "Select Parameter for create equation" Table: "Relevant" Column Heading
*************************************************************************************************************************************************

 Author           : Shangeetha
 Date Written     : 14/07/2023
  
 Test Case Number       Date         Author        Comments
 ================       ====         =====        ========
 TC-TCN-0586          14/07/2023    Shangeetha      Original Version
***************************************************************************************************************************************************/

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

public class ResultsSelectParameterForCreatEquationTableRelevantColumnHeading extends DriverIntialization{
	static TestConfigPage testPage = new TestConfigPage();

	@Test
	public static void configureEquation() throws InterruptedException, IOException {
		// Calling The Common Method To Navigate From The Login Page To Scrolling In The Manage Test Page and Click on Edit Configure Icon
		NavigateManageTestFromLogin.clickIcon("Manage Tests", 14, "Description", "Test Configuration Properties",
				"Test_Configure", "TC-TCN-0586");

		// Calling The Method For Navigate To Test Configure Module-Configure Equation Tab
		TestConfigMethods.navigate_TestConfigureTabs(3);
        Thread.sleep(1000);
        
      //Check "Relevant" Column Heading Properties
        methodClickRadioButton();

		// Log Out Of The System.
		Logout.LogoutFunction();

	}
	
	
	
	public static void methodClickRadioButton() {
		PageFactory.initElements(driver, testPage);
		
		try {
			
			//Click On Results Radio Button
			TestConfigPage.resultRadioButton.click();
			testCase = extent.createTest("Click On Results Radio Button");
			testCase.log(Status.INFO, "Clicked On Results Radio Button");
			testCase.log(Status.PASS, "TEST PASS ☑");
			
			//Check "Relevant" Column Heading Properties  
			methodSelectDropdownParameter();
			
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Click on the 'Results' Radio Button");
			testCase.log(Status.INFO, "Unable to Locate and Click on the 'Results' Radio Button");
			testCase.log(Status.FAIL, "TEST FAIL ❎");		
		}
		
	}
	
	public static void methodSelectDropdownParameter() {
		PageFactory.initElements(driver, testPage);

		try {
			
			//"Test Parameter" Drop-down: Select "test 03  (W)"
			ActionCommonMethod.dropdDown(TestConfigPage.configureEquationTestparameterdropdown, NavigateManageTestFromLogin.excelDataValue.get(1));
			Thread.sleep(1500);
			testCase = extent.createTest("Select the option 'test 03  (W)' from the 'Test Parameter' Drop-down");
			testCase.log(Status.INFO, "Selected the option 'test 03  (W)' from the 'Test Parameter' Drop-down");
			testCase.log(Status.PASS, "TEST PASS ☑");	
		
			
			//Check "Relevant" Column Heading Properties    
			methodTextProperties(); 
			
			
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
	
	public static void methodTextProperties() {
		PageFactory.initElements(driver, testPage);
		//Check "Relevant" Column Heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test_Configure", "TC-TCN-0586-02", TestConfigPage.configureEquationTestRelevantColumnHeading, "'Relevant' Column Heading Properties");
		
	}
}



