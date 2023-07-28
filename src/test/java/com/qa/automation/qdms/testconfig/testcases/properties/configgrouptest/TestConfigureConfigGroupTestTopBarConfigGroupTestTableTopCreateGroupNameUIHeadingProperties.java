/**************************************************************************************************************
* Description
*------------
* Test Configure Config Group Test Top Bar Config Group Test Table Top Create Group Name UI Heading Properties
***************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 05/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0040           05/07/2023   M.Mathushan    Original Version
*
**************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;

import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureConfigGroupTestTopBarConfigGroupTestTableTopCreateGroupNameUIHeadingProperties extends DriverIntialization{
	static configGroupTestsPage lk = new configGroupTestsPage();
	
	@Test
	
	public static void configGroupTestTopBarConfigGroupTestTableTopCreateGroupNameUIHeadingProperties() throws InterruptedException, IOException {
		PageFactory.initElements(driver, lk);
		
		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();
		
		//Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0040-01");
		
		//Fill the Data For Dropdown
		filldropdown() ;
		
		//Click the Report Type
		try {
			
			configGroupTestsPage.ConfigGroupTest_ReportTypeCheckBoxButton.click();
			testCase=extent.createTest("Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.PASS,"Test Pass");
		} catch (NoSuchElementException e) {
			testCase=extent.createTest("Not Visible Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL,"Test Fail");
		}catch (ElementClickInterceptedException e) {
			testCase=extent.createTest("Not Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL,"Test Fail");
		}catch (Exception e) {
			testCase=extent.createTest("Not Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL,"Test Fail");
		}
		//Check Properties
	    testTopBarConfigGroupTestTableTopCreateGroupNameUIHeadingProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void testTopBarConfigGroupTestTableTopCreateGroupNameUIHeadingProperties() {

		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0040-02", configGroupTestsPage.configGroupTest_AfterDropDowncreategroupnameheading,
				"Step-4--Config Group Test- After Drop Down Table - Create Group Name Heading Properties");

	}
	
	public static void filldropdown() {
		
		PageFactory.initElements(driver, lk);
	
		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown, TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
	
	}
}
