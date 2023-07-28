/*****************************************************************************************************************************************
* Description
*------------
* Test Configure Config Group Test Top Bar Config Group Test Table Top Configured Groups Action Delete Pop up Screen Ok button Properties  
******************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0062           06/07/2023   M.Mathushan    Original Version
*
*******************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;
import java.io.IOException;
import org.openqa.selenium.By;
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
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenOkbuttonProperties  extends DriverIntialization {

	static configGroupTestsPage lk = new configGroupTestsPage();
	   
	@Test

	public static void configureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenOkbuttonProperties    ()
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, lk);

		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0062-01");

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
		//Click the Delete Icon
		congiuregrouptestgroupnamedatatestDeleteicon();
		
		// Check Properties
		configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenOkbuttonProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenOkbuttonProperties   () throws InterruptedException {
Thread.sleep(1000);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0062-02", configGroupTestsPage.configGroupTest_AfterDropDownconfiguredeletepopupokbutton,
				"Step-4--Config Group Test- After Drop Down Table - Applicable Test Configure Group Delete popup Ok Button Properties");

	}

	public static void filldropdown() {

		PageFactory.initElements(driver, lk);

		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));

	}
	
public static void congiuregrouptestgroupnamedatatestDeleteicon() throws IOException, InterruptedException {
		
		Searching.searchvalue("TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)", 1);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//main/div/div/div[2]/div/form//form//td[text()='"+TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)+"']/following-sibling::td[3]/span")).click();		
			testCase=extent.createTest("Click The Configure Group Test Delete Popup Screen ");
			testCase.log(Status.PASS, "Test Pass");
		} catch (NoSuchElementException e) {
			testCase=extent.createTest("Not Visible The Configure Group Test Delete Popup Screen");
			testCase.log(Status.FAIL, "Test Fail");
		}catch (ElementClickInterceptedException e) {
			testCase=extent.createTest("Not Click The Configure Group Test Delete  Popup Screen");
			testCase.log(Status.FAIL, "Test Fail");
		}catch (Exception e) {
			testCase=extent.createTest("Not Click The Configure Group Test Delete  Popup Screen");
			testCase.log(Status.FAIL, "Test Fail");
		}
	}
}


