/***********************************************************************************
* Description
*------------
Test Configure - Config Group Test- Site Button  Properties

*****************************************************
*
* Author           : S.Quenthan
* Date Written     : 26/06/2023
* 
*
* 
* Test Case Number       Date         Intis        Comments
* ================       ====         =====        ========
*TC-CGT-0024           26/06/2023   Quenthan     Orginal Version
*
************************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.configgrouptest;



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
import com.qa.automation.qdms.testconfig.pages.configGroupTestsPage;

public class ConfigGroupTestSiteButton extends DriverIntialization {

	@Test
	public void propertiesChecking() throws InterruptedException, IOException {

//	nvication
		ConfigGroupTestSiteButton.navicationToPath();

//		Check Properties
		propertiesConfigGroupTestSiteButton();

		Logout.LogoutFunction();

	}

	public static void propertiesConfigGroupTestSiteButton() {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);

		PropertiesCommonMethods.getButtonPropertiesq("Test Configuration Properties.xlsx", "Config_Group_Test",
				"TC-CGT-0024-02", configGroupTestsPage.ConfigGroupTestSiteButton,
				"Step-4-- Config Group Test- Site Button Properties");

	}

	public static void navicationToPath() throws InterruptedException, IOException {

		configGroupTestsPage lk = new configGroupTestsPage();
		PageFactory.initElements(driver, lk);
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// login
		LoginTest.Login();

//		Navicate Test Config
		TestConfigNavigation.TestConfigurationCard();

		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(configGroupTestsPage.mainTestNavication));
			ActionCommonMethod.visbleEnable2(configGroupTestsPage.mainTestNavication,
					"Manage Tests Configure Navication", 1);
			configGroupTestsPage.mainTestNavication.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		}
		
		try {
			// Navicate Manage Test Config
			wait.until(ExpectedConditions.elementToBeClickable(configGroupTestsPage.ConfigGroupTestSiteButton));
			ActionCommonMethod.visbleEnable2(configGroupTestsPage.ConfigGroupTestSiteButton,
					"Manage Tests Configure Navication", 2);
			configGroupTestsPage.ConfigGroupTestSiteButton.click();
		} catch (NoSuchElementException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (ElementClickInterceptedException e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		} catch (Exception e) {
			PropertiesCommonMethods.cTestReports("Test Clicking", true, false, e.toString());
		}

	}

}
