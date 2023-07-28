/*****************************************************************************************************************************************
* Description
*------------
*Test Configure Config Group Test Top Bar Config Group Test Table Top Configured Groups Tests Pop Up Screen Close Button Functionality
******************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 06/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0057           06/07/2023   M.Mathushan    Original Version
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
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTestsPopUpScreenCloseButtonFunctionality  extends DriverIntialization{
	static configGroupTestsPage lk = new configGroupTestsPage();
	   
	@Test

	public static void configureConfigGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTestsPopUpScreenCloseButtonFunctionality ()
			throws InterruptedException, IOException {
		PageFactory.initElements(driver, lk);

		// Navigation path for ConfigGroup Test
		ConfigGroupTestSiteButton.navicationToPath();

		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Config_Group_Test", "TC-CGT-0057-01");

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
		
		//Click the Group Name Test Icon
		 congiuregrouptestgroupnamedatatesticon();
		 
		// Check Properties
		 configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTestsPopUpScreenCloseButtonFunctionality();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();

	}

	public static void configGroupTestTopBarConfigGroupTestTableTopConfiguredGroupsTestsPopUpScreenCloseButtonFunctionality () throws InterruptedException {
		PageFactory.initElements(driver, lk);
		Thread.sleep(2000);
	try {
		if (configGroupTestsPage.configGroupTest_AfterDropDownconfiguredtesttestclosebutton.isDisplayed()) {
			testCase = extent.createTest(
					"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Displayed");
			testCase.log(Status.INFO,
					"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Displayed");
			testCase.log(Status.PASS, "TEST PASS");
			if (configGroupTestsPage.configGroupTest_AfterDropDownconfiguredtesttestclosebutton.isEnabled()) {
				testCase = extent.createTest(
						"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Enabled");
				testCase.log(Status.INFO,
						"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Enabled");
				testCase.log(Status.PASS, "TEST PASS");
			} else {
				testCase = extent.createTest(
						"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Not Enabled");
				testCase.log(Status.INFO,
						"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Not Enabled");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		} else {
			testCase = extent.createTest(
					"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Not Displayed");
			testCase.log(Status.INFO,
					"ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is Not Displayed");
			testCase.log(Status.FAIL, "TEST FAIL");
		} 
	} catch (NoSuchElementException e) {
		 testCase = extent.createTest("Checking ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button");
         testCase.log(Status.INFO, "ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button is not available");
         testCase.log(Status.FAIL, "TEST FAIL");
	} catch(Exception e) {
		testCase = extent.createTest("Checking ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button");
        testCase.log(Status.INFO, "Unable to Check ConfigGroup Test Table Top Configured Groups Tests PopUp Screen Close Button");
        testCase.log(Status.FAIL, "TEST FAIL");
		
	}    
        
	}

	

	public static void filldropdown() {

		PageFactory.initElements(driver, lk);

		ActionCommonMethod.dropdDown(configGroupTestsPage.ConfigGroupTest_MaterialMainCategoryDropDown,
				TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));

	}
	
	public static void congiuregrouptestgroupnamedatatesticon() throws IOException, InterruptedException {
		
		Searching.searchvalue("TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)", 1);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(
					"//main/div/div/div[2]/div/form//form//td[text()='"+TestConfiRev_MaterialSubHeadingProperties.adddata.get(1)+"']/following-sibling::td[2]"))
					.click();
			testCase=extent.createTest("Click The Configure Group Test Icon");
			testCase.log(Status.PASS, "Test Pass");
		} catch (NoSuchElementException e) {
			testCase=extent.createTest("Not Visible The Configure Group Test Icon");
			testCase.log(Status.FAIL, "Test Fail");
		}catch (ElementClickInterceptedException e) {
			testCase=extent.createTest("Not Click The Configure Group Test Icon");
			testCase.log(Status.FAIL, "Test Fail");
		}catch (Exception e) {
			testCase=extent.createTest("Not Click The Configure Group Test Icon");
			testCase.log(Status.FAIL, "Test Fail");
		}
	}

}
