/**********************************************************************************************************************************************
* Description
*------------
* Test Configure  Manage Test Configuration Tab Key Test Icon  Edit Key Test Pop up Screen Material Radio Button Properties
************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 10/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*MTC-MT-122           10/07/2023   M.Mathushan    Original Version
*
************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.commonmethods.Searching;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class TestConfigureManageTestConfigurationTabKeyTestIconEditKeyTestPopupScreenMaterialRadioButtonProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();
static String test =null;
	@Test

	public static void configureManageTestConfigurationTabKeyTestIconEditKeyTestPopupScreenSubCategoryRadioButtonProperties()
			throws InterruptedException, IOException {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

		// Navicate Test Config
		TestConfigNavigation.TestConfigurationCard();
		
		// Get the Data For Excel
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Manage_Tests", "MTC-MT-122-01");

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
		
		//Click the Key Test Icon 
		managetestconfigurationtabkeytesticonclick();
		
		//Check the Manage Test Configuration TabKey Test Icon Properties
		manageTestConfigurationTabKeyTestIconEditKeyTestPopupScreenMaterialRadioButtonProperties();

		// Click the Refresh
		driver.navigate().refresh();

		// Click Logout
		Logout.LogoutFunction();
	}

	public static void manageTestConfigurationTabKeyTestIconEditKeyTestPopupScreenMaterialRadioButtonProperties() {
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getIconPPt("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-122-02",ManageTestsPage.testConfigureManageTestConfigurationTabeditKeytestmaterialradiobuttonProperties,
				"Step-4--Test Configure Manage Test Configuration Tab Manage configure Tab Key Test Material Radio Button Properties");
	}
	
	public static void managetestconfigurationtabkeytesticonclick() throws InterruptedException {
		//Searching Value
				Searching.searchvalue(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0), 1);
		Thread.sleep(1000);
		 try {
			driver.findElement(By.xpath("//tbody//td[text()='"
					+TestConfiRev_MaterialSubHeadingProperties.adddata.get(0)+ "']//following-sibling::td[1]"))
					.click();
			testCase=extent.createTest("Managetest Configuration Tab Key Icon Is Click");
			testCase.log(Status.PASS,"Test Pass");
		} catch (NoSuchElementException e) {
			testCase=extent.createTest("Managetest Configuration Tab  Key Icon Is Not Visible");
			testCase.log(Status.FAIL,"Test Fail");
		} catch (ElementClickInterceptedException e) {
			testCase=extent.createTest("Managetest Configuration Tab  Key Icon  Is Not Click");
			testCase.log(Status.FAIL,"Test Fail");
		}catch (Exception e) {
			testCase=extent.createTest("Managetest Configuration Tab  Key Icon  Is Not Click");
			testCase.log(Status.FAIL,"Test Fail");
		}
	}
	
}


