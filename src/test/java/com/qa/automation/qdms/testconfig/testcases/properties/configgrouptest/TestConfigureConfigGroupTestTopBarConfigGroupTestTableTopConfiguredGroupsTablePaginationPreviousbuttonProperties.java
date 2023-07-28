/**********************************************************************************************************************************************
* Description
*------------
* Test Configure Config Group Test Top Bar Config Group Test Table Top Configured Groups Table Pagination Previous button Properties  
************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 07/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0066           07/07/2023   M.Mathushan    Original Version
*
************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;
import java.io.IOException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTablePaginationPreviousbuttonProperties   extends DriverIntialization {

	static configGroupTestsPage lk = new configGroupTestsPage();
	   
	@Test

	public static void configureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTablePaginationPreviousbuttonProperties  ()
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, lk);

		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0066-01");

		// Fill the Data For Dropdown
		filldropdown();

		// Click the Report Type
		try {

			configGroupTestsPage.ConfigGroupTest_ReportTypeCheckBoxButton.click();
			testCase = extent.createTest("Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.PASS, "Test Pass");
		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Not Visible Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Not Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL, "Test Fail");
		} catch (Exception e) {
			testCase = extent.createTest("Not Click theConfigure Test Report Type Check Box Button ");
			testCase.log(Status.FAIL, "Test Fail");
		}
		// Scorall Down
		for (int down = 0; down < 10; down++) {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(500);
		}
	
		
		// Check Properties
		configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTablePaginationPreviousbuttonProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTablePaginationPreviousbuttonProperties() throws InterruptedException {
		PageFactory.initElements(driver, lk);
		Thread.sleep(2000);
		
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0066-02", configGroupTestsPage.configGroupTest_AfterDropDownconfiguregrouptablepaginatrionpreviousbutton,
				"Step-4--Config Group Test- After Drop Down Table - Applicable Test Configure Group Table Pagination Previous Button Properties");

	}
	public static void filldropdown() {

		PageFactory.initElements(driver, lk);

		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
	}
}


