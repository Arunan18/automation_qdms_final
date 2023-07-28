/**********************************************************************************************************************************************
* Description
*------------
* Test Configure Config Group Test Top Bar Config Group Test Table Top Configured Groups Action Delete Pop up Screen Cancel button Functionality   
************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 07/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0064           07/07/2023   M.Mathushan    Original Version
*
************************************************************************************************************************************************/
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
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenCancelbuttonFunctionality   extends DriverIntialization {

	static configGroupTestsPage lk = new configGroupTestsPage();
	   
	@Test

	public static void configureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenCancelbuttonFunctionality        ()
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, lk);

		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0064-01");

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
		configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenCancelbuttonFunctionality();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsActionDeletePopupScreenCancelbuttonFunctionality() throws InterruptedException {
		PageFactory.initElements(driver, lk);
		Thread.sleep(2000);
	try {
		if (configGroupTestsPage.configGroupTest_AfterDropDownconfiguredeletepopupcancelbutton.isDisplayed()) {
			testCase = extent.createTest(
					"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Displayed");
			testCase.log(Status.INFO,
					"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Displayed");
			testCase.log(Status.PASS, "TEST PASS");
			if (configGroupTestsPage.configGroupTest_AfterDropDownconfiguredeletepopupcancelbutton.isEnabled()) {
				testCase = extent.createTest(
						"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Enabled");
				testCase.log(Status.INFO,
						"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Enabled");
				testCase.log(Status.PASS, "TEST PASS");
			} else {
				testCase = extent.createTest(
						"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Not Enabled");
				testCase.log(Status.INFO,
						"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Not Enabled");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(
					"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Not Displayed");
			testCase.log(Status.INFO,
					"ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is Not Displayed");
			testCase.log(Status.FAIL, "TEST FAIL");
		} 
	} catch (NoSuchElementException e) {
		 testCase = extent.createTest("Checking ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button");
         testCase.log(Status.INFO, "ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button is not available");
         testCase.log(Status.FAIL, "TEST FAIL");
	} catch(Exception e) {
		testCase = extent.createTest("Checking ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button");
        testCase.log(Status.INFO, "Unable to Check ConfigGroup Test Table Top Configured Groups Delete PopUp Screen Cancel Button");
        testCase.log(Status.FAIL, "TEST FAIL");
		
	}    
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
