/*************************************************************************************************************************************************************************
* Description
*------------
*Test Configure Manage Test Configuration Tab Raw Material Reset Button  UI Properties
**************************************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 12/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*MTC-MT-150           12/07/2023   M.Mathushan    Original Version
*
*****************************************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ManageTestConfigurationTabRawMaterialResetButtonUIProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();
	@Test

	public static void testConfigurationTabRawMaterialResetButtonUIProperties   ()
			throws InterruptedException, IOException {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

		// Navicate Test Config
		TestConfigNavigation.TestConfigurationCard();
		
		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(configGroupTestsPage.mainManagetestConfigureNavication));
			ActionCommonMethod.visbleEnable2(configGroupTestsPage.mainManagetestConfigureNavication,
					"Manage Tests Configure Navication", 1);
			configGroupTestsPage.mainManagetestConfigureNavication.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		}
			
		//Click the RawMaterial Search Icon
		rawmaterialSearchIconxclick();
		 
		//Check the Manage Test Configuration TabKey Test Icon Properties
		 configurationTabRawMaterialResetButtonUIProperties();
		
		// Click the Refresh
		Thread.sleep(1000);
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();
	}

	public static void configurationTabRawMaterialResetButtonUIProperties () throws InterruptedException {
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-150-02",ManageTestsPage.testConfigureManageTestConfigurationTabedrawmaterialresetbutton,
				"Step-4--testConfigure ManageTest Configuration Tab Subcategory Reset Button Properties");
	}
	
	//Click the RawMaterial Search Icon
		public static void rawmaterialSearchIconxclick() {
			PageFactory.initElements(driver, mtp);
			try {
				ManageTestsPage.testConfigureManageTestConfigurationTabedrawmaterialiconProperties.click();
				testCase=extent.createTest("Click the Test Configure Manage Test Configuration Tab RAW Material Search Icon");
				testCase.log(Status.PASS, "TEST PASS");
			} catch (NoSuchElementException e) {
				testCase=extent.createTest("Not Visible the Test Configure Manage Test Configuration Tab  RAW Material Search Icon");
				testCase.log(Status.FAIL, "TEST FAIL");
			}catch (ElementClickInterceptedException e) {
				testCase=extent.createTest("Not Click the Test Configure Manage Test Configuration Tab  RAW Material Search Icon");
				testCase.log(Status.FAIL, "TEST FAIL");
			}catch (Exception e) {
				testCase=extent.createTest("Not Click the Test Configure Manage Test Configuration Tab  RAW Material Search Icon");
				testCase.log(Status.FAIL, "TEST FAIL");
			}
		}
}






