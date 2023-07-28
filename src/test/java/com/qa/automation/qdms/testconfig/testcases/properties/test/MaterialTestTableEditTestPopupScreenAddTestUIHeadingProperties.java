/**********************************************************************************
* Description
*------------
*Test - Material Test Table "Edit Test" Pop up Screen Add Test UI Heading Properties
************************************************************************************
*
* Author           : Shobika Raveendran
* Date Written     : 15/07/2023
* 
*
* 
* Test Case Number       Date         Author        Comments
* ================       ====         =====        ========
* TC-Test-0064          15/07/2023    Shobika      Original Version
*
*******************************************************************************/
package com.qa.automation.qdms.testconfig.testcases.properties.test;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.automation.qdms.base.DriverIntialization;
import com.qa.automation.qdms.commonmethods.Logout;
import com.qa.automation.qdms.commonmethods.PropertiesCommonMethods;
import com.qa.automation.qdms.testcases.login.LoginTest;
import com.qa.automation.qdms.testconfig.commonmethods.TestConfigNavigation;
import com.qa.automation.qdms.testconfig.pages.TestConfigPage;
import com.qa.automation.qdms.testconfig.testcases.properties.testconfigure.TestConfiRev_MaterialSubHeadingProperties;

public class MaterialTestTableEditTestPopupScreenAddTestUIHeadingProperties extends DriverIntialization {
	static TestConfigPage edittestpopheading = new TestConfigPage();
	static String data;

	@Test
	public static void MaterialTestTableEditTestPopupScreenAddTestUIHeadingPropertie()
			throws InterruptedException, IOException {
		// login test
		LoginTest.Login();
		// Navigation to TestConfiguration
		TestConfigNavigation.TestConfigurationCard();
		TestConfiRev_MaterialSubHeadingProperties.dataExcel("Test", "TC-Test-0064-01");
		// icon properties
		editPopupHeading(TestConfiRev_MaterialSubHeadingProperties.adddata.get(0));
		//refresh 
		driver.navigate().refresh();
		// Logout
		Logout.LogoutFunction();


	}

	public static void editPopupHeading(String data) {
		try {
			driver.findElement(By.xpath("//td[text()='" + data + "']//following-sibling::td[1]/span/a[1]")).click();
			Thread.sleep(2000);
			editPopupheading();

		} catch (NoSuchElementException e) {
			testCase = extent.createTest("Checking Edit Icon");
			testCase.log(Status.INFO, "Unable to Locate the element 'Checking Edit Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");

		} catch (ElementClickInterceptedException e) {
			testCase = extent.createTest("Checking Edit Icon Icon");
			testCase.log(Status.INFO, "Unable to Click on the element 'Checking Edit Icon Icon'");
			testCase.log(Status.FAIL, "TEST FAIL ");

		} catch (Exception e) {
			testCase = extent.createTest("Checking The Edit Icon");
			testCase.log(Status.FAIL, "TEST FAIL ");
			System.out.println(e.toString());
		}

	}

	public static void editPopupheading() {
		PageFactory.initElements(driver, edittestpopheading);
		// heading Properties
		PropertiesCommonMethods.getTextPropertiesq("Test Configuration Properties.xlsx", "Test", "TC-Test-0064-02",
				TestConfigPage.edittestpopheading, "Material Test Table Edit  pop-up screen heading Properties");

	}
}
