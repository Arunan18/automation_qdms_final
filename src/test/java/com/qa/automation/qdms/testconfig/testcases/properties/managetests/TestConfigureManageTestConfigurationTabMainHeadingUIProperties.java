/**********************************************************************************************************************************************
* Description
*------------
* Test Configure  Manage Test Configuration Tab Main Heading UI Properties  
************************************************************************************************************************************************
*
* Author           : M.Mathushan
* Date Written     : 07/07/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*MTC-MT-109           07/07/2023   M.Mathushan    Original Version
*
************************************************************************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.managetests;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.sample.commonmethods.ActionCommonMethod;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.ManageTestsPage;
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class TestConfigureManageTestConfigurationTabMainHeadingUIProperties extends DriverIntialization {
	static ManageTestsPage mtp = new ManageTestsPage();

	@Test

	public static void configureManageTestConfigurationTabMainHeadingUIProperties() throws InterruptedException, IOException {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

        //Navicate Test Config
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
	//Check the Test Configure Manage Test Configuration Tab Main Header Button Properties
		manageTestConfigurationTabMainHeadingUIProperties();
		 
	// Click the Refresh
	 driver.navigate().refresh();

	// Click Logout
	 Logout.LogoutFunction();
}

	public static void manageTestConfigurationTabMainHeadingUIProperties() {
		PageFactory.initElements(driver, mtp);
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Manage_Tests",
				"MTC-MT-109-02", ManageTestsPage.testConfigureManageTestConfigurationTabmainHeadingUIProperties,
				"Step-4--Test Configure Manage Test Configuration Tab Manage configure Test Main Heading Properties");
	}
}


